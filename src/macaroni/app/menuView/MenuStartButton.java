package macaroni.app.menuView;

import macaroni.app.AssetManager;
import macaroni.app.GameColors;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;

/**
 * The class of the start button in the menu.
 */
public final class MenuStartButton extends JButton {
    /**
     * Constructor, creates a new MenuStartButton.
     *
     * @param positionOfCenter the center of the button on the screen in pixel coordinates
     * @param size the size of the button in pixels
     * @param listener the method that gets called if the button is clicked
     */
    public MenuStartButton(Point positionOfCenter, Dimension size, ActionListener listener) {
        super("START");
        setSize(size);
        setLocation(positionOfCenter.x - getWidth() / 2, positionOfCenter.y - getHeight() / 2);
        addActionListener(listener);
        setFont(AssetManager.getFont("ChakraPetch-Regular.ttf").deriveFont(Font.BOLD, size.height / 1.6f));
        setFocusPainted(false);
        setBorder(null);
    }

    /**
     * Method used to draw the button on screen.
     *
     * @param g the graphics
     */
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int width = getWidth();
        int height = getHeight();

        float outerBorder = getWidth() / 12.0f, innerBorder = outerBorder * 0.8f;
        int arc = getWidth() / 4;

        RoundRectangle2D outerBorderRectangle = new RoundRectangle2D.Double(0, 0, width, height, arc, arc);
        g2.setColor(GameColors.oceanBlue);
        g2.fill(outerBorderRectangle);

        RoundRectangle2D innerBorderRectangle = new RoundRectangle2D.Double(innerBorder / 2, innerBorder / 2, width - innerBorder, height - innerBorder, arc- innerBorder, arc- innerBorder);
        g2.setColor(GameColors.snowWhite);
        g2.fill(innerBorderRectangle);

        RoundRectangle2D baseRectangle = new RoundRectangle2D.Double(outerBorder / 2.0f, outerBorder / 2.0f, width - outerBorder, height - outerBorder, arc - outerBorder, arc - outerBorder);
        g2.setColor(getModel().isPressed() ? GameColors.oceanBlue : GameColors.lateSunset);
        g2.fill(baseRectangle);

        g2.setColor(getModel().isRollover() ? GameColors.snowWhite : GameColors.desertYellow);
        g2.setFont(getFont());

        FontMetrics fontMetrics = g2.getFontMetrics();
        int textX = (width - fontMetrics.stringWidth(getText())) / 2;
        int textY = (height - fontMetrics.getHeight()) / 2 + fontMetrics.getAscent();
        g2.drawString(getText(), textX, textY);

        g2.dispose();
    }
}
