package ar.edu.unlu.cursos.spring.m06.repos;

import ar.edu.unlu.cursos.spring.m06.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TagsRepository extends JpaRepository<Tag, Long> {
}
