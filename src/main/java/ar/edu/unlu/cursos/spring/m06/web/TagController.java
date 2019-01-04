package ar.edu.unlu.cursos.spring.m06.web;

import ar.edu.unlu.cursos.spring.m06.entity.Post;
import ar.edu.unlu.cursos.spring.m06.entity.Tag;
import ar.edu.unlu.cursos.spring.m06.service.PostsService;
import ar.edu.unlu.cursos.spring.m06.service.TagsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/tag")
public class TagController {

    private final TagsService tagsService;
    private final PostsService postsService;

    @Inject
    public TagController(TagsService tagsService, PostsService postsService) {
        this.tagsService = tagsService;
        this.postsService = postsService;
    }

    @RequestMapping("/{id}")
    public String tag(Model model, @PathVariable("id") long id) {
        Optional<Tag> oTag = tagsService.searchId(id);
        Tag tag = oTag.orElseThrow(NoSuchTagExistException::new);
        List<Post> posts = postsService.searchByTag(tag);
        model.addAttribute("posts", posts);
        return "posts";
    }
}
