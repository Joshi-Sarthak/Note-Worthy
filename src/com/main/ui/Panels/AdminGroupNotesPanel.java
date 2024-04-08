/*
 * Created by JFormDesigner on Fri Apr 05 21:10:29 IST 2024
 */

package com.main.ui.Panels;

import com.main.DAO.GroupNotesDAO;
import com.main.ui.Frames.AddNote;
import com.main.model.GroupNote;
import com.main.util.SearchTextField;
import com.main.util.CreateNoteCardPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Locale;

/**
 * @author Harsh Itkar
 */
public class AdminGroupNotesPanel extends JPanel {
    private static JPanel mainPanel;

    String currentUsername;

    JScrollPane scrollPane;

    ArrayList<GroupNote> groupNotesArrayList;

    String groupId;

    JPanel parentPanel;
    public AdminGroupNotesPanel(String _currentUsername, String _groupId, JPanel parentPanel) {
        currentUsername = _currentUsername;
        groupId = _groupId;
        groupNotesArrayList = new GroupNotesDAO().getGroupNotesList(groupId);
        this.parentPanel = parentPanel;
        initComponents();
        searchTextField.setFocusable(false);
        mainPanel = new JPanel();
        scrollPane = new JScrollPane(mainPanel);
        gridPanel.add(scrollPane);
        if(!groupNotesArrayList.isEmpty()) {
            mainPanel.setLayout(new GridLayout(0, 1));
            groupNotesArrayList.forEach(n -> {
                MouseListener myListener = new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        new AddNote(currentUsername, groupId, n.getGroupNoteId(), parentPanel, n.getTitle(), n.getContent());
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
                };
                JPanel cardPanel = new CreateNoteCardPanel(n.getTitle(), n.getCreated_by(), n.getCreation_datetime(), n.getLast_edit_datetime(), currentUsername, myListener).getThisPanel();
                mainPanel.add(cardPanel);
            });
            if(groupNotesArrayList.size() != 4) {
                scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
                for(int i = groupNotesArrayList.size(); i <= 4; i++) {
                    JPanel voidPanel = new JPanel();
                    mainPanel.add(voidPanel);
                }
            }
        } else {
            mainPanel.add(new JLabel("No notes created"));
        }
    }

    private void initComponents() {
        gridPanel = new JPanel();
        AddNoteLabel = new JLabel();

        searchTextField = new SearchTextField();
        searchTextField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                searchFieldKeyReleased(e);
            }
        });

        setLayout(null);

        //======== gridPanel ========
        {
            gridPanel.setLayout(new GridLayout(1, 1));
        }
        add(gridPanel);
        gridPanel.setBounds(0, 60, 700, 540);
        add(searchTextField);
        searchTextField.setBounds(20, 15, 475, 30);

        //---- AddNoteLabel ----
        AddNoteLabel.setText("Add Note");
        AddNoteLabel.setForeground(Color.yellow);
        AddNoteLabel.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 18));
        AddNoteLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(AddNoteLabel);
        AddNoteLabel.setBounds(540, 20, 105, 20);
        AddNoteLabel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new AddNote(currentUsername, groupId, -1, parentPanel, null, null);
            }
        @Override
        public void mousePressed(MouseEvent e) {

    }@Override public void mouseReleased(MouseEvent e) {

    }@Override public void mouseEntered(MouseEvent e) {

    }@Override public void mouseExited(MouseEvent e) {

    }});

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < getComponentCount(); i++) {
                Rectangle bounds = getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            setMinimumSize(preferredSize);
            setPreferredSize(preferredSize);
        }
        setBackground(Color.BLACK);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    private void searchFieldKeyReleased(KeyEvent e) {
        String searchFieldText = searchTextField.getText().trim().toLowerCase();
        gridPanel.removeAll();
        mainPanel = new JPanel(new GridLayout(0, 1));
        scrollPane = new JScrollPane(mainPanel);
        gridPanel.add(scrollPane);
        groupNotesArrayList.forEach(n -> {
            if(n.getContent().toLowerCase(Locale.ROOT).contains(searchFieldText) || n.getTitle().toLowerCase(Locale.ROOT).contains(searchFieldText)) {
                MouseListener myListener = new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        new AddNote(currentUsername, groupId, n.getGroupNoteId(), parentPanel, n.getTitle(), n.getContent());
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
                };
                JPanel cardPanel = new CreateNoteCardPanel(n.getTitle(), n.getCreated_by(), n.getCreation_datetime(), n.getLast_edit_datetime(), currentUsername, myListener);
                mainPanel.add(cardPanel);
                if(groupNotesArrayList.size() != 4) {
                    scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
                    for(int i = groupNotesArrayList.size(); i <= 4; i++) {
                        JPanel voidPanel = new JPanel();
                        mainPanel.add(voidPanel);
                    }
                }
            }
        });
        gridPanel.revalidate();
        gridPanel.repaint();
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Harsh Itkar
    private JPanel gridPanel;
    private JTextField searchTextField;
    private JLabel AddNoteLabel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
