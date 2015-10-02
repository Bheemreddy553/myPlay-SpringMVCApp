package com.reddy.my_show.server.dao;

import com.reddy.my_show.common.MyShowException;
import com.reddy.my_show.server.model.Video;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by varshini on 1/10/15.
 */
@Repository
public class VideosDAO {
    private static final Logger logger = LoggerFactory.getLogger(VideosDAO.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public void uploadVideo(Video video)throws MyShowException{
        try {
            video.generate();
            Session session = sessionFactory.getCurrentSession();
            session.persist(video);
        }
        catch (Exception e){
            logger.info("upload error"+e.toString() +e.getMessage() + e.getCause() + e.getLocalizedMessage());
            throw new MyShowException("","insert error");
        }
    }

}
