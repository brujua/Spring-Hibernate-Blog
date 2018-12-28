package ar.edu.unlu.cursos.spring.m06.service;

import ar.edu.unlu.cursos.spring.m06.entity.Tag;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface TagsService {

    Optional<Tag> searchId(Long id);

    @Transactional
    void insert(Tag tag);

    @Transactional
    void remove(Tag tag);

    @Transactional
    void update(Tag tag);
}
