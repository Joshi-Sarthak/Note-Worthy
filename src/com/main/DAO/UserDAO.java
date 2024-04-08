package com.main.DAO;

import com.main.model.User;

import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Harsh Itkar
 */

public class UserDAO {
    PreparedStatement pst;
    ResultSet rs;
    Connection con;
    DataBaseConnector dataBaseConnector = new DataBaseConnector();

    public Boolean auth(String username, String password) {
        String expectedPassword = "";
        try{
            con = dataBaseConnector.connect();
            rs = con.prepareStatement("SELECT * FROM user WHERE username = '" + username +"';").executeQuery();
            if(rs.next()){
                expectedPassword = rs.getString("password");
            }
            if(password.equals(expectedPassword)) {
                return true;
            }
        } catch(HeadlessException | SQLException ex){
            System.out.println(ex);
        }finally {
            try {
                if(con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public boolean addUser(String username, String email,String password, String name) {
        try{
            con = dataBaseConnector.connect();
            try {
                con.prepareStatement("insert into user values('" + email +"', '" + username + "', '" + password + "', '" + name + "');").executeUpdate();
            } catch (SQLException e) {
                return false;
            }
        } catch(HeadlessException ex){
            System.out.println(ex);
        }finally {
            try {
                if(con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    public boolean isUsernameAvailable(String username) {
        try{
            con = dataBaseConnector.connect();
            pst = con.prepareStatement("SELECT * FROM user WHERE userName = '" + username +"';");
            rs = pst.executeQuery();
            if(!rs.next()){
                return true;
            }
        } catch(HeadlessException | SQLException ex){
            System.out.println(ex);
        }finally {
            try {
                if(con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public boolean isEmailRegistered(String email) {
        try{
            con = dataBaseConnector.connect();
            pst = con.prepareStatement("SELECT * FROM user WHERE email = ?;");
            pst.setString(1, email);
            rs = pst.executeQuery();
            if(rs.next()){
                return true;
            }
        } catch(HeadlessException | SQLException ex){
            System.out.println(ex);
        }finally {
            try {
                if(con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public String getCurrentUsername(String email) {
        try{
            con = dataBaseConnector.connect();
            pst = con.prepareStatement("SELECT * FROM user WHERE email = ?;");
            pst.setString(1, email);
            rs = pst.executeQuery();
            if(rs.next()){
                return rs.getString("username");
            }
        } catch(HeadlessException | SQLException ex){
            System.out.println(ex);
        }finally {
            try {
                if(con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public User getCurrentUser(String currentUsername) {
        String name = new String();
        String email = new String();
        try{
            con = dataBaseConnector.connect();
            pst = con.prepareStatement("SELECT * FROM user WHERE userName = '" + currentUsername +"';");
            rs = pst.executeQuery();
            rs.next();
            name = rs.getString("name");
            email = rs.getString("email");
        } catch(HeadlessException | SQLException ex){
            System.out.println(ex);
        }finally {
            try {
                if(con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return new User(currentUsername, name, email);
    }

    public boolean updateCurrentUserDetails(User user) {
        try{
            con = dataBaseConnector.connect();
            pst = con.prepareStatement("update `user` set name = ?, email = ? where username = ?;");
            pst.setString(1, user.getName());
            pst.setString(2, user.getEmail());
            pst.setString(3, user.getCurrentUsername());
            pst.executeUpdate();
        } catch(HeadlessException | SQLException ex){
            System.out.println(ex);
            return false;
        }finally {
            try {
                if(con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return true;
    }
}
