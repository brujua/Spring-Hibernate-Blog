package ar.edu.unlu.cursos.spring.m06.repos;


import ar.edu.unlu.cursos.spring.m06.entity.Comment;
import ar.edu.unlu.cursos.spring.m06.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentsRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByUser(User user);
}
