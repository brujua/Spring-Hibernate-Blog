package ar.edu.unlu.cursos.spring.m06.web;


import ar.edu.unlu.cursos.spring.m06.entity.Comment;
import ar.edu.unlu.cursos.spring.m06.entity.Post;
import ar.edu.unlu.cursos.spring.m06.entity.Tag;
import ar.edu.unlu.cursos.spring.m06.entity.User;
import ar.edu.unlu.cursos.spring.m06.service.CommentsService;
import ar.edu.unlu.cursos.spring.m06.service.PostsService;
import ar.edu.unlu.cursos.spring.m06.service.TagsService;
import ar.edu.unlu.cursos.spring.m06.service.UsersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/posts")
public class PostsController {
    private final PostsService postsService;
    private final TagsService tagsService;
    private final UsersService usersService;
    private final CommentsService commentsService;

    @Inject
    public PostsController(PostsService postsService, TagsService tagsService, UsersService usersService, CommentsService commentsService) {
        this.postsService = postsService;
        this.tagsService = tagsService;
        this.usersService = usersService;
        this.commentsService = commentsService;
    }

    @RequestMapping("")
    public String posts(Model model) {
        List<Post> posts = postsService.findAll();
        model.addAttribute("posts", posts);
        return "posts";
    }

    @RequestMapping(value = {"/{id}", "/{id}/addComment"})
    public String post(Model model, @PathVariable("id") long id) {
        Optional<Post> post = postsService.searchId(id);
        model.addAttribute("post", post.orElse(null));
        model.addAttribute("commentForm", new CommentForm());
        return "post";
    }

    @RequestMapping(value = "/{id}/addComment", method = RequestMethod.POST)
    public String addComment(
            Model model,
            @PathVariable("id") long id,
            @ModelAttribute("commentForm") @Valid CommentForm commentForm,
            BindingResult result) {
        Post post = postsService.searchId(id).orElseThrow(NoSuchPostExistException::new);
        model.addAttribute("post", post);

        if (result.hasErrors()) {
            return "post";
        }
        User user = usersService.byNameOrCreate(commentForm.getAuthor());

        Comment comment = new Comment();
        comment.setContent(commentForm.getComment());
        comment.setPost(post);
        comment.setUser(user);
        comment.setCreatedOn(new Date());
        comment.setModifiedOn(new Date());
        commentsService.insert(comment);


        return "redirect:/posts/" + post.getId();
    }

    @RequestMapping("/{id}/edit")
    public String editPost(Model model, @PathVariable("id") long id) {
        Optional<Post> oPost = postsService.searchId(id);
        Post post = oPost.orElseThrow(NoSuchPostExistException::new);
        model.addAttribute("post", post);
        model.addAttribute("postForm", new PostForm(post));
        return "edit-post";
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    public String editPost(
            Model model,
            @PathVariable("id") long id,
            @ModelAttribute("postForm") @Valid PostForm postForm,
            BindingResult result) {

        Post post = postsService.searchId(id).orElseThrow(NoSuchPostExistException::new);

        if (result.hasErrors()) {
            return "edit-post";
        }

        post.setTitle(postForm.getTitle());
        post.setTags(tagsService.getOrCreateByNameInBulk(postForm.getTags()));
        post.setContent(postForm.getContent());
        postsService.update(post);

        return "redirect:/posts/" + post.getId();
    }

    @RequestMapping("/new")
    public String newPost(Model model) {
        model.addAttribute("postForm", new PostForm());
        return "new-post";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String newPost(Model model,
                          @ModelAttribute("postForm") @Valid PostForm postForm,
                          BindingResult result) {

        if (result.hasErrors()) {
            return "new-post";
        }
        Post post = new Post();
        User user = usersService.byNameOrCreate(postForm.getAuthor());
        List<Tag> tags = tagsService.getOrCreateByNameInBulk(postForm.getTags());
        post.setUser(user);
        post.setTitle(postForm.getTitle());
        post.setContent(postForm.getContent());
        post.setTags(tags);
        postsService.insert(post);

        model.addAttribute("post", post);

        return "redirect:/posts/" + post.getId();

    }
}
