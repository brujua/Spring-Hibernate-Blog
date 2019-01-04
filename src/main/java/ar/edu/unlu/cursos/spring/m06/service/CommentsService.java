package ar.edu.unlu.cursos.spring.m06.service;

import ar.edu.unlu.cursos.spring.m06.entity.Comment;
import org.springframework.transaction.annotation.Transactional;

public interface CommentsService {

    @Transactional
    void insert(Comment comment);

    @Transactional
    void remove(Comment comment);

    @Transactional
    void update(Comment comment);
}
