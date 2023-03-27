package models;

import java.awt.*;
import javax.swing.*;

public class WhiteOutlineLabel extends JLabel {

    public WhiteOutlineLabel(String text) {
        super(text);
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.WHITE, 4),
                BorderFactory.createEmptyBorder(1, 1, 1, 1)));
        setForeground(Color.BLACK);
    }

}