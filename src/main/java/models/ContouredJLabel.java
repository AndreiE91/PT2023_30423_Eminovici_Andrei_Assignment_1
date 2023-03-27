package models;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import javax.swing.JLabel;

public class ContouredJLabel extends JLabel {

    private Color strokeColor = Color.WHITE;
    private Color fillColor = Color.BLACK;

    public ContouredJLabel(String text) {
        super(text);
    }

    public void setStrokeColor(Color color) {
        strokeColor = color;
    }

    public void setFillColor(Color color) {
        fillColor = color;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        Font font = getFont();
        String text = getText();
        FontRenderContext frc = g2d.getFontRenderContext();
        GlyphVector gv = font.createGlyphVector(frc, text);
        int w = (int) gv.getVisualBounds().getWidth();
        int h = (int) gv.getVisualBounds().getHeight();

        int x = (getWidth() - w) / 2;
        int y = ((getHeight() - h) / 2) + ((int) -gv.getVisualBounds().getY());

        g2d.setColor(fillColor);
        g2d.drawString(text, x, y);

        g2d.setColor(strokeColor);
        g2d.draw(gv.getOutline(x, y));

        // Fill inside of letters with a different color
        g2d.setColor(Color.RED);
        g2d.fill(gv.getOutline(x, y));
    }
}
