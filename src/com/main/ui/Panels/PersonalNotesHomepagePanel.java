/*
 * Created by JFormDesigner on Fri Apr 05 21:20:11 IST 2024
 */

package com.main.ui.Panels;

import com.main.ui.Frames.AddNote;
import com.main.DAO.Notedao;
import com.main.model.PersonalNote;
import com.main.util.HintTextField;
import com.main.util.createGroupCardPanel;
import com.main.util.createNoteCardPanel;

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
public class PersonalNotesHomepagePanel extends JPanel {
    private static JPanel mainPanel;

    String currentUsername;

    JScrollPane scrollPane;
    ArrayList<PersonalNote> personalNotesList;
    JPanel parentPanel;

    public PersonalNotesHomepagePanel(String _currentUsername, JPanel _parentPanel) {
        parentPanel = _parentPanel;
        currentUsername = _currentUsername;
        personalNotesList = new Notedao().loadNotes(currentUsername);
        initComponents();
        mainPanel = new JPanel();
        scrollPane = new JScrollPane(mainPanel);
        gridPanel.add(scrollPane);
        if(!personalNotesList.isEmpty()) {
            mainPanel.setLayout(new GridLayout(0, 1));
            personalNotesList.forEach(n -> {
                MouseListener myListener = new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        new AddNote(currentUsername, null, n.getNoteID(), parentPanel, n.getTitle(), n.getContent());
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
                JPanel cardPanel = new createNoteCardPanel(n.getTitle(),null, n.getCreationDateTime(), n.getLastEditDateTime(), currentUsername, myListener).getThisPanel();
                mainPanel.add(cardPanel);
            });
        } else {
            mainPanel.add(new JLabel("No notes created"));
        }
    }

    public JPanel getThisPanel() {
        return this;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Harsh Itkar
        gridPanel = new JPanel();
        searchTextField = new JTextField();
        AddNoteLabel = new JLabel();

        searchTextField = new HintTextField("Search by title");
        searchTextField.addKeyListener(new KeyListener() {@Override public void keyTyped(KeyEvent e) {

    }@Override public void keyPressed(KeyEvent e) {

    }@Override public void keyReleased(KeyEvent e) {
    searchFieldKeyReleased(e);
    }});

        //======== this ========
        setBackground(Color.black);
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border.
        EmptyBorder( 0, 0, 0, 0) , "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn", javax. swing. border. TitledBorder. CENTER, javax. swing
        . border. TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 ),
        java. awt. Color. red) , getBorder( )) );  addPropertyChangeListener (new java. beans. PropertyChangeListener( )
        { @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062ord\u0065r" .equals (e .getPropertyName () ))
        throw new RuntimeException( ); }} );
        setLayout(null);

        //======== gridPanel ========
        {
            gridPanel.setLayout(new GridLayout(0, 1));
        }
        add(gridPanel);
        gridPanel.setBounds(0, 60, 700, 540);
        add(searchTextField);
        searchTextField.setBounds(20, 15, 505, 30);

        //---- AddNoteLabel ----
        AddNoteLabel.setText("Add Note");
        AddNoteLabel.setForeground(Color.yellow);
        AddNoteLabel.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 18));
        AddNoteLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(AddNoteLabel);
        AddNoteLabel.setBounds(560, 20, 105, 20);
        AddNoteLabel.addMouseListener(new MouseListener() {@Override public void mouseClicked(MouseEvent e) {
            new AddNote(currentUsername, null, -1, parentPanel, null, null);
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

    private void searchFieldKeyReleased(KeyEvent e) {
        String searchFieldText = searchTextField.getText().trim().toLowerCase();
        gridPanel.removeAll();
        mainPanel = new JPanel(new GridLayout(0, 1, 10, 10));
        scrollPane = new JScrollPane(mainPanel);
        gridPanel.add(scrollPane);
        personalNotesList.forEach(n -> {
            if(n.getContent().toLowerCase(Locale.ROOT).contains(searchFieldText) || n.getTitle().toLowerCase(Locale.ROOT).contains(searchFieldText)) {
                MouseListener myListener = new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        new AddNote(currentUsername, null, n.getNoteID(), parentPanel, n.getTitle(), n.getContent());
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
                JPanel cardPanel = new createNoteCardPanel(n.getTitle(),null, n.getCreationDateTime(), n.getLastEditDateTime(), currentUsername, myListener).getThisPanel();
                mainPanel.add(cardPanel);
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
