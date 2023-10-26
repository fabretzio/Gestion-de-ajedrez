public class Jugador extends Personas{
    private int elo;
    private int edad;

    public int getElo() {
        return elo;
    }

    public void setElo(int elo) {
        this.elo = elo;
    }


    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Jugador(int id, String nombre, String apellido, String cedula, int elo, String pais, int edad) {
        super(id, nombre, apellido, cedula, pais);
        this.elo = elo;
        this.edad = edad;
    }

    @Override
    public String toString() {
        return
                "id=" + this.getId() +
                ", nombre='" + this.getNombre() + '\'' +
                ", apellido='" + this.getApellido() + '\'' +
                ", cedula='" + this.getCedula() + '\'' +
                ", elo=" + elo +
                ", pais='" + this.getPais() + '\'' +
                ", edad=" + edad;
    }
}
