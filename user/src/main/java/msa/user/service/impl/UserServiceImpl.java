package msa.user.service.impl;

import lombok.AllArgsConstructor;
import msa.user.model.User;
import msa.user.repository.UserRepository;
import msa.user.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findByUserId(String id) {
        return userRepository.findByUserId(id);
    }
}
