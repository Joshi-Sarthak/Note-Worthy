package com.main.util;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;


public class CreateGroupCardPanel extends javax.swing.JPanel {


    public CreateGroupCardPanel(String groupName, String creator, String dateJoined, String lastPostDate, String currentUsername, MouseListener myListener, String groupId)
    {
        initComponents();
        titleLabel.setFocusable(false);
        titleLabel.setText(groupName);
        titleLabel.setEditable(false);
        titleLabel.setText(groupName);
        titleLabel.setLineWrap(true);
        if(currentUsername.equals(creator)) {
            creationLabel.setText("Created by: You");
            dateJoinedLabel.setText("Created at: " + dateJoined);
        } else {
            creationLabel.setText("Created by: " + creator);
            dateJoinedLabel.setText("Joined at: " + dateJoined);
        }
        groupcodeLabel.setText(groupId);
        lastEditLabel.setText("Last Edit: " + lastPostDate);
        lastEditPanel.add(lastEditLabel, BorderLayout.LINE_END);
        titlePanel.add(titleLabel);
        titlePanel.add(lastEditPanel);
        titleLabel.addMouseListener(myListener);
        infoPanel.addMouseListener(myListener);
        this.addMouseListener(myListener);
        infoPanel.add(creationLabel);
        infoPanel.add(dateJoinedLabel);
        this.add(titlePanel, BorderLayout.NORTH);
        this.add(infoPanel, BorderLayout.SOUTH);
    }
    public JPanel getThisPanel() {
        return this;
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {
        titlePanel = new javax.swing.JPanel();
        infoPanel = new javax.swing.JPanel();
        lastEditPanel = new javax.swing.JPanel();
        lastEditLabel = new javax.swing.JLabel();
        creationLabel = new javax.swing.JLabel();
        dateJoinedLabel = new javax.swing.JLabel();
        titleLabel = new javax.swing.JTextArea();
        groupcodeLabel = new javax.swing.JLabel();

        groupcodeLabel.setFont(new java.awt.Font("Yu Gothic Light", 0, 12)); // NOI18N
        groupcodeLabel.setForeground(new java.awt.Color(102, 102, 102));
        groupcodeLabel.setText("Group Code :");

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

        titlePanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout titlePanelLayout = new javax.swing.GroupLayout(titlePanel);
        titlePanel.setLayout(titlePanelLayout);
        titlePanelLayout.setHorizontalGroup(
                titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        titlePanelLayout.setVerticalGroup(
                titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 64, Short.MAX_VALUE)
        );

        infoPanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout infoPanelLayout = new javax.swing.GroupLayout(infoPanel);
        infoPanel.setLayout(infoPanelLayout);
        infoPanelLayout.setHorizontalGroup(
                infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        infoPanelLayout.setVerticalGroup(
                infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 45, Short.MAX_VALUE)
        );

        lastEditPanel.setBackground(new java.awt.Color(255, 255, 255));

        lastEditLabel.setFont(new java.awt.Font("Yu Gothic Light", Font.PLAIN, 12)); // NOI18N
        lastEditLabel.setForeground(new java.awt.Color(102, 102, 102));
        lastEditLabel.setText("Last edit");

        javax.swing.GroupLayout lastEditPanelLayout = new javax.swing.GroupLayout(lastEditPanel);
        lastEditPanel.setLayout(lastEditPanelLayout);
        lastEditPanelLayout.setHorizontalGroup(
                lastEditPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(lastEditPanelLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(lastEditPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lastEditLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(groupcodeLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(19, 19, 19))
        );
        lastEditPanelLayout.setVerticalGroup(
                lastEditPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(lastEditPanelLayout.createSequentialGroup()
                                .addComponent(lastEditLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(groupcodeLabel)
                                .addContainerGap())
        );

        creationLabel.setFont(new java.awt.Font("Yu Gothic UI Light", Font.PLAIN, 12)); // NOI18N
        creationLabel.setForeground(new java.awt.Color(102, 102, 102));

        dateJoinedLabel.setFont(new java.awt.Font("Yu Gothic UI Light", Font.PLAIN, 12)); // NOI18N
        dateJoinedLabel.setForeground(new java.awt.Color(102, 102, 102));

        titleLabel.setColumns(20);
        titleLabel.setFont(new java.awt.Font("Yu Gothic UI Semibold", Font.BOLD, 36)); // NOI18N
        titleLabel.setRows(5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(infoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(dateJoinedLabel)
                                                        .addComponent(creationLabel))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lastEditPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(titlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap())))

        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(titlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(infoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lastEditPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(creationLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(dateJoinedLabel))))
        );
    }// </editor-fold>


    // Variables declaration - do not modify
    private javax.swing.JLabel creationLabel;
    private javax.swing.JLabel dateJoinedLabel;
    private javax.swing.JPanel infoPanel;
    private javax.swing.JLabel lastEditLabel;
    private javax.swing.JPanel lastEditPanel;
    private javax.swing.JTextArea titleLabel;
    private javax.swing.JPanel titlePanel;
    private javax.swing.JLabel groupcodeLabel;
    // End of variables declaration
}