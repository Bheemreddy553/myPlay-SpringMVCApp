package com.reddy.my_show.server.dao;

import com.reddy.my_show.common.MyShowException;
import com.reddy.my_show.server.Person;
import com.reddy.my_show.server.model.UserDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateJdbcException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.TransactionAnnotationParser;

import javax.transaction.Transactional;

/**
 * Created by varshini on 26/9/15.
 */
@Repository
public class UserDetailsDAO {
    Logger logger = LoggerFactory.getLogger(UserDetailsDAO.class);


    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }


    @Transactional
    public void register(UserDetails userDetails) throws MyShowException{
        try{
            Session session = sessionFactory.getCurrentSession();
            System.out.println("user   "+ userDetails.toString());
            session.persist(userDetails);
        }
        catch (HibernateJdbcException e){
            logger.info("error "+e);
        }
        catch (Exception e){
            logger.info("insert error"+ e);
            throw new MyShowException("","insert error");
        }
    }

    @Transactional
    public UserDetails getUserById(String id)throws  MyShowException{
        UserDetails userDetails = null;
        try{
            Session session = sessionFactory.getCurrentSession();
            userDetails = (UserDetails) session.load(Person.class, new Integer(id));
            logger.info("User loaded successfully, User details="+userDetails);
        }
        catch (HibernateJdbcException e){
            logger.info("error "+e);
        }
        catch (Exception e){
            logger.info("insert error"+ e);
            throw new MyShowException("","insert error");
        }
        return  userDetails;
    }

}
