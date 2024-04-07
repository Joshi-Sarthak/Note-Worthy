/*
 * Created by JFormDesigner on Mon Apr 01 21:07:50 IST 2024
 */

package com.main.ui.Frames;

import com.main.ui.Panels.PersonalNotesHomepagePanel;
import com.main.ui.Panels.sideNavigationPanel;

import javax.swing.*;
import java.awt.*;

/**
 * @author haras
 */
public class NoteWorthyApp extends JFrame {
    String currentUsername;

    public NoteWorthyApp(String _currentUsername) {
        currentUsername = _currentUsername;
        initComponents();
        sideNavigationPanel.add(new sideNavigationPanel(mainPanel, currentUsername).getThisPanel());
        mainPanel.add(new PersonalNotesHomepagePanel(currentUsername, mainPanel).getThisPanel(), BorderLayout.LINE_START);
        setSize(new Dimension(1010, 630));
        setTitle("NoteWorthy");
        setResizable(false);
        setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Harsh Itkar
        sideNavigationPanel = new JPanel();
        mainPanel = new JPanel();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== sideNavigationPanel ========
        {
            sideNavigationPanel.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing
            .border.EmptyBorder(0,0,0,0), "JF\u006frmDesi\u0067ner Ev\u0061luatio\u006e",javax.swing.border.TitledBorder
            .CENTER,javax.swing.border.TitledBorder.BOTTOM,new java.awt.Font("Dialo\u0067",java.
            awt.Font.BOLD,12),java.awt.Color.red),sideNavigationPanel. getBorder()))
            ;sideNavigationPanel. addPropertyChangeListener(new java.beans.PropertyChangeListener(){@Override public void propertyChange(java.beans.PropertyChangeEvent e
            ){if("borde\u0072".equals(e.getPropertyName()))throw new RuntimeException();}})
            ;
            sideNavigationPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        }
        contentPane.add(sideNavigationPanel);
        sideNavigationPanel.setBounds(-5, 0, 300, 600);

        //======== mainPanel ========
        {
            mainPanel.setLayout(new FlowLayout());
        }
        contentPane.add(mainPanel);
        mainPanel.setBounds(295, 0, 700, 600);

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
    private JPanel sideNavigationPanel;
    private JPanel mainPanel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
