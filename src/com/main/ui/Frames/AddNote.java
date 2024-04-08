package com.main.ui.Frames;

import com.main.DAO.GroupNotesDAO;
import com.main.DAO.Notedao;
import com.main.ui.Panels.AdminGroupNotesPanel;
import com.main.ui.Panels.PersonalNotesHomepagePanel;

import javax.swing.*;
import java.awt.event.*;

/**
 * @author Onkar Jadhav
 */
public class AddNote extends javax.swing.JFrame {
    String currentUsername;
    String groupId;
    int noteId;
    JPanel parentPanel;
    public AddNote(String _currentUsername, String _groupId, int _noteId, JPanel _parentPanel, String _title, String _content) {
        parentPanel = _parentPanel;
        String title = _title;
        String content = _content;
        currentUsername = _currentUsername;
        groupId = _groupId;
        noteId = _noteId;
        initComponents();
        titleTextArea.setLineWrap(true);
        contentTextArea.setLineWrap(true);
        if(title != null) {
            titleTextArea.setText(title);
            contentTextArea.setText(content);
        }
        setVisible(true);
        setTitle("NoteWorthy");
        setResizable(false);
        setLocationRelativeTo(getOwner());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        backButton = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        titleTextArea = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        contentTextArea = new javax.swing.JTextArea();
        ContentErrorLabel = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        deleteButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        TitleErrorLabel = new javax.swing.JLabel();

        jPanel1.setPreferredSize(new java.awt.Dimension(800, 800));

        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/main/icons/back.png")));
        backButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                backButtonActionPerformed(e);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        titleTextArea.setBackground(new java.awt.Color(242, 242, 242));
        titleTextArea.setColumns(20);
        titleTextArea.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 48)); // NOI18N
        titleTextArea.setRows(5);
        titleTextArea.setBorder(null);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(titleTextArea, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(titleTextArea, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        contentTextArea.setColumns(20);
        contentTextArea.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        contentTextArea.setRows(5);
        contentTextArea.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                newNoteContentKeyReleased(e);
            }
        });

        ContentErrorLabel.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        ContentErrorLabel.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(0, 7, Short.MAX_VALUE)
                                .addComponent(contentTextArea, javax.swing.GroupLayout.PREFERRED_SIZE, 786, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 7, Short.MAX_VALUE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(ContentErrorLabel)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(ContentErrorLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(contentTextArea, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        deleteButton.setBackground(new java.awt.Color(0, 0, 0));
        deleteButton.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        deleteButton.setForeground(new java.awt.Color(255, 255, 255));
        deleteButton.setText("Delete");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteButtonActionPerformed(e);
            }
        });

        saveButton.setBackground(new java.awt.Color(0, 0, 0));
        saveButton.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        saveButton.setForeground(new java.awt.Color(255, 255, 255));
        saveButton.setText("Save Changes");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveButtonActionPerformed(e);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(deleteButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(saveButton)
                                .addGap(22, 22, 22))
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(25, Short.MAX_VALUE))
        );

        TitleErrorLabel.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        TitleErrorLabel.setForeground(new java.awt.Color(255, 0, 0));
        TitleErrorLabel.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                newNoteTitleKeyReleased(e);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(backButton)
                                        .addComponent(TitleErrorLabel))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(backButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TitleErrorLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 800, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 800, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
        );
        pack();
    }

    private void newNoteTitleKeyReleased(KeyEvent evt) {
        TitleErrorLabel.setText("");
        ContentErrorLabel.setText("");
    }

    private void newNoteContentKeyReleased(KeyEvent evt) {
        TitleErrorLabel.setText("");
        ContentErrorLabel.setText("");
    }

    private void backButtonActionPerformed(MouseEvent e) {
        this.dispose();
    }

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if(areFieldsValid()) {
            if(noteId < 0) {
                if(groupId == null) {
                    new Notedao().insert(titleTextArea.getText(), contentTextArea.getText(), currentUsername);
                } else {
                    new GroupNotesDAO().addGroupNote(groupId, currentUsername, titleTextArea.getText(), contentTextArea.getText());
                }
            } else {
                if(groupId == null) {
                    new Notedao().update(noteId, contentTextArea.getText(), titleTextArea.getText());
                } else {
                    new GroupNotesDAO().updateGroupNote(noteId, currentUsername, titleTextArea.getText(), contentTextArea.getText());
                }
            }
            parentPanel.removeAll();
            if(groupId == null)
                parentPanel.add(new PersonalNotesHomepagePanel(currentUsername, parentPanel));
            else
                parentPanel.add(new AdminGroupNotesPanel(currentUsername, groupId, parentPanel));
            parentPanel.repaint();
            parentPanel.revalidate();
            this.dispose();
        }
    }

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if(noteId > 0) {
            parentPanel.removeAll();
            if(groupId == null) {
                new Notedao().deleteNote(noteId);
                parentPanel.add(new PersonalNotesHomepagePanel(currentUsername, parentPanel));
            } else {
                System.out.println(new GroupNotesDAO().deleteGroupNote(noteId));
                parentPanel.add(new AdminGroupNotesPanel(currentUsername, groupId, parentPanel));
            }
            parentPanel.repaint();
            parentPanel.revalidate();
        }
        this.dispose();
    }

    private Boolean areFieldsValid() {
        if(titleTextArea.getText().trim().isEmpty()) {
            TitleErrorLabel.setText("Cannot leave this field empty");
            return false;
        }
        if(contentTextArea.getText().trim().isEmpty()) {
            ContentErrorLabel.setText("Cannot leave this field empty");
            return false;
        }
        if(titleTextArea.getText().trim().toCharArray().length > 20) {
            TitleErrorLabel.setText("Too long!!");
            return false;
        }
        return true;
    }

    // Variables declaration - do not modify
    private javax.swing.JLabel ContentErrorLabel;
    private javax.swing.JLabel TitleErrorLabel;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JLabel backButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextArea titleTextArea;
    private javax.swing.JTextArea contentTextArea;
    // End of variables declaration
}