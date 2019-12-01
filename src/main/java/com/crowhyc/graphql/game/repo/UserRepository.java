package com.crowhyc.graphql.game.repo;

import com.crowhyc.graphql.game.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * <p>
 * Description: com.crowhyc.graphql.game.repo
 * </p>
 * date：2019/12/1
 * email:crowhyc@163.com
 *
 * @author Dean.Hwang
 */
@Repository
public interface UserRepository extends JpaRepository<User, String> {
    <S extends User> S save(S s);


    Optional<User> findById(String primaryKey);

}
