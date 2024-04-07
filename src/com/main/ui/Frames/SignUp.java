package com.main.ui.Frames;

import com.main.DAO.UserDAO;

import java.awt.*;
import java.awt.event.*;

/**
 * @author Harsh Itkar
 */
public class SignUp extends javax.swing.JFrame {
    boolean isEmailValid;

    boolean isUsernameValid;

    public SignUp() {

        isEmailValid = false;
        isUsernameValid = false;

        setTitle("NoteWorthy");
        setResizable(false);
        setSize(800,500);
        setLocationRelativeTo(getOwner());
        initComponents();

        signinLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        signinLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                signinLabel.setForeground(Color.BLUE); // Change the color when mouse enters
            }

            @Override
            public void mouseExited(MouseEvent e) {
                signinLabel.setForeground(Color.BLACK); // Change the color back when mouse exits
            }
        });
    }

    private void signin() {
        String name = nameField.getText();
        String username = usernameField.getText().trim();
        String email = emailField.getText().trim();
        String password = passwordField.getText();
        if(email.isEmpty() || password.isEmpty()) {
            confirmSigninErrorLabel.setText("Enter all details");
            return;
        }
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch(Exception ex) {
            throw new RuntimeException(ex);
        }
        UserDAO dataBaseHelper = new UserDAO();
        if(dataBaseHelper.isEmailRegistered(email)) {
            emailErrorLabel.setText("Email id already registered");
        } else {
            if (dataBaseHelper.addUser(username, email, password, name)) {
                new NoteWorthyApp(username);
                this.dispose();
            } else {
                confirmSigninErrorLabel.setText("Unable to create an account");
            }
        }
    }

    public boolean isAlphanumeric(String str)
    {
        char[] charArray = str.toCharArray();
        for(char c:charArray)
        {
            if (!Character.isLetterOrDigit(c))
                return false;
        }
        return true;
    }

    private void EmailFieldMouseMoved() {
        emailField.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    private void EmailFieldKeyReleased(KeyEvent e) {
        if (e.getKeyCode()==KeyEvent.VK_ENTER){
            String email = emailField.getText();
            if(email.isEmpty()) {
                emailErrorLabel.setText("Enter an Email");
            } else if(email.contains("@")) {
                isEmailValid = true;
                passwordField.grabFocus();
            } else {
                emailErrorLabel.setText("Invalid email");
            }
        } else {
            emailErrorLabel.setText("");

        }
    }

    private void signinLabelMouseMoved() {
        signinLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    private void ok(ActionEvent e) {
        if (nameField.getText().isEmpty()) {
            nameErrorLabel.setText("Enter your full name");
        }
        else if (isAlphanumeric(nameField.getText())) {
            nameErrorLabel.setText("Enter valid name");
        } else if(isEmailValid && isUsernameValid)
            this.signin();
    }

    private void PasswordFieldMouseMoved() {
        passwordField.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    private void PasswordFieldKeyPressed(KeyEvent e) {
        emailErrorLabel.setText("");
        if (e.getKeyCode()==KeyEvent.VK_ENTER && isEmailValid){
            confirmPasswordField.grabFocus();
        } else if(!isEmailValid) {
            emailErrorLabel.setText("Enter valid email");
        } else if (!isUsernameValid) {
            usernameErrorLabel.setText("Enter valid username");
        }
    }

    private void signinLabelMousePressed() {
        Login loginPage = new Login();
        loginPage.setSize(800, 600);
        loginPage.setResizable(false);
        loginPage.setVisible(true);
        this.dispose();
    }

    private void EmailFieldMouseClicked() {
        emailField.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    private void confirmPasswordFieldKeyPressed(KeyEvent e) {
        confirmSigninErrorLabel.setText("");
        if(e.getKeyCode()==KeyEvent.VK_ENTER) {
            if(confirmPasswordField.getText().equals(passwordField.getText())) {
                this.signin();
            } else {
                confirmSigninErrorLabel.setText("Password doesn't match");
                confirmPasswordField.setText("");
            }
        }
    }

    private void usernameFieldFocusLost() {
        emailErrorLabel.setText("");
        usernameValidLabel.setText("");
    }

    private void confirmPasswordFieldMouseMoved(

    ) {
        confirmPasswordField.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    private void emailFieldMouseMoved() {
        emailField.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    private void usernameFieldMouseMoved() {
        usernameField.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    private void usernameFieldKeyReleased(KeyEvent e) {
        usernameErrorLabel.setText("");
        usernameValidLabel.setText("");
        if(!usernameField.getText().isEmpty()) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                if (isUsernameValid) {
                    emailField.grabFocus();
                } else {
                    usernameErrorLabel.setText("Username not available");
                }
            } else {
                if (!isAlphanumeric(usernameField.getText())) {
                    isUsernameValid = false;
                    usernameErrorLabel.setText("username should be alphanumeric");
                } else {
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                    } catch (ClassNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }
                    UserDAO dataBaseHelper = new UserDAO();
                    isUsernameValid = dataBaseHelper.isUsernameAvailable(usernameField.getText());
                    if (isUsernameValid) {
                        usernameValidLabel.setText("Username Available");
                    } else {
                        usernameErrorLabel.setText("Username not available");
                    }
                }
            }
        }  else {
            isUsernameValid = false;
            usernameErrorLabel.setText("Enter username");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        welcomeLabel = new javax.swing.JLabel();
        titleLabel = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        emailLabel = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        emailErrorLabel = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        confirmPasswordLabel = new javax.swing.JLabel();
        confirmPasswordField = new javax.swing.JPasswordField();
        confirmSigninErrorLabel = new javax.swing.JLabel();
        okButton = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        usernameLabel = new javax.swing.JLabel();
        usernameField = new javax.swing.JTextField();
        usernameValidLabel = new javax.swing.JLabel();
        usernameErrorLabel = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        passwordLabel = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        alreadyHaveAnAccountLabel = new javax.swing.JLabel();
        signinLabel = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        nameErrorLabel = new javax.swing.JLabel();
        signinConfirmErrorLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        ImageLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        welcomeLabel.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 30)); // NOI18N
        welcomeLabel.setText("Welcome to");

        titleLabel.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 30)); // NOI18N
        titleLabel.setText("NoteWorthy!");

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        emailLabel.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        emailLabel.setText("Email");

        emailErrorLabel.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        emailErrorLabel.setForeground(new java.awt.Color(255, 0, 51));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
                jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(emailErrorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(emailLabel)
                                        .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
                jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(emailLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(emailErrorLabel))
        );

        emailField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                EmailFieldMouseClicked();
            }
        });
        emailField.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                EmailFieldMouseMoved();
                emailFieldMouseMoved();
            }
        });
        emailField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                EmailFieldKeyReleased(e);
            }
        });
        emailField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                usernameFieldFocusLost();
            }
        });

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        confirmPasswordLabel.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        confirmPasswordLabel.setText("Confirm Password");

        confirmSigninErrorLabel.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        confirmSigninErrorLabel.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(confirmSigninErrorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(confirmPasswordLabel)
                                        .addComponent(confirmPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(confirmPasswordLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(confirmPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(confirmSigninErrorLabel))
        );

        confirmPasswordField.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                PasswordFieldMouseMoved();
                confirmPasswordFieldMouseMoved();
                confirmPasswordFieldMouseMoved();
                confirmPasswordFieldMouseMoved();
            }
        });
        confirmPasswordField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                PasswordFieldKeyPressed(e);
                confirmPasswordFieldKeyPressed(e);
            }
        });
        confirmPasswordField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                usernameFieldFocusLost();
            }
        });

        okButton.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        okButton.setText("Sign up");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        usernameLabel.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        usernameLabel.setText("Username");

        usernameValidLabel.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        usernameValidLabel.setForeground(new java.awt.Color(0, 255, 0));

        usernameErrorLabel.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        usernameErrorLabel.setForeground(new java.awt.Color(255, 0, 51));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
                jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(usernameLabel)
                                        .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(usernameErrorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(usernameValidLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
                jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(usernameLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(usernameValidLabel)
                                .addGap(2, 2, 2)
                                .addComponent(usernameErrorLabel))
        );

        usernameField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                EmailFieldMouseClicked();
            }
        });
        usernameField.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                EmailFieldMouseMoved();
                usernameFieldMouseMoved();
            }
        });
        usernameField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
            }
            @Override
            public void keyReleased(KeyEvent e) {
                usernameFieldKeyReleased(e);
            }
        });
        usernameField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                usernameFieldFocusLost();
            }
        });

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        passwordLabel.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        passwordLabel.setText("Password");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(passwordLabel)
                                        .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(passwordLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
        );

        passwordField.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                PasswordFieldMouseMoved();
            }
        });
        passwordField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                PasswordFieldKeyPressed(e);
            }
        });
        passwordField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                usernameFieldFocusLost();
            }
        });

        alreadyHaveAnAccountLabel.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 12)); // NOI18N
        alreadyHaveAnAccountLabel.setText("Already have an account?");

        signinLabel.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        signinLabel.setText("Login");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        jLabel4.setText("Full Name");

        nameField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                    usernameField.grabFocus();
                }
            }
        });

        nameErrorLabel.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        nameErrorLabel.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(nameErrorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4)
                                        .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nameErrorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        signinConfirmErrorLabel.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        signinConfirmErrorLabel.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(31, 31, 31)
                                                .addComponent(welcomeLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(titleLabel)
                                                .addGap(0, 78, Short.MAX_VALUE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addContainerGap())
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(signinConfirmErrorLabel)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(okButton)
                                                .addGap(74, 74, 74)
                                                .addComponent(alreadyHaveAnAccountLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(signinLabel)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(titleLabel)
                                        .addComponent(welcomeLabel))
                                .addGap(24, 24, 24)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(okButton)
                                        .addComponent(alreadyHaveAnAccountLabel)
                                        .addComponent(signinLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(signinConfirmErrorLabel)
                                .addContainerGap(71, Short.MAX_VALUE))
        );

        okButton.addActionListener(this::ok);
        signinLabel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                signinLabelMouseMoved();
            }
        });
        signinLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                signinLabelMousePressed();
            }
        });

        ImageLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/main/icons/signup.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(ImageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(74, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(114, 114, 114)
                                .addComponent(ImageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        setLocationRelativeTo(getParent());
        okButton.setBackground(Color.BLACK);
        okButton.setForeground(Color.WHITE);
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        // TODO add your handling code here:
        confirmSigninErrorLabel.setText("");
        if(confirmPasswordField.getText().equals(passwordField.getText())) {
            if(nameErrorLabel.getText().trim().isEmpty()||emailErrorLabel.getText().trim().isEmpty())
                confirmPasswordField.setText("All fields are mandatory");
            else if(!emailField.getText().contains("@"))
                emailErrorLabel.setText("Invalid Email");
            else if(!isAlphanumeric(nameField.getText()))
                nameErrorLabel.setText("Name must be alphanumeric");
            else
                this.signin();
        } else {
            confirmSigninErrorLabel.setText("Password doesn't match");
            confirmPasswordField.setText("");
        }
    }//GEN-LAST:event_okButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField confirmPasswordField;
    private javax.swing.JLabel confirmSigninErrorLabel;
    private javax.swing.JLabel emailErrorLabel;
    private javax.swing.JTextField emailField;
    private javax.swing.JLabel ImageLabel;
    private javax.swing.JLabel welcomeLabel;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JLabel confirmPasswordLabel;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JLabel alreadyHaveAnAccountLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JLabel nameErrorLabel;
    private javax.swing.JTextField nameField;
    private javax.swing.JButton okButton;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel signinConfirmErrorLabel;
    private javax.swing.JLabel signinLabel;
    private javax.swing.JLabel usernameErrorLabel;
    private javax.swing.JTextField usernameField;
    private javax.swing.JLabel usernameValidLabel;
    // End of variables declaration//GEN-END:variables
}