package com.pavelnazaro.zbrain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {
    private UsersRepository usersRepository;

    @Autowired
    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public List<Users> findByEmail(String email){
        return usersRepository.findByEmail(email);
    }

    public void save(Users users){
        usersRepository.save(users);
    }
}
