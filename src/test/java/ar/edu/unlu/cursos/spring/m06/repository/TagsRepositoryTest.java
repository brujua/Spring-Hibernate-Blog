package ar.edu.unlu.cursos.spring.m06.repository;

import ar.edu.unlu.cursos.spring.m06.entity.Tag;
import ar.edu.unlu.cursos.spring.m06.repos.TagsRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class TagsRepositoryTest {
    @Inject
    private TagsRepository tagsRepository;

    @Test
    public void findTagByName() {
        String name = "gaming";
        Optional<Tag> oTag = tagsRepository.findTagByName(name);

        assert oTag.isPresent();
        assert oTag.get().getName().equals(name);
    }
}
