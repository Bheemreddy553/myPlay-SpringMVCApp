package com.reddy.my_show.server.datasource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by varshini on 22/9/15.
 */
public interface MyShowDatabase {

    public  Connection getConnection()throws SQLException;

    public void closeConnection(Connection connection)throws SQLException;

}
