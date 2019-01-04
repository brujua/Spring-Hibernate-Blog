package ar.edu.unlu.cursos.spring.m06.service;


import ar.edu.unlu.cursos.spring.m06.entity.Tag;
import ar.edu.unlu.cursos.spring.m06.repos.TagsRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TagsServiceImpl implements TagsService {

    private final TagsRepository tagsRepository;

    @Inject
    public TagsServiceImpl(TagsRepository tagsRepository) {
        this.tagsRepository = tagsRepository;
    }

    @Override
    public Optional<Tag> searchId(long id) {
        return tagsRepository.findById(id);
    }

    @Override
    public List<Tag> getOrCreateByNameInBulk(String[] tagNames) {
        List<Tag> tags = new ArrayList<>();
        for (String tagN : tagNames) {
            Tag tag;
            Optional<Tag> oTag = tagsRepository.findTagByName(tagN);
            if (!oTag.isPresent()) {
                tag = new Tag();
                tag.setName(tagN);
                insert(tag);
            } else
                tag = oTag.get();
            tags.add(tag);
        }
        return tags;
    }

    @Transactional
    @Override
    public void insert(Tag tag) {
        tagsRepository.save(tag);
    }

    @Transactional
    @Override
    public void remove(Tag tag) {
        tagsRepository.delete(tag);
    }

    @Transactional
    @Override
    public void update(Tag tag) {
        tagsRepository.save(tag);
    }
}
