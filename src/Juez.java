public class Juez extends Personas{
    private int nivel;

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public Juez(int id, String nombre, String apellido, String cedula, String pais, int nivel) {
        super(id, nombre, apellido, cedula, pais);
        this.nivel = nivel;
    }

    @Override
    public String toString() {
        return  "id=" + this.getId() +
                ", nombre='" + this.getNombre() + '\'' +
                ", apellido='" + this.getApellido() + '\'' +
                ", cedula='" + this.getCedula() + '\'' +
                ", pais='" + this.getPais() + '\'' +
                ", nivel=" + nivel;
    }
}
