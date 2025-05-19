package juego.modelo;

public abstract class Unidad {
    protected String nombre;
    protected int hp;
    protected int ataque;
    protected int defensa;
    protected int rangoMovimiento;
    protected int rangoAtaque;
    protected int x, y;

    public Unidad(String nombre, int hp, int ataque, int defensa, int rangoMovimiento, int rangoAtaque) {
        this.nombre = nombre;
        this.hp = hp;
        this.ataque = ataque;
        this.defensa = defensa;
        this.rangoMovimiento = rangoMovimiento;
        this.rangoAtaque = rangoAtaque;
    }

    public abstract String getTipo();

    public void moverA(int nuevaX, int nuevaY) {
        this.x = nuevaX;
        this.y = nuevaY;
    }

    public void recibirDanio(int danio) {
        this.hp -= danio;
    }

    public boolean estaViva() {
        return this.hp > 0;
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public int getHp() {
        return hp; }
    public String getNombre() { return nombre; }

    public boolean puedeAtacarA(Unidad objetivo) {
        int dx = Math.abs(this.x - objetivo.x);
        int dy = Math.abs(this.y - objetivo.y);
        return dx + dy <= this.rangoAtaque;
    }

    public void atacar(Unidad objetivo) {
        if (!puedeAtacarA(objetivo)) {
            System.out.println(this.nombre + " no puede atacar a " + objetivo.nombre + ": fuera de rango.");
            return;
        }

        int factorAleatorio = (int)(Math.random() * 3); // 0, 1 o 2
        int danio = factorAleatorio * this.ataque - objetivo.defensa;

        if (danio < 0) danio = 0;

        System.out.println(this.nombre + " ataca a " + objetivo.nombre + " con " + danio + " de daño.");
        objetivo.recibirDanio(danio);

        if (!objetivo.estaViva()) {
            System.out.println(objetivo.nombre + " ha sido derrotado.");
        }
    }

    public boolean puedeMoverA(int destinoX, int destinoY) {
        int dx = Math.abs(this.x - destinoX);
        int dy = Math.abs(this.y - destinoY);
        return dx + dy <= this.rangoMovimiento;
    }


    public void setHp(int hp) {
        this.hp = hp;
    }







}

