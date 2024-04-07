/*
 * Created by JFormDesigner on Sat Mar 30 09:44:24 IST 2024
 */

package com.main.ui.Frames;

import com.main.DAO.UserGroupDAO;
import com.main.ui.Panels.GroupHomepagePanel;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;

/**
 * @author haras
 */
public class JoinGroupPage extends JFrame {
    String currentUsername;
    JPanel parentPanel;
    public JoinGroupPage(String _currentUsername, JPanel _parentPanel) {
        parentPanel = _parentPanel;
        currentUsername = _currentUsername;
        initComponents();
        setTitle("NoteWorthy");
        setResizable(false);
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

    private void inputLabelKeyReleased(KeyEvent e) {
        inputErrorLabel.setText("");
        if(e.getKeyCode() == KeyEvent.VK_ENTER) {
            String groupId = inputField.getText().trim();
            if(isAlphanumeric(groupId) && !groupId.isEmpty()) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                } catch(Exception ex) {
                    throw new RuntimeException(ex);
                }
                UserGroupDAO dataBaseHelper = new UserGroupDAO();
                if(!dataBaseHelper.isGroupIdAvailable(groupId)) {
                    if(dataBaseHelper.joinGroup(currentUsername, groupId)) {
                        JOptionPane.showMessageDialog(null, "Group Joined successfully");
                        parentPanel.removeAll();
                        parentPanel.add(new GroupHomepagePanel(currentUsername, parentPanel));
                        parentPanel.repaint();
                        parentPanel.revalidate();
                        this.dispose();
                    } else {
                        inputErrorLabel.setText("You are already in the group");
                    }
                } else {
                    inputErrorLabel.setText("Group with code " + groupId + " doesn't exixts");
                }
            } else {
                inputErrorLabel.setText("Enter a valid code of 6 alphanumeric characters");
            }
        }
    }

    private void okButtonMouseClicked(MouseEvent e) {
        String groupId = inputField.getText().trim();
        if(isAlphanumeric(groupId) && !groupId.isEmpty()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch(Exception ex) {
                throw new RuntimeException(ex);
            }
            UserGroupDAO dataBaseHelper = new UserGroupDAO();
            if(!dataBaseHelper.isGroupIdAvailable(groupId)) {
                if(dataBaseHelper.joinGroup(currentUsername, groupId)) {
                    JOptionPane.showMessageDialog(null, "Group Joined successfully");
                    parentPanel.removeAll();
                    parentPanel.add(new GroupHomepagePanel(currentUsername, parentPanel));
                    parentPanel.repaint();
                    parentPanel.revalidate();
                    this.dispose();
                } else {
                    inputErrorLabel.setText("You are already in the group");
                }
            } else {
                inputErrorLabel.setText("Group with code " + groupId + " doesn't exixts");
            }
        } else {
            inputErrorLabel.setText("Enter a valid code of 6 alphanumeric characters");
        }
    }
    
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Harsh Itkar
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        inputLabel = new JLabel();
        inputField = new JTextField();
        buttonBar = new JPanel();
        okButton = new JButton();
        inputErrorLabel = new JLabel();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setBorder ( new CompoundBorder ( new TitledBorder ( new EmptyBorder ( 0, 0 ,0 , 0) ,  "JFor\u006dDesi\u0067ner \u0045valu\u0061tion" , TitledBorder
            . CENTER ,TitledBorder . BOTTOM, new Font ( "Dia\u006cog", Font. BOLD ,12 ) ,Color .red ) ,dialogPane. getBorder () ) )
            ; dialogPane. addPropertyChangeListener( new java. beans .PropertyChangeListener ( ){ @Override public void propertyChange (java . beans. PropertyChangeEvent e
            ) { if( "bord\u0065r" .equals ( e. getPropertyName () ) )throw new RuntimeException( ) ;} } )
            ;
            dialogPane.setLayout(null);

            //======== contentPanel ========
            {
                contentPanel.setLayout(null);

                //---- inputLabel ----
                inputLabel.setText("Group Code");
                contentPanel.add(inputLabel);
                inputLabel.setBounds(5, 35, 75, 20);

                //---- inputField ----
                inputField.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyReleased(KeyEvent e) {
                        inputLabelKeyReleased(e);
                    }
                });
                contentPanel.add(inputField);
                inputField.setBounds(85, 30, 280, 30);

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < contentPanel.getComponentCount(); i++) {
                        Rectangle bounds = contentPanel.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = contentPanel.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    contentPanel.setMinimumSize(preferredSize);
                    contentPanel.setPreferredSize(preferredSize);
                }
            }
            dialogPane.add(contentPanel);
            contentPanel.setBounds(12, 12, 374, 93);

            //======== buttonBar ========
            {
                buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
                buttonBar.setLayout(null);

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < buttonBar.getComponentCount(); i++) {
                        Rectangle bounds = buttonBar.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = buttonBar.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    buttonBar.setMinimumSize(preferredSize);
                    buttonBar.setPreferredSize(preferredSize);
                }
            }
            dialogPane.add(buttonBar);
            buttonBar.setBounds(10, 110, 375, 35);

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < dialogPane.getComponentCount(); i++) {
                    Rectangle bounds = dialogPane.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = dialogPane.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                dialogPane.setMinimumSize(preferredSize);
                dialogPane.setPreferredSize(preferredSize);
            }
        }
        contentPane.add(dialogPane);
        dialogPane.setBounds(0, 0, 398, 75);

        //---- okButton ----
        okButton.setText("OK");
        okButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                okButtonMouseClicked(e);
            }
        });
        contentPane.add(okButton);
        okButton.setBounds(170, 115, 60, okButton.getPreferredSize().height);

        //---- inputErrorLabel ----
        inputErrorLabel.setForeground(Color.red);
        contentPane.add(inputErrorLabel);
        inputErrorLabel.setBounds(95, 75, 280, 20);

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Harsh Itkar
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JLabel inputLabel;
    private JTextField inputField;
    private JPanel buttonBar;
    private JButton okButton;
    private JLabel inputErrorLabel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
