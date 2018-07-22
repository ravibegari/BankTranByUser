package com.persistent.bankmetadata.service;




import java.util.List;

import com.persistent.bankmetadata.domain.User;



public interface UserService {

    User findByUsername(String username);

    boolean checkUsernameExists(String username);

    void save(User user);

    User saveUser(User user);

    List<User> findUserList();


}
