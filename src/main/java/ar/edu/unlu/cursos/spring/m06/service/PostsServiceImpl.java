package ar.edu.unlu.cursos.spring.m06.service;

import ar.edu.unlu.cursos.spring.m06.entity.Post;
import ar.edu.unlu.cursos.spring.m06.entity.Tag;
import ar.edu.unlu.cursos.spring.m06.entity.User;
import ar.edu.unlu.cursos.spring.m06.repos.PostsRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostsServiceImpl implements PostsService {

    private final PostsRepository postsRepository;

    @Inject
    public PostsServiceImpl(PostsRepository postsRepository) {
        this.postsRepository = postsRepository;
    }

    @Override
    public List<Post> searchByUser(User user) {
        return postsRepository.findByUser(user);
    }

    @Override
    public List<Post> searchByTag(Tag tag) {
        ArrayList<Tag> tags = new ArrayList<>();
        tags.add(tag);
        return postsRepository.findByTagsOrderByCreatedOnDesc(tags);
    }

    @Override
    public Optional<Post> searchId(Long id) {
        return postsRepository.findById(id);
    }

    @Override
    public List<Post> findAll() {
        return postsRepository.findAllByOrderByCreatedOnDesc();
    }

    @Transactional
    @Override
    public void insert(Post post) {
        postsRepository.save(post);
    }

    @Transactional
    @Override
    public void remove(Post post) {
        postsRepository.delete(post);
    }

    @Transactional
    @Override
    public void update(Post post) {
        postsRepository.save(post);
    }
}
