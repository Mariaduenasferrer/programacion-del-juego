package juego.modelo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;


import juego.estructuras.Cola;

public class Partida {
    protected Tablero tablero;
    protected Jugador jugador1;
    protected Jugador jugador2;
    protected Cola<Jugador> colaTurnos;

    public Partida(int filas, int columnas) {
        tablero = new Tablero(filas, columnas);
        jugador1 = new Jugador("Jugador 1");
        jugador2 = new Jugador("Jugador 2");

        // Crear unidades iniciales
        Ingeniero ing1 = new Ingeniero(0, 0);
        Poeta poe1 = new Poeta(0, 1);
        jugador1.agregarUnidad(ing1);
        jugador1.agregarUnidad(poe1);
        tablero.getCasilla(0, 0).ocupar(ing1);
        tablero.getCasilla(0, 1).ocupar(poe1);

        Ingeniero ing2 = new Ingeniero(filas - 1, columnas - 1);
        Poeta poe2 = new Poeta(filas - 1, columnas - 2);
        jugador2.agregarUnidad(ing2);
        jugador2.agregarUnidad(poe2);
        tablero.getCasilla(filas - 1, columnas - 1).ocupar(ing2);
        tablero.getCasilla(filas - 1, columnas - 2).ocupar(poe2);

        // Inicializar cola de turnos
        colaTurnos = new Cola<>();
        colaTurnos.encolar(jugador1);
        colaTurnos.encolar(jugador2);
    }

    public Jugador getJugadorActual() {
        return colaTurnos.frente();
    }

    public void pasarTurno() {
        Jugador actual = colaTurnos.desencolar();
        colaTurnos.encolar(actual);
    }

    public boolean haTerminado() {
        return !jugador1.tieneUnidadesVivas() || !jugador2.tieneUnidadesVivas();
    }

    public String getGanador() {
        if (jugador1.tieneUnidadesVivas() && !jugador2.tieneUnidadesVivas()) {
            return jugador1.getNombre();
        } else if (jugador2.tieneUnidadesVivas() && !jugador1.tieneUnidadesVivas()) {
            return jugador2.getNombre();
        } else {
            return "Empate";
        }
    }

    public Tablero getTablero() {
        return tablero;
    }

    public Jugador getJugador1() {
        return jugador1;
    }

    public Jugador getJugador2() {
        return jugador2;
    }

    public void guardarPartida(String ruta) {
        try (FileWriter writer = new FileWriter(ruta)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            // Crea un mapa simple con la info esencial
            Map<String, Object> datos = new HashMap<>();
            datos.put("jugador1", exportarUnidades(jugador1));
            datos.put("jugador2", exportarUnidades(jugador2));
            datos.put("turno", getJugadorActual().getNombre());

            gson.toJson(datos, writer);
            System.out.println("Partida guardada en: " + ruta);
        } catch (IOException e) {
            System.out.println("Error al guardar la partida: " + e.getMessage());
        }
    }


    public static Partida cargarPartida(String ruta) {
        try (FileReader reader = new FileReader(ruta)) {
            Gson gson = new Gson();
            JsonObject json = JsonParser.parseReader(reader).getAsJsonObject();

            Partida partida = new Partida(10, 10); // Ajusta dimensiones si es necesario

            List<UnidadSerializable> lista1 = new ArrayList<>();
            List<UnidadSerializable> lista2 = new ArrayList<>();

            JsonArray array1 = json.getAsJsonArray("jugador1");
            JsonArray array2 = json.getAsJsonArray("jugador2");

            for (JsonElement e : array1) {
                lista1.add(gson.fromJson(e, UnidadSerializable.class));
            }

            for (JsonElement e : array2) {
                lista2.add(gson.fromJson(e, UnidadSerializable.class));
            }

            partida.cargarUnidades(lista1, partida.getJugador1());
            partida.cargarUnidades(lista2, partida.getJugador2());

            System.out.println("Partida cargada desde: " + ruta);
            return partida;

        } catch (Exception e) {
            System.out.println("Error al cargar la partida: " + e.getMessage());
            return null;
        }
    }


    public List<UnidadSerializable> exportarUnidades(Jugador jugador) {
        List<UnidadSerializable> lista = new ArrayList<>();
        var nodo = jugador.getUnidades().getCabeza();

        while (nodo != null) {
            Unidad u = nodo.valor;
            UnidadSerializable us = new UnidadSerializable();
            us.x = u.getX();
            us.y = u.getY();
            us.hp = u.getHp();
            us.tipo = u instanceof Ingeniero ? "Ingeniero" : "Poeta";
            lista.add(us);
            nodo = nodo.siguiente;
        }

        return lista;
    }

    public void cargarUnidades(List<UnidadSerializable> lista, Jugador jugador) {
        for (UnidadSerializable us : lista) {
            Unidad u;
            if (us.tipo.equals("Ingeniero")) {
                u = new Ingeniero(us.x, us.y);
            } else {
                u = new Poeta(us.x, us.y);
            }
            u.setHp(us.hp);
            jugador.agregarUnidad(u);
            tablero.getCasilla(us.x, us.y).ocupar(u);
        }
    }
}
