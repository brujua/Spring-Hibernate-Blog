package ar.edu.unlu.cursos.spring.m06.service;


import ar.edu.unlu.cursos.spring.m06.entity.Comment;
import ar.edu.unlu.cursos.spring.m06.entity.User;
import ar.edu.unlu.cursos.spring.m06.repos.CommentsRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

@Service
public class CommentsServiceImpl implements CommentsService {

    private final CommentsRepository commentsRepository;

    @Inject
    public CommentsServiceImpl(CommentsRepository commentsRepository) {
        this.commentsRepository = commentsRepository;
    }


    @Override
    public Optional<Comment> searchId(Long id) {
        return commentsRepository.findById(id);
    }

    @Override
    public List<Comment> searchByUser(User user) {
        return commentsRepository.findByUser(user);
    }

    @Override
    public void insert(Comment comment) {
        commentsRepository.save(comment);
    }

    @Override
    public void remove(Comment comment) {
        commentsRepository.delete(comment);
    }

    @Override
    public void update(Comment comment) {
        commentsRepository.save(comment);
    }
}
