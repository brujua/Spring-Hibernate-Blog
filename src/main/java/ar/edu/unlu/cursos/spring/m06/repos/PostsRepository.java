package ar.edu.unlu.cursos.spring.m06.repos;

import ar.edu.unlu.cursos.spring.m06.entity.Post;
import ar.edu.unlu.cursos.spring.m06.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PostsRepository extends JpaRepository<Post, Long> {


    List<Post> findAllByOrderByCreatedOnDesc();

    List<Post> findByTagsOrderByCreatedOnDesc(List<Tag> tags);

}
