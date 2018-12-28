package ar.edu.unlu.cursos.spring.m06.service;

import ar.edu.unlu.cursos.spring.m06.entity.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface UsersService {

    Optional<User> searchByMail(String mail);

    List<User> searchByName(String name);

    Optional<User> searchId(Long id);

    @Transactional
    void insert(User user);

    @Transactional
    void remove(User user);

    @Transactional
    void update(User user);

}
