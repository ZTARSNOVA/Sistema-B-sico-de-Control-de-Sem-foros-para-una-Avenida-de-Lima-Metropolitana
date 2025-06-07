package SistemaSemaforo_Modelo;

import SistemaSemaforo_Observer.SemaforoObserver;
import java.util.*;

public class SemaforoModelo {
    private List<SemaforoObserver> observadores;
    private String nombre;
    private String estado;

    public SemaforoModelo(String nombre) {
        this.nombre = nombre;
        observadores = new ArrayList<>();
        estado = "ROJO";
    }

    public String getNombre() {
        return nombre;
    }

    public synchronized String getEstado() {
        return estado;
    }

    public synchronized void setEstado(String estado) {
        this.estado = estado;
        notificarObservadores();
    }

    public void agregarObservador(SemaforoObserver obs) {
        observadores.add(obs);
    }

    public void quitarObservador(SemaforoObserver obs) {
        observadores.remove(obs);
    }

    private void notificarObservadores() {
        for (SemaforoObserver obs : observadores) {
            new Thread(() -> obs.actualizar(nombre, estado)).start();
        }
    }
}