package ar.edu.unlu.cursos.spring.m06.service;

import ar.edu.unlu.cursos.spring.m06.entity.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface UsersService {

    Optional<User> searchByMail(String mail);

    Optional<User> searchByName(String name);

    Optional<User> searchId(Long id);

    /**
     * <b>Temporary!</b> This method will change or disappear in the future.
     *
     * @return a user with that name
     */
    //TODO remove when implementing real user session control
    User byNameOrCreate(String name);

    @Transactional
    void insert(User user);

    @Transactional
    void remove(User user);

    @Transactional
    void update(User user);

}
