package ar.edu.unlu.cursos.spring.m06.service;


import ar.edu.unlu.cursos.spring.m06.entity.User;
import ar.edu.unlu.cursos.spring.m06.repos.UsersRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

@Service
public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;

    @Inject
    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }


    @Override
    public Optional<User> searchByMail(String mail) {
        return usersRepository.findByMail(mail);
    }

    @Override
    public List<User> searchByName(String name) {
        return usersRepository.findByNameContaining(name);
    }

    @Override
    public Optional<User> searchId(Long id) {
        return usersRepository.findById(id);
    }

    @Override
    public void insert(User user) {
        usersRepository.save(user);
    }

    @Override
    public void remove(User user) {
        usersRepository.deleteById(user.getId());
    }

    @Override
    public void update(User user) {
        usersRepository.save(user);
    }
}
