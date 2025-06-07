
package SistemaSemaforo_Vista;

import SistemaSemaforo_Observer.SemaforoObserver;

public class SemaforoVista implements SemaforoObserver {
    @Override
    public void actualizar(String nombreSemaforo, String estado) {
        System.out.println("[" + nombreSemaforo + "] Estado actual: " + estado);
    }
}