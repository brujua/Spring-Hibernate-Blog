package ar.edu.unlu.cursos.spring.m06.service;


import ar.edu.unlu.cursos.spring.m06.Util.RandomString;
import ar.edu.unlu.cursos.spring.m06.entity.User;
import ar.edu.unlu.cursos.spring.m06.repos.UsersRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.transaction.Transactional;
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
    public User byNameOrCreate(String name) {
        User user;
        Optional<User> opuser = usersRepository.findByName(name);
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

    @Transactional
    @Override
    public void insert(User user) {
        usersRepository.save(user);
    }

    @Transactional
    @Override
    public void remove(User user) {
        usersRepository.deleteById(user.getId());
    }

    @Transactional
    @Override
    public void update(User user) {
        usersRepository.save(user);
    }
}
