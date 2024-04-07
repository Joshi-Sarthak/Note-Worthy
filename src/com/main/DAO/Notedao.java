package com.main.DAO;

import com.main.model.PersonalNote;

import java.sql.*;
import java.util.ArrayList;

public class Notedao {
    private Connection connection;
    public static ResultSet resultSet;
    DataBaseConnector dataBaseConnector;

    public Notedao() {
        dataBaseConnector = new DataBaseConnector();
        connection = dataBaseConnector.connect();
    }


    public ArrayList<PersonalNote> loadNotes(String currentUsername) {
        ArrayList<PersonalNote> personalNotesList = new ArrayList<>();
        try {
            String sql = "SELECT `personalnotes_user`.note_id, `personalnotes_user`.title," +
                    " `personalnotes_user`.content, `personalnotes_user`.creation_datetime," +
                    " `personalnotes_user`.last_edit_datetime FROM `personalnotes_user` " +
                    "where `personalnotes_user`.username = ? " +
                    "ORDER BY `personalnotes_user`.last_edit_datetime DESC;";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, currentUsername);
            resultSet = pst.executeQuery();
            while (resultSet.next()) {
                int noteId = resultSet.getInt("note_id");
                String title = resultSet.getString("title");
                String content = resultSet.getString("content");
                String creationDatetime = resultSet.getString("creation_datetime");
                String lastEditDatetime = resultSet.getString("last_edit_datetime");

                PersonalNote note = new PersonalNote();
                note.setNoteID(noteId);
                note.setTitle(title);
                note.setContent(content);
                note.setCreationDateTime(creationDatetime);
                note.setLastEditDateTime(lastEditDatetime);

                personalNotesList.add(note);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return personalNotesList;
    }

    public void insert(String title, String content, String currentUsername) {
        try {
            String sql = "INSERT INTO `personalnotes_user` (title, content, creation_datetime, last_edit_datetime, username) VALUES (?, ?, NOW(), NOW(), ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, title);
            preparedStatement.setString(2, content);
            preparedStatement.setString(3, currentUsername);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    public void update(int noteId, String content, String title) {
        try {
            String sql = "UPDATE `personalnotes_user` SET title = ?, content = ?, last_edit_datetime = NOW() WHERE note_id = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, title);
            preparedStatement.setString(2, content);
            preparedStatement.setInt(3, noteId);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public boolean deleteNote(int noteId) {
        try {
            String sql = "DELETE FROM `personalnotes_user` WHERE note_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, noteId);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Note deleted successfully.");
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}