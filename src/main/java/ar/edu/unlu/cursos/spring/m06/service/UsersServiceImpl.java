package ar.edu.unlu.cursos.spring.m06.service;


import ar.edu.unlu.cursos.spring.m06.Util.RandomString;
import ar.edu.unlu.cursos.spring.m06.entity.User;
import ar.edu.unlu.cursos.spring.m06.repos.UsersRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.Date;
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
    public Optional<User> searchByName(String name) {
        return usersRepository.findByName(name);
    }

    @Override
    public Optional<User> searchId(Long id) {
        return usersRepository.findById(id);
    }


    @Override
    public User byNameOrCreate(String name) {
        User user;
        Optional<User> opuser = usersRepository.findByMail(name);
        Date now = new Date();
        if (opuser.isPresent())
            user = opuser.get();
        else {
            user = new User();
            user.setMail(RandomString.generate(5) + "@gmail.com");
            user.setPass(RandomString.generate(12));
            user.setName(name);
            user.setCreatedOn(now);
            user.setModifiedOn(now);
            this.insert(user);
        }
        return user;
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
