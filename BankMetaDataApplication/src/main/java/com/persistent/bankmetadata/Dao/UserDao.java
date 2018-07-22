package com.persistent.bankmetadata.Dao;





import org.springframework.data.repository.CrudRepository;

import com.persistent.bankmetadata.domain.User;

import java.util.List;

public interface UserDao extends CrudRepository<User, Long> {

    User findByUsername(String username);

    List<User> findAll();
}
