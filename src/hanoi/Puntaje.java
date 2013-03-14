package hanoi;

public class Puntaje implements Comparable<Puntaje> {

    private String nombre;
    private int movimientos;
    private int numDiscos;
    private long tiempo;
    private boolean porMovimientos;

    public Puntaje(String nombre, int movimientos, long tiempo, int numDiscos, boolean porMovimientos) {

        this.nombre = nombre;
        this.movimientos = movimientos;
        this.tiempo = tiempo;
        this.numDiscos = numDiscos;
        this.porMovimientos = porMovimientos;
    }

    public int getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(int movimientos) {
        this.movimientos = movimientos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getTiempo() {
        return tiempo;
    }

    public void setTiempo(long tiempo) {
        this.tiempo = tiempo;
    }

    public int getNumDiscos() {
        return numDiscos;
    }

    public void setNumDiscos(int numDiscos) {
        this.numDiscos = numDiscos;
    }

    @Override
    public int compareTo(Puntaje o) {

        return this.porMovimientos ? this.movimientos - o.movimientos
                : (int) (this.tiempo - o.tiempo);
    }
}
