package com.main.util;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


/**
 * @author Onkar Jadhav
 */
public class CreateGroupCardPanel extends javax.swing.JPanel {

    JPanel parentPanel;

    public CreateGroupCardPanel(JPanel _parentPanel, String groupName, String creator, String dateJoined, String lastPostDate, String currentUsername, MouseListener myListener, String groupId)
    {
        parentPanel = _parentPanel;
        initComponents();
        groupCodeTextArea.setEditable(false);
        groupCodeTextArea.setMaximumSize(new Dimension(50, groupCodeTextArea.getHeight()));
        groupCodeTextArea.setBackground(Color.getColor("#1f1f1f"));
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
        groupCodeTextArea.setText(groupId);
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

        groupCodeCopyLabel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                Transferable transferable = new StringSelection(groupId);
                clipboard.setContents(transferable, null);
                new toast(parentPanel, "Group code copied to clipboard", SwingUtilities.getWindowAncestor(parentPanel).getX()+550, SwingUtilities.getWindowAncestor(parentPanel).getY()+500).showtoast();
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
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
        groupCodeLabel = new javax.swing.JLabel();
        creationLabel = new javax.swing.JLabel();
        dateJoinedLabel = new javax.swing.JLabel();
        titleLabel = new javax.swing.JTextArea();
        groupCodePanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 5, 0));
        groupCodeCopyLabel = new JLabel(new ImageIcon(getClass().getResource("/com/main/icons/copy.png")));
        groupCodeTextArea = new JTextArea();

        groupCodeTextArea.setFont(new java.awt.Font("Yu Gothic Light", 0, 12)); // NOI18N
        groupCodeTextArea.setForeground(new java.awt.Color(102, 102, 102));

        groupCodeLabel.setFont(new java.awt.Font("Yu Gothic Light", 0, 12)); // NOI18N
        groupCodeLabel.setForeground(new java.awt.Color(102, 102, 102));
        groupCodeLabel.setText("Group Code: ");

        groupCodeCopyLabel.setSize(new Dimension(5, 5));

        groupCodePanel.setBackground(Color.white);
        groupCodePanel.add(groupCodeLabel);
        groupCodePanel.add(groupCodeTextArea);
        groupCodePanel.add(groupCodeCopyLabel);

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
                                        .addComponent(groupCodePanel, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(19, 19, 19))
        );
        lastEditPanelLayout.setVerticalGroup(
                lastEditPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(lastEditPanelLayout.createSequentialGroup()
                                .addComponent(lastEditLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(groupCodePanel)
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
    private JPanel groupCodePanel;
    private JTextArea groupCodeTextArea;
    private JLabel groupCodeLabel;
    private JLabel groupCodeCopyLabel;
    // End of variables declaration
}