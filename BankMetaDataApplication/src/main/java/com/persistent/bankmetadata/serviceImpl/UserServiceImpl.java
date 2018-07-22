package com.persistent.bankmetadata.serviceImpl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.persistent.bankmetadata.Dao.UserDao;
import com.persistent.bankmetadata.domain.User;
import com.persistent.bankmetadata.service.UserService;

import java.util.List;


@Service
@Transactional
public class UserServiceImpl implements UserService {

     @Autowired
    private UserDao userDao;


    public void save(User user) {
        userDao.save(user);
    }

    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    public boolean checkUsernameExists(String username) {
        if (null != findByUsername(username)) {
            return true;
        }

        return false;
    }

    public User saveUser (User user) {
        return userDao.save(user);
    }

    public List<User> findUserList() {
        return userDao.findAll();
    }

}
