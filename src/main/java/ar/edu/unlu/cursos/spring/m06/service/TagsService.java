package ar.edu.unlu.cursos.spring.m06.service;

import ar.edu.unlu.cursos.spring.m06.entity.Tag;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface TagsService {


    List<Tag> getOrCreateByNameInBulk(String[] tagNames);

    Optional<Tag> searchId(long id);

    @Transactional
    void insert(Tag tag);

    @Transactional
    void remove(Tag tag);

    @Transactional
    void update(Tag tag);
}
