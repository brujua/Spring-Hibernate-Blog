package ar.edu.unlu.cursos.spring.m06.service;


import ar.edu.unlu.cursos.spring.m06.entity.Tag;
import ar.edu.unlu.cursos.spring.m06.repos.TagsRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.Optional;

@Service
public class TagsServiceImpl implements TagsService {

    private final TagsRepository tagsRepository;

    @Inject
    public TagsServiceImpl(TagsRepository tagsRepository) {
        this.tagsRepository = tagsRepository;
    }

    @Override
    public Optional<Tag> searchId(Long id) {
        return tagsRepository.findById(id);
    }

    @Override
    public void insert(Tag tag) {
        tagsRepository.save(tag);
    }

    @Override
    public void remove(Tag tag) {
        tagsRepository.delete(tag);
    }

    @Override
    public void update(Tag tag) {
        tagsRepository.save(tag);
    }
}
