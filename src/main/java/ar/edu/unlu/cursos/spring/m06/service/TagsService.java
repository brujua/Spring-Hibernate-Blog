package ar.edu.unlu.cursos.spring.m06.service;

import ar.edu.unlu.cursos.spring.m06.entity.Tag;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TagsService {


    List<Tag> getOrCreateByNameInBulk(String[] tagNames);

    @Transactional
    void insert(Tag tag);

    @Transactional
    void remove(Tag tag);

    @Transactional
    void update(Tag tag);
}
