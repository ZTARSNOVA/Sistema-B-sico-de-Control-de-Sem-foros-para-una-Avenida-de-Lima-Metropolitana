package SistemaSemaforo_Controlador;

import SistemaSemaforo_Modelo.SemaforoModelo;

public class SemaforoControlador implements Runnable {
    private SemaforoModelo semaforoJavierPrado;
    private SemaforoModelo semaforoAbancay;

    public SemaforoControlador(SemaforoModelo semaforoJavierPrado, SemaforoModelo semaforoAbancay) {
        this.semaforoJavierPrado = semaforoJavierPrado;
        this.semaforoAbancay = semaforoAbancay;
    }

    @Override
    public void run() {
        try {
            while (true) {
                // Estado inicial: Javier Prado en verde, Abancay en rojo
                semaforoJavierPrado.setEstado("VERDE");
                semaforoAbancay.setEstado("ROJO");
                Thread.sleep(4000);

                semaforoJavierPrado.setEstado("AMARILLO");
                Thread.sleep(2000);

                semaforoJavierPrado.setEstado("ROJO");
                semaforoAbancay.setEstado("VERDE");
                Thread.sleep(4000);

                semaforoAbancay.setEstado("AMARILLO");
                Thread.sleep(2000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


