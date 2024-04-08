package com.main.util;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @author Onkar Jadhav
 */
public class SearchTextField extends JTextField implements FocusListener {

    private final String hint = "Search";
    private final ImageIcon icon;
    private boolean showingHint;

    public SearchTextField() {
        super("Search");
        this.showingHint = true;
        this.icon = new ImageIcon(getClass().getResource("/com/main/icons/search.png"));
        setIcon();
        this.setFocusable(false);
        JTextField thisInstance = this;
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                thisInstance.setFocusable(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        this.addFocusListener(this);
    }

    private void setIcon() {
        if (icon != null) {
            int iconWidth = icon.getIconWidth();
            int iconHeight = icon.getIconHeight();
            setBorder(BorderFactory.createCompoundBorder(getBorder(), BorderFactory.createEmptyBorder(0, iconWidth / 2, 0, 0)));
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (this.getText().isEmpty()) {
            super.setText("");
            showingHint = false;
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (this.getText().isEmpty()) {
            super.setText(hint);
            showingHint = true;
        }
    }

    @Override
    public String getText() {
        return showingHint ? "" : super.getText();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (icon != null) {
            int iconHeight = icon.getIconHeight();
            int y = (getHeight() - iconHeight) / 2;
            icon.paintIcon(this, g, 2, y);
        }
    }

    @Override
    public Insets getInsets() {
        Insets insets = super.getInsets();
        if (icon != null) {
            insets.left += icon.getIconWidth() / 2;
        }
        return insets;
    }
}
