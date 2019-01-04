package ar.edu.unlu.cursos.spring.m06.service;

import ar.edu.unlu.cursos.spring.m06.entity.Post;
import ar.edu.unlu.cursos.spring.m06.entity.Tag;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.fail;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class PostsServiceTest {
    @Inject
    private PostsService postsService;
    @Inject
    private TagsService tagsService;

    @Test
    public void searchId() {
        Optional<Post> oPost = postsService.searchId(1L);
        assert oPost.isPresent();
    }

    @Test
    public void searchByTag() {
        try {
            Tag tag = tagsService.searchId(1L).orElseThrow(RuntimeException::new);
            List<Post> posts = postsService.searchByTag(tag);
            for (Post post : posts) {
                assert post.getTags().contains(tag);
            }
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
}
