package ar.edu.unlu.cursos.spring.m06.service;

import ar.edu.unlu.cursos.spring.m06.entity.Post;
import ar.edu.unlu.cursos.spring.m06.entity.Tag;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


public interface PostsService {

    List<Post> searchByTag(Tag tag);

    Optional<Post> searchId(Long id);

    List<Post> findAll();

    @Transactional
    void insert(Post post);

    @Transactional
    void remove(Post post);

    @Transactional
    void update(Post post);

}
