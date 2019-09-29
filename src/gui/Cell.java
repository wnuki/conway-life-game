package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Cell extends JPanel {

    private static final long serialVersionUID = 1l;
    private int id;
    private Board board;
    private boolean alive = false;

    public Cell(final int id, final Board board) {
        this.id = id;
        this.board = board;

        initializeLayout();
        initializeListener(id);
    }

    private void initializeListener(final int id) {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                setAlive(true);
                Cell.this.board.refreshBoard(id);
            }
        });
    }

    private void initializeLayout() {
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setBackground(Color.WHITE);
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public String toString() {
        return "Cell " + id;
    }
}
