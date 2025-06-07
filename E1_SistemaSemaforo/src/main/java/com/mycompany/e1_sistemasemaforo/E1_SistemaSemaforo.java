

package com.mycompany.e1_sistemasemaforo;

import SistemaSemaforo_Modelo.SemaforoModelo;
import SistemaSemaforo_Vista.SemaforoVista;
import SistemaSemaforo_Controlador.SemaforoControlador;

public class E1_SistemaSemaforo {

    public static void main(String[] args) {
        SemaforoModelo semaforoAvenida = new SemaforoModelo("Av. Javier Prado");
        SemaforoModelo semaforoCalle = new SemaforoModelo("Calle Abancay");

        SemaforoVista vista = new SemaforoVista();

        semaforoAvenida.agregarObservador(vista);
        semaforoCalle.agregarObservador(vista);

        SemaforoControlador controlador = new SemaforoControlador(semaforoAvenida, semaforoCalle);

        Thread hiloControl = new Thread(controlador);
        hiloControl.start();
    }
}
