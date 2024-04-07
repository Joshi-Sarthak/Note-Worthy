package com.main.DAO;

import com.main.model.GroupNote;

import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GroupNotesDAO {

    PreparedStatement pst;
    ResultSet rs;
    Connection con;
    DataBaseConnector dataBaseConnector = new DataBaseConnector();

    public boolean addGroupNote(String groupId, String currentUsername, String title, String content) {
        try{
            con = dataBaseConnector.connect();
            try {
                pst = con.prepareStatement("INSERT INTO `groupnotes_group` (title, content, creation_datetime, last_edit_datetime, created_by, last_edited_by, groupId) VALUES (?, ?, NOW(), NOW(), ?, ?, ?);");
                pst.setString(1, title);
                pst.setString(2, content);
                pst.setString(3, currentUsername);
                pst.setString(4, currentUsername);
                pst.setString(5, groupId);
                pst.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e);
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
    public boolean updateGroupNote(int groupNoteId, String currentUsername, String title, String content) {
        try{
            con = dataBaseConnector.connect();
            try {
                pst = con.prepareStatement("update `groupnotes_group` set title = ?, content = ?, last_edit_datetime = NOW(), last_edited_by = ? where `groupNoteId` = ?;");
                pst.setString(1, title);
                pst.setString(2, content);
                pst.setString(3, currentUsername);
                pst.setInt(4, groupNoteId);
                pst.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e);
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
    public ArrayList<GroupNote> getGroupNotesList(String groupId) {
        ArrayList<GroupNote> model = new ArrayList<>();
        try{
            con = dataBaseConnector.connect();
            String sql = "SELECT `groupnotes_group`.groupId, `groupnotes_group`.groupNoteId, " +
                    "`groupnotes_group`.title, `groupnotes_group`.content, `groupnotes_group`.creation_datetime, " +
                    "`groupnotes_group`.last_edit_datetime, `groupnotes_group`.created_by, `groupnotes_group`.last_edited_by " +
                    "FROM `groupnotes_group` WHERE `groupnotes_group`.groupId = ? order by `groupnotes_group`.last_edit_datetime DESC;";
            pst = con.prepareStatement(sql);
            pst.setString(1, groupId);
            rs = pst.executeQuery();
            while(rs.next()){
                int groupNoteId = rs.getInt("groupNoteId");
                String title = rs.getString("title");
                String content = rs.getString("content");
                String creation_datetime = rs.getString("creation_datetime");
                String last_edit_datetime = rs.getString("last_edit_datetime");
                String created_by = rs.getString("created_by");
                String last_edited_by = rs.getString("last_edited_by");
                model.add(new GroupNote(groupNoteId, title, content, creation_datetime, last_edit_datetime, created_by, last_edited_by));
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
        return model;
    }
    public boolean deleteGroupNote(int groupNoteId) {
        try{
            con = dataBaseConnector.connect();
            try {
                pst = con.prepareStatement("delete from `groupnotes_group` where groupNoteId = ?;");
                pst.setInt(1, groupNoteId);
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
}
