package juego.modelo;

import juego.estructuras.ListaEnlazada;

public class Jugador {
    private final String nombre;
    private final ListaEnlazada<Unidad> unidades;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.unidades = new ListaEnlazada<>();
    }

    public void agregarUnidad(Unidad unidad) {
        unidades.agregar(unidad);
    }

    public void eliminarUnidad(Unidad unidad) {
        unidades.eliminar(unidad);
    }

    public boolean tieneUnidadesVivas() {
        var actual = unidades.getCabeza();
        while (actual != null) {
            if (actual.valor.estaViva()) return true;
            actual = actual.siguiente;
        }
        return false;
    }

    public String getNombre() {
        return nombre;
    }

    public ListaEnlazada<Unidad> getUnidades() {
        return unidades;
    }
}

