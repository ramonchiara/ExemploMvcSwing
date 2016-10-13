package br.pro.ramon.mvc.controllers;

import br.pro.ramon.mvc.models.Contador;
import br.pro.ramon.mvc.views.ContadorView;
import br.pro.ramon.mvc.views.TimerView;

public class ContadorController {

    private Contador contador;
    
    private ContadorView contadorView;
    private TimerView timerView;

    public ContadorController(Contador contador) {
        this.contador = contador;
    }

    public void showContadorView() {
        contadorView = new ContadorView(contador, this);
        contadorView.setVisible(true);
    }

    public void contar() {
        contador.contar();
    }

    public void showTimer() {
        if (timerView == null) {
            timerView = new TimerView(this);
        }
        timerView.setVisible(true);
    }

}
