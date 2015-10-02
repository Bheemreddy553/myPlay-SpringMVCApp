package com.reddy.my_show.server.dao;

import com.reddy.my_show.common.MyShowException;
import com.reddy.my_show.server.model.Login;
import com.reddy.my_show.server.model.UserDetails;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateJdbcException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by varshini on 28/9/15.
 */
@Repository
public class LoginDAO {


    private static final Logger logger = LoggerFactory.getLogger(LoginDAO.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public UserDetails getLoginDetails(Login login)throws MyShowException{
        UserDetails userDetails = new UserDetails();

        if(login == null){
            logger.info("empty object passed");
            throw new MyShowException("","empty object passed");
        }

        try{
            Session session = sessionFactory.getCurrentSession();
            if(session == null){
                logger.info("empty logger session");
                throw new  MyShowException("","empty session ");
            }
            Query query =  session.createQuery("from UserDetails WHERE email=:email AND password=:pass");
            if (query == null) {
                logger.info("query empty");
            }
            query.setString("email", login.getUserName());
            query.setString("pass",login.getPassword());
            List list = query.list();
            if(list == null || list.isEmpty() || list.size() > 1){
                logger.info("user not exit invalid user and password");
                throw  new MyShowException("","user not found");
            }
            if(list.get(0) != null) ;{
               userDetails =(UserDetails)  list.get(0);
            }
        }

        catch (HibernateJdbcException e){

            logger.info("hib query error"+ e.getSQLException());
        }
        catch (Exception e){
            e.printStackTrace();
            logger.info("query logger error"+e);
            throw new MyShowException("","query error" + e);
        }

        return userDetails;
    }
}
