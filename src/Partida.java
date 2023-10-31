import java.util.Date;

public class Partida {

    private int id;
    private Jugador jugadorUno;
    private Jugador jugadorDos;

    private Juez arbitro;

    private String fecha;

    private String tipo;

    private Jugador ganador;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Jugador getJugadorUno() {
        return jugadorUno;
    }

    public void setJugadorUno(Jugador jugadorUno) {
        this.jugadorUno = jugadorUno;
    }

    public Jugador getJugadorDos() {
        return jugadorDos;
    }

    public void setJugadorDos(Jugador jugadorDos) {
        this.jugadorDos = jugadorDos;
    }

    public Juez getArbitro() {
        return arbitro;
    }

    public void setArbitro(Juez arbitro) {
        this.arbitro = arbitro;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Jugador getGanador() {
        return ganador;
    }

    public void setGanador(Jugador ganador) {
        this.ganador = ganador;
    }

    public Partida(int id, Jugador jugadorUno, Jugador jugadorDos, Juez arbitro, String fecha, String tipo, Jugador ganador) {
        this.id = id;
        this.jugadorUno = jugadorUno;
        this.jugadorDos = jugadorDos;
        this.arbitro = arbitro;
        this.fecha = fecha;
        this.tipo = tipo;
        this.ganador = ganador;
    }

    @Override
    public String toString() {
        return "Partida: " + id +
                ", jugadorUno= " + jugadorUno +
                ", jugadorDos= " + jugadorDos +
                ", arbitro= " + arbitro +
                ", fecha= " + fecha +
                ", tipo= " + tipo +
                ", ganador= " + ganador;
    }
}
