package com.main.util;

import java.awt.*;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

/**
 * @author Onkar Jadhav
 */
public class CreateNoteCardPanel extends javax.swing.JPanel {


    public CreateNoteCardPanel(String title, String creator, String creationDatetime, String lastPostDate, String currentUsername, MouseListener myListener)
    {
        initComponents();
        titleLabel.setFocusable(false);
        titleLabel.setText(title);
        titleLabel.setEditable(false);
        titleLabel.setLineWrap(true);
        if(currentUsername.equals(creator)) {
            creationLabel.setText("Created by: You");
            infoPanel.add(creationLabel);
        } else if(creator != null) {
            creationLabel.setText("Created by: " + creator);
            infoPanel.add(creationLabel);
        }
        creationDatetimeLabel.setText("Created at: " + creationDatetime);
        lastEditLabel.setText("Last Edit: " + lastPostDate);
        lastEditPanel.add(lastEditLabel, BorderLayout.LINE_END);
        titlePanel.add(titleLabel);
        titlePanel.add(lastEditPanel);
        infoPanel.add(creationDatetimeLabel);
        titleLabel.addMouseListener(myListener);
        infoPanel.addMouseListener(myListener);
        this.addMouseListener(myListener);
        this.add(titlePanel, BorderLayout.NORTH);
        this.add(infoPanel, BorderLayout.SOUTH);
        this.setMinimumSize(new Dimension(700, 150));
    }
    public JPanel getThisPanel() {
        return this;
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {
        titlePanel = new javax.swing.JPanel();
        infoPanel = new javax.swing.JPanel();
        lastEditPanel = new javax.swing.JPanel();
        lastEditLabel = new javax.swing.JLabel();
        creationLabel = new javax.swing.JLabel();
        creationDatetimeLabel = new javax.swing.JLabel();
        titleLabel = new javax.swing.JTextArea();

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

        lastEditLabel.setFont(new java.awt.Font("Yu Gothic Light", 0, 12)); // NOI18N
        lastEditLabel.setForeground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout lastEditPanelLayout = new javax.swing.GroupLayout(lastEditPanel);
        lastEditPanel.setLayout(lastEditPanelLayout);
        lastEditPanelLayout.setHorizontalGroup(
                lastEditPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lastEditPanelLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lastEditLabel)
                                .addGap(16, 16, 16))
        );
        lastEditPanelLayout.setVerticalGroup(
                lastEditPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(lastEditPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lastEditLabel)
                                .addContainerGap(23, Short.MAX_VALUE))
        );

        creationLabel.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 12)); // NOI18N
        creationLabel.setForeground(new java.awt.Color(102, 102, 102));

        creationDatetimeLabel.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 12)); // NOI18N
        creationDatetimeLabel.setForeground(new java.awt.Color(102, 102, 102));

        titleLabel.setColumns(20);
        titleLabel.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 36)); // NOI18N
        titleLabel.setRows(5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(10, 10)
                                .addComponent(infoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(creationDatetimeLabel)
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
                                                .addComponent(creationDatetimeLabel))))
        );
    }// </editor-fold>


    // Variables declaration - do not modify
    private javax.swing.JLabel creationLabel;
    private javax.swing.JLabel creationDatetimeLabel;
    private javax.swing.JPanel infoPanel;
    private javax.swing.JLabel lastEditLabel;
    private javax.swing.JPanel lastEditPanel;
    private javax.swing.JTextArea titleLabel;
    private javax.swing.JPanel titlePanel;
    // End of variables declaration
}