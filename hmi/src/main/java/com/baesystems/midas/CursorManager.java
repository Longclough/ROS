package com.baesystems.midas;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;

public class CursorManager {

    private static CursorManager instance;

    public static CursorManager getInstance() {
        if (instance == null) {
            instance = new CursorManager();
        }
        return instance;
    }

    private JPanel panel;
    private Cursor modeCursor;
    private Cursor hoverCursor;

    private Cursor deleteCursor;
    private Cursor deleteHoverCursor;

    public void initialise(JPanel panel) {
        this.panel = panel;

        Image rawImage = Toolkit.getDefaultToolkit().getImage("resources/close.png");
        Dimension bestSize = Toolkit.getDefaultToolkit().getBestCursorSize(32, 32);
        Image i = rawImage.getScaledInstance((int) bestSize.getWidth(), (int) bestSize.getHeight(),
                java.awt.Image.SCALE_SMOOTH);

        Point p = new Point((int) bestSize.getWidth() / 2, (int) bestSize.getHeight() / 2);

        deleteCursor = Toolkit.getDefaultToolkit().createCustomCursor(i, p, "delete cursor");
        deleteHoverCursor = Toolkit.getDefaultToolkit().createCustomCursor(ImageUtils.colorImage(ImageUtils.toBufferedImage(i), Color.WHITE), p,
                "delete hover cursor");
    }

    public void pan() {
        modeCursor = Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR);
        hoverCursor = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);
        panel.setCursor(modeCursor);
    }

    public void create() {
        modeCursor = Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR);
        hoverCursor = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);
        panel.setCursor(modeCursor);
    }

    public void delete() {
        modeCursor = deleteCursor;
        hoverCursor = deleteHoverCursor;
        panel.setCursor(modeCursor);
    }

    public void hover() {
        panel.setCursor(hoverCursor);
    }

    public void unhover() {
        panel.setCursor(modeCursor);
    }

    public void startDrag() {
        panel.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
    }

    public void endDrag() {
        panel.setCursor(modeCursor);
    }
}