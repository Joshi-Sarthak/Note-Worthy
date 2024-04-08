package com.main.ui.Panels;

import com.main.DAO.UserDAO;
import com.main.model.User;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author Sarthak Joshi
 */
public class ProfilePanel extends javax.swing.JPanel {

    String currentUsername;
    User currentUser;
    UserDAO userdao;
    JPanel parentPanel;
    public ProfilePanel(String _currentUsername, JPanel _parentPanel) {
        parentPanel = _parentPanel;
        userdao = new UserDAO();
        currentUsername = _currentUsername;
        currentUser = userdao.getCurrentUser(currentUsername);
        initComponents();
        nameTextField.setText(currentUser.getName());
        emailTextField.setText(currentUser.getEmail());
        UsernameTextField.setText(currentUsername);
    }

    public boolean isAlphanumeric(String str)
    {
        char[] charArray = str.toCharArray();
        for(char c:charArray)
        {
            if (!(Character.isLetterOrDigit(c) || Character.isSpaceChar(c)))
                return false;
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jPanel = new javax.swing.JPanel();
        profileLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        editNameIcon = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        usernameLabel = new javax.swing.JLabel();
        emailTextField = new javax.swing.JTextField();
        UsernameTextField = new javax.swing.JTextField();
        saveButton = new javax.swing.JButton();
        editEmailIcon = new javax.swing.JLabel();
        editEmailIcon = new javax.swing.JLabel();
        nameErrorlabel = new javax.swing.JLabel();
        emailErrorLabel = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(700, 600));

        jPanel.setPreferredSize(new java.awt.Dimension(700, 600));

        profileLabel.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 36)); // NOI18N
        profileLabel.setText("Profile");

        nameLabel.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        nameLabel.setText("Name");

        editNameIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/main/icons/edit.png"))); // NOI18N
        editNameIcon.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                nameTextField.setEnabled(true);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                editNameIcon.setIcon(null);
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        emailLabel.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        emailLabel.setText("Email");

        usernameLabel.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        usernameLabel.setText("Username");

        nameTextField.setEnabled(false);

        UsernameTextField.setEnabled(false);


        saveButton.setBackground(new java.awt.Color(0, 0, 0));
        saveButton.setForeground(new java.awt.Color(255, 255, 255));
        saveButton.setText("Save Changes");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });
        emailTextField.setEnabled(false);
        editEmailIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/main/icons/edit.png"))); // NOI18N
        editEmailIcon.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                emailTextField.setEnabled(true);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                editEmailIcon.setIcon(null);
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        KeyListener keyListener = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                emailErrorLabel.setText("");
                nameErrorlabel.setText("");
            }
        };

        nameTextField.addKeyListener(keyListener);
        emailTextField.addKeyListener(keyListener);

        nameErrorlabel.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        nameErrorlabel.setForeground(new java.awt.Color(255, 0, 0));

        emailErrorLabel.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        emailErrorLabel.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
                jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelLayout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(emailErrorLabel)
                                        .addComponent(nameErrorlabel)
                                        .addComponent(saveButton)
                                        .addComponent(usernameLabel)
                                        .addGroup(jPanelLayout.createSequentialGroup()
                                                .addComponent(UsernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(editEmailIcon))
                                        .addComponent(nameLabel)
                                        .addComponent(emailLabel)
                                        .addGroup(jPanelLayout.createSequentialGroup()
                                                .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(editNameIcon))
                                        .addComponent(profileLabel)
                                        .addGroup(jPanelLayout.createSequentialGroup()
                                                .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(editEmailIcon)))
                                .addContainerGap(278, Short.MAX_VALUE))
        );
        jPanelLayout.setVerticalGroup(
                jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelLayout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(profileLabel)
                                .addGap(35, 35, 35)
                                .addComponent(nameLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(editNameIcon, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                                        .addComponent(nameTextField))
                                .addGap(2, 2, 2)
                                .addComponent(nameErrorlabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(emailLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(editEmailIcon))
                                .addGap(3, 3, 3)
                                .addComponent(emailErrorLabel)
                                .addGap(18, 18, 18)
                                .addComponent(usernameLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(UsernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(editEmailIcon))
                                .addGap(35, 35, 35)
                                .addComponent(saveButton)
                                .addContainerGap(193, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 6, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

    }// </editor-fold>

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if(nameTextField.getText().isEmpty()) {
            nameErrorlabel.setText("Enter a name");
        }
        else if(emailTextField.getText().isEmpty()) {
            emailLabel.setText("Enter an email");
        } else if(!isAlphanumeric(nameTextField.getText().trim()) || !emailTextField.getText().contains("@")) {
            if (!emailTextField.getText().contains("@")) {
                emailErrorLabel.setText("Invalid Email");
            } else {
                nameErrorlabel.setText("Name must be alphanumeric");
            }
        }else if(nameTextField.getText().trim().equals(currentUser.getName()) && emailTextField.getText().trim().equals(currentUser.getEmail())) {
            JOptionPane.showMessageDialog(this, new JLabel("No changes to update"));
        }else {
            currentUser.setName(nameTextField.getText().trim());
            currentUser.setEmail(emailTextField.getText().trim());
            if(userdao.updateCurrentUserDetails(currentUser))
                JOptionPane.showMessageDialog(this, new JLabel("User Details updated"));
            else
                JOptionPane.showMessageDialog(this, "Error! Cannot update user details");
            parentPanel.removeAll();
            parentPanel.add(new ProfilePanel(currentUsername, parentPanel).getThisPanel());
            parentPanel.repaint();
            parentPanel.revalidate();
        }
    }


    // Variables declaration - do not modify
    private javax.swing.JButton saveButton;
    private javax.swing.JLabel profileLabel;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel editNameIcon;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JLabel editEmailIcon;
    private javax.swing.JLabel nameErrorlabel;//name
    private javax.swing.JLabel emailErrorLabel;//email
    private javax.swing.JPanel jPanel;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JTextField emailTextField;
    private javax.swing.JTextField UsernameTextField;

    public JPanel getThisPanel() {
        return this;
    }
    // End of variables declaration
}