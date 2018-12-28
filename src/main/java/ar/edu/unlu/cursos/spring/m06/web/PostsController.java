package ar.edu.unlu.cursos.spring.m06.web;


import ar.edu.unlu.cursos.spring.m06.entity.Post;
import ar.edu.unlu.cursos.spring.m06.service.PostsService;
import ar.edu.unlu.cursos.spring.m06.service.TagsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;
import java.util.List;

@Controller
@RequestMapping("/posts")
public class PostsController {
    private final PostsService postsService;
    private final TagsService tagsService;

    @Inject
    public PostsController(PostsService postsService, TagsService tagsService) {
        this.postsService = postsService;
        this.tagsService = tagsService;
    }

    public String posts(Model model) {
        List<Post> posts = postsService.findAll();
        model.addAttribute("posts", posts);
        return "posts";
    }
}
