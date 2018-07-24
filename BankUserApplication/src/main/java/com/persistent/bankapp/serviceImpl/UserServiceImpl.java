package com.persistent.bankapp.serviceImpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.persistent.bankapp.dao.UserDao;
import com.persistent.bankapp.domain.User;
import com.persistent.bankapp.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {
private static final Logger LOG = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserDao userDao;
	
	
    @Autowired
    private PasswordEncoder passwordEncoder;
    

	
    public boolean checkUsernameExists(String username) {
        if (null != findByUsername(username)) {
            return true;
        }

        return false;
    }
    
	@Override
	public User findByUsername(String sUserName) {
		// TODO Auto-generated method stub
		return userDao.findByUsername(sUserName);
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		return userDao.save(user);
	}

	@Override
	public User createUser(User user) {
        User localUser = userDao.findByUsername(user.getUsername());

        if (localUser != null) {
            LOG.info("User with username {} already exist. Nothing will be done. ", user.getUsername());
        } else {
            String encryptedPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(encryptedPassword);

            localUser = userDao.save(user);
        }

        
		
		return localUser;
	}

	}
