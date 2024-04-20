package com.main.DAO;

import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminGroupDAO {
    PreparedStatement pst;
    Connection con;
    DataBaseConnector dataBaseConnector = new DataBaseConnector();

    public boolean makeAdmin(String username, String groupId) {
        try{
            con = dataBaseConnector.connect();
            try {
                pst = con.prepareStatement("update `user_group` set role = 'admin' where username = ? and groupId = ?;");
                pst.setString(1, username);
                pst.setString(2, groupId);
                pst.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e);
                return false;
            }
        } catch(HeadlessException ex){
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

    public boolean removeMember(String username, String groupId) {
        try{
            con = dataBaseConnector.connect();
            try {
                pst = con.prepareStatement("delete from `user_group` where username = ? and groupId = ?;");
                pst.setString(1, username);
                pst.setString(2, groupId);
                pst.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e);
                return false;
            }
        } catch(HeadlessException ex){
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

    public void changeGroupName(String groupId, String groupName) {
        try{
            con = dataBaseConnector.connect();
            try {
                pst = con.prepareStatement("update `group` set groupName = ? where groupId = ?;");
                pst.setString(1, groupName);
                pst.setString(2, groupId);
                pst.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e);
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
    }
}
