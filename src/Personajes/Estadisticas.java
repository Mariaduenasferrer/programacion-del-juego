package Personajes;

/** Esta es la clase del modelo de datos básico **/
public class Estadisticas {

    private int HP;
    private int RangoMovimiento;
    private int Ataque;
    private int Defensa;
    private String Habilidad;
    private int RangoAtaque;

    public Estadisticas(int HP, int RangoMovimiento, int RangoAtaque, String Habilidad, int Ataque, int Defensa) {
        this.HP = HP;
        this.RangoMovimiento = RangoMovimiento;
        this.RangoAtaque = RangoAtaque;
        this.Habilidad = Habilidad;
        this.Ataque = Ataque;
        this.Defensa = Defensa;
    }

    // Getters y Setters
    public int getHP() { return HP; }
    public void setHP(int HP) { this.HP = HP; }

    public int getRangoMovimiento() { return RangoMovimiento; }
    public void setRangoMovimiento(int RangoMovimiento) { this.RangoMovimiento = RangoMovimiento; }

    public int getRangoAtaque() { return RangoAtaque; }
    public void setRangoAtaque(int RangoAtaque) { this.RangoAtaque = RangoAtaque; }

    public String getHabilidad() { return Habilidad; }
    public void setHabilidad(String Habilidad) { this.Habilidad = Habilidad; }

    public int getAtaque() { return Ataque; }
    public void setAtaque(int Ataque) { this.Ataque = Ataque; }

    public int getDefensa() { return Defensa; }
    public void setDefensa(int Defensa) { this.Defensa = Defensa; }
}

