/*
 * Created by JFormDesigner on Fri Apr 05 09:22:21 IST 2024
 */

package com.main.ui.Panels;

import com.main.DAO.UserGroupDAO;
import com.main.ui.Frames.CreateGroupPage;
import com.main.ui.Frames.JoinGroupPage;
import com.main.model.UserGroup;
import com.main.util.SearchTextField;
import com.main.util.CreateGroupCardPanel;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.*;

/**
 * @author haras
 */
public class GroupHomepagePanel extends JPanel {private static JPanel mainPanel;

    String currentUsername;

    JScrollPane scrollPane;

    ArrayList<UserGroup> groupArrayList;
    JPanel parentPanel;
    
    public GroupHomepagePanel(String _currentUsername, JPanel parentPanel) {
        this.parentPanel = parentPanel;
        currentUsername = _currentUsername;
        groupArrayList = new UserGroupDAO().getGroupList(currentUsername);
        initComponents();
        gridPanel.removeAll();
        mainPanel = new JPanel();
        mainPanel.setBackground(Color.WHITE);
        scrollPane = new JScrollPane(mainPanel);
        scrollPane.setBackground(Color.WHITE);
        gridPanel.add(scrollPane);
        if(!groupArrayList.isEmpty()) {
            mainPanel.setLayout(new GridLayout(0, 1, 5, 1));
            groupArrayList.forEach(n -> {
                MouseListener myListener = new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if ((new UserGroupDAO().getRole(currentUsername, n.getGroupId()).equals("member"))) {
                            parentPanel.removeAll();
                            parentPanel.add(new MemberGroupNoteListPanel(currentUsername, n.getGroupId()));
                            parentPanel.repaint();
                            parentPanel.revalidate();
                        } else {
                            parentPanel.removeAll();
                            parentPanel.add(new AdminGroupNotesPanel(currentUsername, n.getGroupId(), parentPanel));
                            parentPanel.repaint();
                            parentPanel.revalidate();
                        }
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
                JPanel cardPanel = new CreateGroupCardPanel(n.getGroupName(), n.getCreator(), n.getDateJoined(), n.getLastPostDate(), currentUsername, myListener, n.getGroupId()).getThisPanel();
                mainPanel.add(cardPanel);
            });
            if(groupArrayList.size() != 3) {
                scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
                for(int i = groupArrayList.size(); i <= 3; i++) {
                    JPanel voidPanel = new JPanel();
                    mainPanel.add(voidPanel);
                }
            }
        } else {
            mainPanel.add(new JLabel("You are not in any group"));
        }
    }
    
    public JPanel getThisPanel() {
        return this;
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Harsh Itkar
        gridPanel = new JPanel();
        CreateGroupLabel = new JLabel();
        JoinGroupLabel = new JLabel();

        searchTextField = new SearchTextField();
        searchTextField.addKeyListener(new KeyListener() {@Override public void keyTyped(KeyEvent e) {
    }@Override public void keyPressed(KeyEvent e) {

    }@Override public void keyReleased(KeyEvent e) {
            searchFieldKeyReleased(e);
        }});

        //======== this ========
        setBackground(Color.black);
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing.
        border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn", javax. swing. border. TitledBorder. CENTER
        , javax. swing. border. TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .awt .Font
        .BOLD ,12 ), java. awt. Color. red) , getBorder( )) );  addPropertyChangeListener (
        new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062ord\u0065r"
        .equals (e .getPropertyName () )) throw new RuntimeException( ); }} );
        setLayout(null);

        //======== gridPanel ========
        {
            gridPanel.setLayout(new GridLayout(1, 1));
        }
        add(gridPanel);
        gridPanel.setBounds(0, 60, 700, 540);
        add(searchTextField);
        searchTextField.setBounds(20, 15, 400, 30);

        //---- CreateGroupLabel ----
        CreateGroupLabel.setText("Create Group");
        CreateGroupLabel.setForeground(Color.yellow);
        CreateGroupLabel.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 18));
        CreateGroupLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(CreateGroupLabel);
        CreateGroupLabel.setBounds(445, 15, 105, 30);
        CreateGroupLabel.addMouseListener(new MouseListener() {@Override public void mouseClicked(MouseEvent e) {
            createGroupButtonMouseClicked(e);
    }@Override public void mousePressed(MouseEvent e) {

    }@Override public void mouseReleased(MouseEvent e) {

    }@Override public void mouseEntered(MouseEvent e) {

    }@Override public void mouseExited(MouseEvent e) {

    }});

        //---- JoinGroupLabel ----
        JoinGroupLabel.setText("Join Group");
        JoinGroupLabel.setForeground(Color.yellow);
        JoinGroupLabel.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 18));
        JoinGroupLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(JoinGroupLabel);
        JoinGroupLabel.setBounds(570, 15, 105, 30);
        JoinGroupLabel.addMouseListener(new MouseListener() {@Override public void mouseClicked(MouseEvent e) {
            joinGroupButtonMouseClicked(e);
    }@Override public void mousePressed(MouseEvent e) {

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
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    private void createGroupButtonMouseClicked(MouseEvent e) {
        CreateGroupPage groupPrompt = new CreateGroupPage(currentUsername, parentPanel);
        groupPrompt.setSize(400, 200);
        groupPrompt.setVisible(true);
    }

    private void joinGroupButtonMouseClicked(MouseEvent e) {
        JoinGroupPage groupPrompt = new JoinGroupPage(currentUsername, parentPanel);
        groupPrompt.setSize(400, 200);
        groupPrompt.setVisible(true);
    }

    private void searchFieldKeyReleased(KeyEvent e) {
        String searchFieldText = searchTextField.getText().trim().toLowerCase();
        gridPanel.removeAll();
        mainPanel = new JPanel();
        scrollPane = new JScrollPane(mainPanel);
        gridPanel.add(scrollPane);
        mainPanel.setLayout(new GridLayout(0, 1));
        groupArrayList.forEach(n -> {
            if(n.getGroupName().toLowerCase(Locale.ROOT).contains(searchFieldText) || n.getCreator().toLowerCase(Locale.ROOT).contains(searchFieldText)) {
                MouseListener myListener = new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if ((new UserGroupDAO().getRole(currentUsername, n.getGroupId()).equals("member"))) {
                            parentPanel.removeAll();
                            parentPanel.add(new MemberGroupNoteListPanel(currentUsername, n.getGroupId()));
                            parentPanel.repaint();
                            parentPanel.revalidate();
                        } else {
                            parentPanel.removeAll();
                            parentPanel.add(new AdminGroupNotesPanel(currentUsername, n.getGroupId(), parentPanel));
                            parentPanel.repaint();
                            parentPanel.revalidate();
                        }
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
                JPanel cardPanel = new CreateGroupCardPanel(n.getGroupName(), n.getCreator(), n.getDateJoined(), n.getLastPostDate(), currentUsername, myListener, n.getGroupId()).getThisPanel();
                mainPanel.add(cardPanel);
            }
        });
        if(groupArrayList.size() != 3) {
            for(int i = groupArrayList.size(); i <= 3; i++) {
                scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
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
    private JLabel CreateGroupLabel;
    private JLabel JoinGroupLabel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
