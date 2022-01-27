package com.endava.apache;

import com.endava.google.GsonExample;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.List;

public class DBConnection {
    private static final Logger LOGGER = LogManager.getLogger(DBConnection.class);
    public static void main(String[] args) throws SQLException {
        Connection connection= DriverManager.getConnection("jdbc:mysql://bhdtest.endava.com:3306/petclinic",
                "root","root");
        Statement statement=connection.createStatement();
        ResultSet resultSet=statement.executeQuery("SELECT id,first_name FROM owners WHERE ID=5");
        LOGGER.info(resultSet);
        while (resultSet.next()){
            Integer id = resultSet.getInt("id");
            String first_name = resultSet.getString("first_name");
        LOGGER.info("{} {}",id,first_name);
        }

    }
}
