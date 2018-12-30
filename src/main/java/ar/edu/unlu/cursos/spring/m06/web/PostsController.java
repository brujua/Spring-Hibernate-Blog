package ar.edu.unlu.cursos.spring.m06.web;


import ar.edu.unlu.cursos.spring.m06.Util.RandomString;
import ar.edu.unlu.cursos.spring.m06.entity.Comment;
import ar.edu.unlu.cursos.spring.m06.entity.Post;
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

    @RequestMapping("/{id}")
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
        User user;
        /*        TODO since there is no User validation in place, if the author introduced doesn't correspond
        with a valid user name, we just create an user.*/
        Optional<User> opuser = usersService.searchByName(commentForm.getAuthor());
        Date now = new Date();
        if (opuser.isPresent())
            user = opuser.get();
        else {
            user = new User();
            user.setMail(RandomString.generate(5) + "@gmail.com");
            user.setPass(RandomString.generate(12));
            user.setName(commentForm.getAuthor());
            user.setCreatedOn(now);
            user.setModifiedOn(now);
            usersService.insert(user);
        }
        Comment comment = new Comment();
        comment.setContent(commentForm.getComment());
        comment.setPost(post);
        comment.setUser(user);
        comment.setCreatedOn(new Date());
        comment.setModifiedOn(new Date());
        commentsService.insert(comment);


        model.addAttribute("commentForm", new CommentForm());
        return "post";
    }
}
