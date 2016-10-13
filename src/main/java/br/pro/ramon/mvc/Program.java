package br.pro.ramon.mvc;

import br.pro.ramon.mvc.controllers.ContadorController;
import br.pro.ramon.mvc.models.Contador;

public class Program {

    public static void main(String[] args) {
        Contador contador = new Contador();
        ContadorController contadorController = new ContadorController(contador);
        contadorController.showContadorView();
    }

}
