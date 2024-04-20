package com.main.ui.Panels;

import com.main.DAO.AdminGroupDAO;
import com.main.DAO.GroupNotesDAO;
import com.main.DAO.UserDAO;
import com.main.DAO.UserGroupDAO;
import com.main.ui.Frames.AddNote;
import com.main.model.GroupNote;
import com.main.ui.Frames.ChangeGroupNamePage;
import com.main.util.SearchTextField;
import com.main.util.CreateNoteCardPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
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
                JPanel cardPanel = new CreateNoteCardPanel(n.getTitle(), n.getCreated_by(), n.getCreation_datetime(), n.getLast_edit_datetime(), n.getLast_edited_by(), currentUsername, myListener).getThisPanel();
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
        optionsLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                showPopupMenu(optionsLabel, e.getX(), e.getY());
            }
        });
    }

    private void showPopupMenu(Component component, int x, int y) {
        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem editGroupName = new JMenuItem("Edit Group Name");
        JMenuItem showMembersItem = new JMenuItem("Show Members");
        JMenuItem deleteGroupItem = new JMenuItem("Delete Group");
        UserGroupDAO userGroupDAO = new UserGroupDAO();
        editGroupName.addActionListener(e -> {
            new ChangeGroupNamePage(new UserGroupDAO().getGroupNameById(groupId), groupId, currentUsername, parentPanel);
        });
        showMembersItem.addActionListener(e -> {
            showMembersList(userGroupDAO.getGetGroupAdminList(currentUsername, groupId), userGroupDAO.getGroupMemberList(currentUsername, groupId));
        });
        deleteGroupItem.addActionListener(e -> {
            int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to Delete this group?", "Confirmation", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                if(userGroupDAO.deleteGroup(groupId)) {
                    parentPanel.removeAll();
                    parentPanel.add(new GroupHomepagePanel(currentUsername, parentPanel).getThisPanel());
                    parentPanel.repaint();
                    parentPanel.revalidate();
                }
            }
        });

        popupMenu.add(editGroupName);
        popupMenu.add(showMembersItem);
        popupMenu.add(deleteGroupItem);
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
        memberList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        memberList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1 && SwingUtilities.isRightMouseButton(e)) {
                    int index = memberList.locationToIndex(e.getPoint());
                    memberList.setSelectedIndex(index);
                    JPopupMenu popupMenu = createPopupMenu(panel, memberListModel.getElementAt(index));
                    popupMenu.show(memberList, e.getX(), e.getY());
                }
            }
        });
        JScrollPane memberScrollPane = new JScrollPane(memberList);
        memberPanel.add(memberScrollPane, BorderLayout.CENTER);
        panel.add(memberPanel);

        frame.add(panel);
        frame.setVisible(true);
    }

    private JPopupMenu createPopupMenu(JPanel parentPanel, String username) {
        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem makeAdminItem = new JMenuItem("Make Admin");
        AdminGroupDAO adminGroupDAO = new AdminGroupDAO();
        makeAdminItem.addActionListener(e -> {
            int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to make this user an admin?", "Confirmation", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                if(adminGroupDAO.makeAdmin(username, groupId)) {
                    UserGroupDAO userGroupDAO = new UserGroupDAO();

                    SwingUtilities.getWindowAncestor(parentPanel).dispose();
                    showMembersList(userGroupDAO.getGetGroupAdminList(currentUsername, groupId), userGroupDAO.getGroupMemberList(currentUsername, groupId));
                }
            }
        });
        JMenuItem removeItem = new JMenuItem("Remove");
        removeItem.addActionListener(e -> {
            int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to remove this user?", "Confirmation", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                if(adminGroupDAO.removeMember(username, groupId)) {
                    UserGroupDAO userGroupDAO = new UserGroupDAO();
                    SwingUtilities.getWindowAncestor(parentPanel).dispose();
                    showMembersList(userGroupDAO.getGetGroupAdminList(currentUsername, groupId), userGroupDAO.getGroupMemberList(currentUsername, groupId));
                }
            }
        });
        popupMenu.add(makeAdminItem);
        popupMenu.add(removeItem);
        return popupMenu;
    }

    private void initComponents() {
        gridPanel = new JPanel();
        AddNoteLabel = new JLabel();
        optionsLabel = new JLabel(new ImageIcon(getClass().getResource("/com/main/icons/options.png")));

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

        add(optionsLabel);
        optionsLabel.setForeground(Color.WHITE);
        optionsLabel.setBounds(670, 20, 20, 20);
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
                JPanel cardPanel = new CreateNoteCardPanel(n.getTitle(), n.getCreated_by(), n.getCreation_datetime(), n.getLast_edit_datetime(), n.getLast_edited_by(), currentUsername, myListener);
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
    JLabel optionsLabel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
