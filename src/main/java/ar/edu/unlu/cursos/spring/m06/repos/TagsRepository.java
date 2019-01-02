package ar.edu.unlu.cursos.spring.m06.repos;

import ar.edu.unlu.cursos.spring.m06.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface TagsRepository extends JpaRepository<Tag, Long> {
    Optional<Tag> findTagByName(String name);
}
