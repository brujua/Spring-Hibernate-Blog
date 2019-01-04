package ar.edu.unlu.cursos.spring.m06.service;


import ar.edu.unlu.cursos.spring.m06.entity.Comment;
import ar.edu.unlu.cursos.spring.m06.repos.CommentsRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.transaction.Transactional;

@Service
public class CommentsServiceImpl implements CommentsService {

    private final CommentsRepository commentsRepository;

    @Inject
    public CommentsServiceImpl(CommentsRepository commentsRepository) {
        this.commentsRepository = commentsRepository;
    }

    @Transactional
    @Override
    public void insert(Comment comment) {
        commentsRepository.save(comment);
    }

    @Transactional
    @Override
    public void remove(Comment comment) {
        commentsRepository.delete(comment);
    }

    @Transactional
    @Override
    public void update(Comment comment) {
        commentsRepository.save(comment);
    }
}
