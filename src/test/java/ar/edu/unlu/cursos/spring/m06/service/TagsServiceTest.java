package ar.edu.unlu.cursos.spring.m06.service;

import ar.edu.unlu.cursos.spring.m06.entity.Tag;
import ar.edu.unlu.cursos.spring.m06.repos.TagsRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class TagsServiceTest {
    @Inject
    private TagsService tagsService;
    @Inject
    private TagsRepository tagsRepository;

    @Test
    public void searchId() {
        Optional<Tag> oTag = tagsService.searchId(1L);
        assert oTag.isPresent();
    }

    @Test
    public void getOrCreateByNameInBulk() {
        String[] newAndOldTagNames = {"gaming", "racing", "trending"};
        List<Tag> tags = tagsService.getOrCreateByNameInBulk(newAndOldTagNames);
        List<Tag> allTags = tagsRepository.findAll();

        assert tags.size() == newAndOldTagNames.length;
        for (Tag tag : tags) {
            assert allTags.contains(tag);
            assert Arrays.asList(newAndOldTagNames).contains(tag.getName());
        }


    }

}
