package ar.edu.unlu.cursos.spring.m06.repository;

import ar.edu.unlu.cursos.spring.m06.entity.Post;
import ar.edu.unlu.cursos.spring.m06.entity.Tag;
import ar.edu.unlu.cursos.spring.m06.repos.PostsRepository;
import ar.edu.unlu.cursos.spring.m06.repos.UsersRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

/**
 * this tests are tightly couple with the database migration seed for convenience
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class PostRepositoryTest {
    @Inject
    private UsersRepository usersRepository;
    @Inject
    private PostsRepository postsRepository;

    @Test
    public void findAllOrderedByCreatedOnDesc() {
        List<Post> posts = postsRepository.findAllByOrderByCreatedOnDesc();
        assert (!posts.isEmpty());
        for (int i = 0; i < posts.size() - 1; i++) {
            Post post = posts.get(i);
            Post nextPost = posts.get(i + 1);
            assert (post.getCreatedOn().compareTo(nextPost.getCreatedOn()) >= 0);
        }
    }

    @Test
    public void findByTagsOrderByCreatedOnDesc() {
        Post post = postsRepository.findById(1L).get();
        List<Tag> tags = post.getTags();
        assert (!tags.isEmpty());
        List<Post> retrievedPosts = postsRepository.findByTagsOrderByCreatedOnDesc(tags);
        assert (retrievedPosts.contains(post));
        for (Post postAux : retrievedPosts) {
            for (Tag tagAux : tags) {
                assert postAux.getTags().contains(tagAux);
            }
        }
    }


}
