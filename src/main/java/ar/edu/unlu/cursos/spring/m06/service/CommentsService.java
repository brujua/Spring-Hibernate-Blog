package ar.edu.unlu.cursos.spring.m06.service;

import ar.edu.unlu.cursos.spring.m06.entity.Comment;
import ar.edu.unlu.cursos.spring.m06.entity.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface CommentsService {

    Optional<Comment> searchId(Long id);

    List<Comment> searchByUser(User user);

    @Transactional
    void insert(Comment comment);

    @Transactional
    void remove(Comment comment);

    @Transactional
    void update(Comment comment);
}
