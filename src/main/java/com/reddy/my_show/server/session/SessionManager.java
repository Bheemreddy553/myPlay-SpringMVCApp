package com.reddy.my_show.server.session;

import com.reddy.my_show.common.MyShowException;
import com.reddy.my_show.server.dao.LoginDAO;
import com.reddy.my_show.server.model.Login;
import com.reddy.my_show.server.model.UserDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by varshini on 28/9/15.
 */
@Service
public class SessionManager {
   private static final Logger logger= LoggerFactory.getLogger(SessionManager.class);

    @Autowired
    private LoginDAO loginDAO;

    private Map<String, Session> sessionManager = new HashMap<String,Session>();
    private Map<String, Session> adminSessionManager = new HashMap<String,Session>();

    @Autowired
    public void setLoginDAO(LoginDAO loginDAO){
        this.loginDAO = loginDAO;
    }

    private String GenerateUniqueSessionID(boolean isItForAdmin)
    {
        UUID sessionID = null;
        String sessionIDStr = null;

        // Check if there are any existing sessions with this sessionID
        while(true)
        {
            sessionID = UUID.randomUUID();
            if(null != sessionID)
                sessionIDStr = sessionID.toString();
            if(null != sessionIDStr)
            {
                if((false == isItForAdmin) && (false == sessionManager.containsKey(sessionIDStr)))
                    break;
                else if((true == isItForAdmin) && (false == adminSessionManager.containsKey(sessionIDStr)))
                    break;
            }
        }

        return sessionIDStr;
    }


    public String createUserSession(Login login) throws MyShowException {
        if(null != login.getUserName() && null != login.getPassword() && !login.getUserName().isEmpty() && !login.getPassword().isEmpty()) {
            UserDetails userDetails = loginDAO.getLoginDetails(login);
            String sessionID = this.GenerateUniqueSessionID(false);
            this.sessionManager.put(sessionID, new Session(userDetails));
            return sessionID;
        } else {
            StringBuffer errorStr = new StringBuffer();
            errorStr.append("Either login name or password is empty");
            logger.error(errorStr.toString());
            throw new MyShowException("", errorStr.toString());
        }
    }

    public Session getUserSession(String sessionID)
    {
        return sessionManager.get(sessionID);
    }

    public Session getAdminSession(String sessionID)
    {
        return adminSessionManager.get(sessionID);
    }

    public void updateSession(String sessionID) {
        // Is this required - lets review this later
    }

    public void deleteUserSession(String sessionID)
    {
        sessionManager.remove(sessionID);
    }

    public void deleteAdminSession(String sessionID)
    {
        adminSessionManager.remove(sessionID);
    }
}
