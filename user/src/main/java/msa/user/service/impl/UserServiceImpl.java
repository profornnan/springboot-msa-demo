package msa.user.service.impl;

import msa.user.model.User;
import msa.user.repository.UserRepository;
import msa.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findByUserId(String id) {
        return userRepository.findByUserId(id);
    }
}
