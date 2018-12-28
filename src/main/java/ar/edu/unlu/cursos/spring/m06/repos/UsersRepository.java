package ar.edu.unlu.cursos.spring.m06.repos;

import ar.edu.unlu.cursos.spring.m06.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Long> {

    Optional<User> findByMail(String mail);

    List<User> findByNameContaining(String name);


}