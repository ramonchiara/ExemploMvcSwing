package br.pro.ramon.mvc.models;

import java.util.Observable;

public class Contador extends Observable {

    private int n = 0;

    public void contar() {
        n++;

        // notifica os observadores que algo mudou...
        setChanged();
        notifyObservers();
    }

    public int getN() {
        return n;
    }

}
