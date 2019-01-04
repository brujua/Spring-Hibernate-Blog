package ar.edu.unlu.cursos.spring.m06.repos;


import ar.edu.unlu.cursos.spring.m06.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentsRepository extends JpaRepository<Comment, Long> {

}
