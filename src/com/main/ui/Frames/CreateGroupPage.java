/*
 * Created by JFormDesigner on Sat Mar 30 09:51:24 IST 2024
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
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @author Harsh Itkar
 */
public class CreateGroupPage extends JFrame {

    String currentUsername;
    JPanel parentPanel;
    public CreateGroupPage(String _currentUsername, JPanel _parentPanel) {
        parentPanel = _parentPanel;
        currentUsername = _currentUsername;
        initComponents();
        setTitle("NoteWorthy");
        setResizable(false);
    }


    public String generateRandomAlphanumericString(int length) {
        int leftLimit = 48;
        int rightLimit = 122;
        Random random = new Random();

        return random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(length)
                .mapToObj(codePoint -> String.valueOf((char) codePoint))
                .collect(Collectors.joining());
    }

    private void inputLabelKeyReleased(KeyEvent e) {
        inputErrorLabel.setText("");
        if(e.getKeyCode()==KeyEvent.VK_ENTER) {
            String groupName = inputField.getText();
            if(!groupName.isEmpty()) {
                String groupId = generateRandomAlphanumericString(6);
                UserGroupDAO dataBaseHelper = new UserGroupDAO();
                while(!dataBaseHelper.isGroupIdAvailable(groupId)) {
                    groupId = generateRandomAlphanumericString(6);
                }
                if(dataBaseHelper.createGroup(groupId, groupName, currentUsername)) {
                    JPanel createGroupPanel = new JPanel(new FlowLayout());
                    JLabel groupIdLabel = new JLabel("Your Group ID is ");
                    JTextField groupIdField = new JTextField();
                    groupIdField.setText(groupId);
                    groupIdField.setEditable(false);
                    createGroupPanel.add(groupIdLabel);
                    createGroupPanel.add(groupIdField);
                    JOptionPane.showMessageDialog(null, createGroupPanel);
                    parentPanel.removeAll();
                    parentPanel.add(new GroupHomepagePanel(currentUsername, parentPanel));
                    parentPanel.repaint();
                    parentPanel.revalidate();
                    this.dispose();
                } else {
                    inputErrorLabel.setText("Unable to create a group");
                }
            } else {
                inputErrorLabel.setText("Enter a group name");
            }
        }
    }

    private void okButtonMouseClicked(MouseEvent e) {
        String groupName = inputField.getText();
        if(!groupName.isEmpty()) {
            String groupId = generateRandomAlphanumericString(6);
            UserGroupDAO dataBaseHelper = new UserGroupDAO();
            while(!dataBaseHelper.isGroupIdAvailable(groupId)) {
                groupId = generateRandomAlphanumericString(6);
            }
            if(dataBaseHelper.createGroup(groupId, groupName, currentUsername)) {
                JPanel createGroupPanel = new JPanel(new FlowLayout());
                JLabel groupIdLabel = new JLabel("Your Group ID is ");
                JTextField groupIdField = new JTextField();
                groupIdField.setText(groupId);
                groupIdField.setEditable(false);
                createGroupPanel.add(groupIdLabel);
                createGroupPanel.add(groupIdField);
                JOptionPane.showMessageDialog(null, createGroupPanel);
                parentPanel.removeAll();
                parentPanel.add(new GroupHomepagePanel(currentUsername, parentPanel));
                parentPanel.repaint();
                parentPanel.revalidate();
                this.dispose();
            } else {
                inputErrorLabel.setText("Unable to create a group");
            }
        } else {
            inputErrorLabel.setText("Enter a group name");
        }
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Harsh Itkar
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        inputLabel = new JLabel();
        inputField = new JTextField();
        okButton = new JButton();
        inputErrorLabel = new JLabel();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setBorder ( new CompoundBorder ( new TitledBorder ( new EmptyBorder (
            0, 0 ,0 , 0) ,  "JFor\u006dDesi\u0067ner \u0045valu\u0061tion" , TitledBorder. CENTER ,TitledBorder
            . BOTTOM, new Font ( "Dia\u006cog", Font. BOLD ,12 ) ,Color .
            red ) ,dialogPane. getBorder () ) ); dialogPane. addPropertyChangeListener( new java. beans .PropertyChangeListener ( ){ @Override public void propertyChange (java .
            beans. PropertyChangeEvent e) { if( "bord\u0065r" .equals ( e. getPropertyName () ) )throw new RuntimeException( ) ;} } );
            dialogPane.setLayout(null);

            //======== contentPanel ========
            {
                contentPanel.setLayout(null);

                //---- inputLabel ----
                inputLabel.setText("Group Name");
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
            contentPanel.setBounds(10, 10, 374, 103);

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
        okButton.setBounds(165, 115, 75, 25);

        //---- inputErrorLabel ----
        inputErrorLabel.setForeground(Color.red);
        contentPane.add(inputErrorLabel);
        inputErrorLabel.setBounds(95, 70, 280, 20);

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
    private JButton okButton;
    private JLabel inputErrorLabel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
