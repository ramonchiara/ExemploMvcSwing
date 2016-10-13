package br.pro.ramon.mvc.views;

import br.pro.ramon.mvc.controllers.ContadorController;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class TimerView extends JFrame implements ActionListener, ChangeListener {

    private ContadorController contadorController;

    private JButton btnIniciar, btnParar;
    private JLabel lblTimer;
    private JSlider sldTimer;
    private Timer timer;

    public TimerView(ContadorController contadorController) {
        this.contadorController = contadorController;

        setTitle("Timer");

        btnIniciar = new JButton("Iniciar");
        btnParar = new JButton("Parar");
        sldTimer = new JSlider(0, 1000, 100);
        lblTimer = new JLabel(String.valueOf(sldTimer.getValue()));
        timer = new Timer(sldTimer.getValue(), this);

        JPanel p1 = new JPanel(new GridLayout(1, 2, 5, 5));
        p1.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        p1.add(btnIniciar);
        p1.add(btnParar);

        JPanel p2 = new JPanel(new BorderLayout(5, 5));
        p2.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        p2.add(sldTimer, BorderLayout.CENTER);
        p2.add(lblTimer, BorderLayout.EAST);

        JPanel p = new JPanel(new GridLayout(2, 1, 5, 5));
        p.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        p.add(p1);
        p.add(p2);

        setContentPane(p);
        pack();

        btnIniciar.addActionListener(this);
        btnParar.addActionListener(this);
        sldTimer.addChangeListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        if (src == btnIniciar) {
            timer.start();
        } else if (src == btnParar) {
            timer.stop();
        } else if (src == timer) {
            contadorController.contar();
        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        lblTimer.setText(String.valueOf(sldTimer.getValue()));
        timer.setDelay(sldTimer.getValue());
    }

}
