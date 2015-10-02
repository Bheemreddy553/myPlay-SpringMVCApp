package com.reddy.my_show.server.service;

import com.reddy.my_show.common.MyShowException;
import com.reddy.my_show.server.dao.UserDetailsDAO;
import com.reddy.my_show.server.model.UserDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by varshini on 27/9/15.
 */
@Service
public class UserService {
    Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserDetailsDAO userDetailsDAO;


    public UserService(){}


    public void setUserDetailsDAO(UserDetailsDAO userDetailsDAO){
        this.userDetailsDAO = userDetailsDAO;
    }

    @Transactional
    public void addUser(UserDetails userDetails)throws MyShowException{
        userDetailsDAO.register(userDetails);
    }

    @Transactional
    public void getUserById(String userId)throws MyShowException{
        userDetailsDAO.getUserById(userId);
    }
}
