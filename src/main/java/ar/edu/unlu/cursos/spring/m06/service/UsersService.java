package ar.edu.unlu.cursos.spring.m06.service;

import ar.edu.unlu.cursos.spring.m06.entity.User;
import org.springframework.transaction.annotation.Transactional;

public interface UsersService {

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
