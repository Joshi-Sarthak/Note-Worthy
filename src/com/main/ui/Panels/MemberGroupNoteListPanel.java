/*
 * Created by JFormDesigner on Fri Apr 05 21:19:14 IST 2024
 */

package com.main.ui.Panels;

import com.main.DAO.GroupNotesDAO;
import com.main.DAO.UserDAO;
import com.main.DAO.UserGroupDAO;
import com.main.ui.Frames.ViewNote;
import com.main.model.GroupNote;
import com.main.util.SearchTextField;
import com.main.util.CreateNoteCardPanel;

import java.awt.*;
import java.awt.color.ICC_ProfileGray;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.*;

/**
 * @author Harsh Itkar
 */
public class MemberGroupNoteListPanel extends JPanel {
    private static JPanel mainPanel;
    private static final String[] MENU_OPTIONS = {"Show Members", "Leave Group"};

    String currentUsername;
    JScrollPane scrollPane;
    ArrayList<GroupNote> groupNotesArrayList;

    String groupId;
    JPanel parentPanel;

    public MemberGroupNoteListPanel(JPanel _parentPanel, String _currentUsername, String _groupId) {
        parentPanel = _parentPanel;
        currentUsername = _currentUsername;
        groupId = _groupId;
        groupNotesArrayList = new GroupNotesDAO().getGroupNotesList(groupId);
        initComponents();
        searchTextField.setFocusable(false);
        mainPanel = new JPanel();
        scrollPane = new JScrollPane(mainPanel);
        gridPanel.add(scrollPane);
        populateNotesPanel();
    }

    private void showPopupMenu(Component component, int x, int y) {
        JPopupMenu popupMenu = new JPopupMenu();
        for (String option : MENU_OPTIONS) {
            JMenuItem menuItem = new JMenuItem(option);
            menuItem.addActionListener(e -> {
                UserGroupDAO userGroupDAO = new UserGroupDAO();
                if (option.equals("Show Members")) {
                    showMembersList(userGroupDAO.getGetGroupAdminList(currentUsername, groupId), userGroupDAO.getGroupMemberList(currentUsername, groupId));
                } else if (option.equals("Leave Group")) {
                    int prompt = JOptionPane.showConfirmDialog(null, "Are you sure you want to Leave this group?", "Confirmation", JOptionPane.YES_NO_OPTION);
                    if (prompt == JOptionPane.YES_OPTION) {
                        if(userGroupDAO.LeaveGroup(currentUsername, groupId)) {
                            parentPanel.removeAll();
                            parentPanel.add(new GroupHomepagePanel(currentUsername, parentPanel).getThisPanel());
                            parentPanel.repaint();
                            parentPanel.revalidate();
                        }
                    }
                }
            });
            popupMenu.add(menuItem);
        }
        popupMenu.show(component, x, y);
    }

    private void showMembersList(DefaultListModel<String> adminListModel, DefaultListModel<String> memberListModel) {
        JFrame frame = new JFrame("Group Members");
        frame.setSize(600, 300);
        frame.setLocationRelativeTo(null);
        JPanel panel = new JPanel(new GridLayout(1, 2));

        JPanel adminPanel = new JPanel(new BorderLayout());
        JLabel adminLabel = new JLabel("Admin List", SwingConstants.CENTER);
        adminPanel.add(adminLabel, BorderLayout.NORTH);

        JList<String> adminList = new JList<>(adminListModel);
        adminList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane adminScrollPane = new JScrollPane(adminList);
        adminPanel.add(adminScrollPane, BorderLayout.CENTER);
        panel.add(adminPanel);

        JPanel memberPanel = new JPanel(new BorderLayout());
        JLabel memberLabel = new JLabel("Member List", SwingConstants.CENTER);
        memberPanel.add(memberLabel, BorderLayout.NORTH);

        JList<String> memberList = new JList<>(memberListModel);
        JScrollPane memberScrollPane = new JScrollPane(memberList);
        memberPanel.add(memberScrollPane, BorderLayout.CENTER);
        panel.add(memberPanel);

        frame.add(panel);
        frame.setVisible(true);
    }

    private void populateNotesPanel() {
        if (!groupNotesArrayList.isEmpty()) {
            mainPanel.setLayout(new GridLayout(0, 1));
            groupNotesArrayList.forEach(n -> {
                MouseListener myListener = new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        new ViewNote(n.getTitle(), n.getContent());
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {}

                    @Override
                    public void mouseReleased(MouseEvent e) {}

                    @Override
                    public void mouseEntered(MouseEvent e) {}

                    @Override
                    public void mouseExited(MouseEvent e) {}
                };
                JPanel cardPanel = new CreateNoteCardPanel(n.getTitle(), n.getCreated_by(), n.getCreation_datetime(), n.getLast_edit_datetime(), n.getLast_edited_by(), currentUsername, myListener);
                mainPanel.add(cardPanel);
            });
            if (groupNotesArrayList.size() != 4) {
                scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
                for (int i = groupNotesArrayList.size(); i <= 4; i++) {
                    JPanel voidPanel = new JPanel();
                    mainPanel.add(voidPanel);
                }
            }
        } else {
            mainPanel.add(new JLabel("No notes posted"));
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Harsh Itkar
        gridPanel = new JPanel();

        searchTextField = new SearchTextField();
        optionsLabel = new JLabel(new ImageIcon(getClass().getResource("/com/main/icons/options.png")));
        optionsLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                showPopupMenu(optionsLabel, e.getX(), e.getY());
            }
        });
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

        //======== this ========
        setBackground(Color.black);
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax.
        swing. border. EmptyBorder( 0, 0, 0, 0) , "", javax. swing. border
        . TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM, new java .awt .Font ("Dialog"
        ,java .awt .Font .BOLD ,12 ), java. awt. Color. red) , getBorder
        ( )) );  addPropertyChangeListener (e-> {if ("border" .equals (e .getPropertyName () )) throw new RuntimeException
        ( ); } );
        setLayout(null);

        //======== gridPanel ========
        {
            gridPanel.setLayout(new GridLayout(1, 1));
        }
        add(gridPanel);
        gridPanel.setBounds(0, 60, 700, 540);
        add(searchTextField);
        searchTextField.setBounds(20, 15, 640, 30);

        optionsLabel.setForeground(Color.WHITE);
        optionsLabel.setBounds(670, 20, 20, 20);
        add(optionsLabel);

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
                        new ViewNote(n.getTitle(), n.getContent());
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
                JPanel cardPanel = new CreateNoteCardPanel(n.getTitle(), n.getCreated_by(), n.getCreation_datetime(), n.getLast_edit_datetime(), n.getLast_edited_by(), currentUsername, myListener);
                mainPanel.add(cardPanel);
            }
        });
        if(groupNotesArrayList.size() != 4) {
            scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
            for(int i = groupNotesArrayList.size(); i <= 4; i++) {
                JPanel voidPanel = new JPanel();
                mainPanel.add(voidPanel);
            }
        }
        gridPanel.revalidate();
        gridPanel.repaint();
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Harsh Itkar
    private JPanel gridPanel;
    private JTextField searchTextField;

    JLabel optionsLabel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}



