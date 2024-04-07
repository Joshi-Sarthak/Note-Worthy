package com.main.ui.Panels;

import com.main.ui.Frames.Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.font.TextAttribute;
import java.util.Map;

public class sideNavigationPanel extends javax.swing.JPanel {
    JPanel mainPanel;
    String currentUsername;
    public sideNavigationPanel(JPanel _mainPanel, String _currentUsername) {
        currentUsername = _currentUsername;
        mainPanel = _mainPanel;
        initComponents();
    }

    public JPanel getThisPanel() {
        return this;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jPanel = new javax.swing.JPanel();
        NoteWorthyLabel = new javax.swing.JLabel();
        PersonalNotesLabel = new javax.swing.JLabel();
        groupLabel = new javax.swing.JLabel();
        profileLabel = new javax.swing.JLabel();
        LogoutLabel = new javax.swing.JLabel();

        LogoutLabel.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 18)); // NOI18N
        LogoutLabel.setText("Logout");
        LogoutLabel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new Login();
                SwingUtilities.getWindowAncestor(mainPanel).dispose();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Font font = LogoutLabel.getFont();
                Map attributes = font.getAttributes();
                attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
                LogoutLabel.setFont(font.deriveFont(attributes));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Font font = LogoutLabel.getFont();
                Map attributes = font.getAttributes();
                attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE);
                LogoutLabel.setFont(font.deriveFont(attributes));
            }
        });

        jPanel.setBackground(new java.awt.Color(255, 204, 0));
        jPanel.setPreferredSize(new java.awt.Dimension(300, 600));

        NoteWorthyLabel.setFont(new java.awt.Font("Edwardian Script ITC", 1, 48)); // NOI18N
        NoteWorthyLabel.setText("NoteWorthy");

        PersonalNotesLabel.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 24)); // NOI18N
        PersonalNotesLabel.setText("Personal Notes");

        groupLabel.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 24)); // NOI18N
        groupLabel.setText("Group Notes");

        profileLabel.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 24)); // NOI18N
        profileLabel.setText("Profile");

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
                jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelLayout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(LogoutLabel)
                                        .addComponent(PersonalNotesLabel)
                                        .addComponent(NoteWorthyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(groupLabel)
                                        .addComponent(profileLabel))
                                .addContainerGap(36, Short.MAX_VALUE))
        );

        jPanelLayout.setVerticalGroup(
                jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(NoteWorthyLabel)
                                .addGap(47, 47, 47)
                                .addComponent(PersonalNotesLabel)
                                .addGap(18, 18, 18)
                                .addComponent(groupLabel)
                                .addGap(18, 18, 18)
                                .addComponent(profileLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 332, Short.MAX_VALUE)
                                .addComponent(LogoutLabel)
                                .addGap(25, 25, 25))
        );

//        add()

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 700, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        profileLabel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mainPanel.removeAll();
                mainPanel.add(new ProfilePanel(currentUsername, mainPanel).getThisPanel());
                mainPanel.repaint();
                mainPanel.revalidate();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Font font = profileLabel.getFont();
                Map attributes = font.getAttributes();
                attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
                profileLabel.setFont(font.deriveFont(attributes));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Font font = profileLabel.getFont();
                Map attributes = font.getAttributes();
                attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE);
                profileLabel.setFont(font.deriveFont(attributes));
            }
        });
        groupLabel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mainPanel.removeAll();
                mainPanel.add(new GroupHomepagePanel(currentUsername, mainPanel).getThisPanel());
                mainPanel.repaint();
                mainPanel.revalidate();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Font font = groupLabel.getFont();
                Map attributes = font.getAttributes();
                attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
                groupLabel.setFont(font.deriveFont(attributes));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Font font = groupLabel.getFont();
                Map attributes = font.getAttributes();
                attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE);
                groupLabel.setFont(font.deriveFont(attributes));
            }
        });
        PersonalNotesLabel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mainPanel.removeAll();
                mainPanel.add(new PersonalNotesHomepagePanel(currentUsername, mainPanel).getThisPanel());
                mainPanel.repaint();
                mainPanel.revalidate();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Font font = PersonalNotesLabel.getFont();
                Map attributes = font.getAttributes();
                attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
                PersonalNotesLabel.setFont(font.deriveFont(attributes));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Font font = PersonalNotesLabel.getFont();
                Map attributes = font.getAttributes();
                attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE);
                PersonalNotesLabel.setFont(font.deriveFont(attributes));
            }
        });
    }// </editor-fold>


    // Variables declaration - do not modify
    private javax.swing.JLabel NoteWorthyLabel;
    private javax.swing.JLabel PersonalNotesLabel;
    private javax.swing.JLabel groupLabel;
    private javax.swing.JLabel profileLabel;
    private javax.swing.JPanel jPanel;
    private javax.swing.JLabel LogoutLabel;
    // End of variables declaration
}