package br.pro.ramon.mvc.views;

import br.pro.ramon.mvc.controllers.ContadorController;
import br.pro.ramon.mvc.models.Contador;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ContadorView extends JFrame implements ActionListener, Observer {

    private Contador contador;
    private ContadorController contadorController;

    private JLabel lblContador, lblN;
    private JButton btnContar, btnTimer;

    public ContadorView(Contador contador, ContadorController contadorController) {
        this.contador = contador;
        this.contadorController = contadorController;

        // avisa o model que esta (this) janela irá observá-lo...
        contador.addObserver(this);

        setTitle("Contador");

        lblContador = new JLabel("Contador: ");
        lblN = new JLabel("");
        btnContar = new JButton("Contar");
        btnTimer = new JButton("Timer");

        updateLblN();

        JPanel p = new JPanel(new GridLayout(2, 2, 5, 5));
        p.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        p.add(lblContador);
        p.add(lblN);
        p.add(btnContar);
        p.add(btnTimer);

        setContentPane(p);
        pack();

        btnContar.addActionListener(this);
        btnTimer.addActionListener(this);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        if (src == btnContar) {
            contadorController.contar();
        } else if (src == btnTimer) {
            contadorController.showTimer();
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        updateLblN();
    }

    private void updateLblN() {
        lblN.setText(String.valueOf(contador.getN()));
    }

}
