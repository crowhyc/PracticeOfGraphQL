package com.crowhyc.graphql.game.service;

import com.crowhyc.graphql.game.model.User;
import com.crowhyc.graphql.game.repo.UserRepository;
import org.springframework.stereotype.Service;

/**
 * <p>
 * Description: com.crowhyc.graphql.game.service
 * </p>
 * date：2019/12/1
 * email:crowhyc@163.com
 *
 * @author Dean.Hwang
 */
@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public void saveUser(User user) {
        repository.save(user);
    }
}
