package com.reddy.my_show.server.session;

import com.reddy.my_show.server.model.UserDetails;

/**
 * Created by varshini on 28/9/15.
 */
public class Session {

        private UserDetails userDetails					= null;




        // We will add any session specific data here

        public Session(UserDetails userDetails)
        {
            this.userDetails 	= userDetails;
        }


        /**
         * @return the userDetails
         */
        public UserDetails getUserDetails()
        {
            return userDetails;
        }

        /**
         * @param userDetails the userDetails to set
         */
        public void setUserDetails(UserDetails userDetails)
        {
            this.userDetails = userDetails;
        }

}
