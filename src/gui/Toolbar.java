package gui;

import callbacks.ButtonListener;
import constants.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Toolbar extends JPanel implements ActionListener {

    private static final long serialVersionUID = 1l;
    private JButton startButton;
    private JButton restartButton;
    private ButtonListener buttonListener;

    public Toolbar() {
        initializeLayout();
    }

    private void initializeLayout() {
        setLayout(new FlowLayout(FlowLayout.LEFT));
        setBorder(BorderFactory.createEtchedBorder());

        startButton = new JButton(Constants.START);
        restartButton = new JButton(Constants.RESTART);
        restartButton.setEnabled(false);
        startButton.addActionListener(this);
        restartButton.addActionListener(this);

        add(startButton);
        add(restartButton);
    }

    public void setButtonListener(ButtonListener buttonListener) {
        this.buttonListener = buttonListener;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ((JButton) e.getSource() == startButton && buttonListener != null) {
            buttonListener.startClicked();
        } else if ((JButton) e.getSource() == restartButton && buttonListener != null) {
            buttonListener.restartClicked();
        }
    }

    public void setStartButton(boolean bool) {
        startButton.setEnabled(bool);
    }

    public void setRestartButton(boolean bool) {
        restartButton.setEnabled(bool);
    }

}
