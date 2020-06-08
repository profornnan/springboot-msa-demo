package msa.user.service;

import msa.user.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findByUserId(String id);
}
