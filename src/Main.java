import java.util.ArrayList;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    static Scanner entrada = new Scanner(System.in);
    static ArrayList<Personas> participantes;
    static ArrayList<Partida> partidas;


    public static void main(String[] args) {

        System.out.println("-- BIENVENIDO AL MENU --\n");
        int opcion = 0;
        while(opcion!=-1){
            System.out.println("Ingrese una de las opciones:");
            System.out.println("1. Agregar jugador");
            System.out.println("2. Eliminar jugador");
            System.out.println("3. Modificar jugador");
            System.out.println("4. Agregar arbitro");
            System.out.println("5. Eliminar arbitro");
            System.out.println("6. Modificar arbitro");

            opcion = Integer.parseInt(entrada.nextLine());

            switch(opcion){
                case 1:{
                }
                default:{
                    if(opcion!=-1)
                        System.out.println("Opción inválida.");
                }
            }
        }
    }
    private static boolean agregarJugador(){
        try{
            System.out.println("** AGREGAR UN JUGADOR **");
            int id = generarId();
            System.out.println("Ingrese nombre:");
            String nombre = entrada.nextLine();
            System.out.println("Ingrese apellido:");
            String apellido = entrada.nextLine();
            System.out.println("Ingrese cedula:");
            String cedula = entrada.nextLine();
            int elo = 0;
            System.out.println("Ingrese pais:");
            String pais = entrada.nextLine();
            System.out.println("Ingrese edad:");
            int edad = Integer.parseInt(entrada.nextLine());
            Personas unJugador = new Jugador(id, nombre, apellido, cedula, elo, pais, edad);
            participantes.add(unJugador);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
    private static boolean eliminarJugador(){
        try{
            System.out.println("**Eliminar un parcitipante**");
            System.out.println(listarParticipantes());
            int opcion = Integer.parseInt(entrada.nextLine());
            if(buscarEnPartida(opcion)){
                System.out.println("El jugador se encuentra en una partida, no se puede eliminar.");
                return false;
            }
            else{
                participantes.remove(opcion-1);
                return true;
            }
        }
        catch (Exception e){
            System.out.println("Hubo un error para eliminar." +e.getMessage());
            return false;
        }

    }

    private static boolean modificarJugador(){
        System.out.println(" ** SELECCIONE EL PARTICIPANTE A MODIFICAR **");
        System.out.println(listarParticipantes());
        int opcion = Integer.parseInt(entrada.nextLine());
        Personas modificado = buscarPorId(opcion);
        if(modificado != null){
            System.out.println(modificado.toString());
            System.out.println("Ingrese nombre:");
            String nombre = entrada.nextLine();
            System.out.println("Ingrese apellido:");
            String apellido = entrada.nextLine();
            System.out.println("Ingrese cedula:");
            String cedula = entrada.nextLine();
            System.out.println("Ingrese elo:");
            int elo = Integer.parseInt(entrada.nextLine());
            System.out.println("Ingrese pais:");
            String pais = entrada.nextLine();
            System.out.println("Ingrese edad:");
            int edad = Integer.parseInt(entrada.nextLine());
            modificado.setNombre(nombre);
            modificado.setApellido(apellido);
            modificado.setCedula(cedula);
            modificado.setPais(pais);
            Class clase = modificado.getClass();
            if(clase == Jugador.class){
                ((Jugador) modificado).setElo(elo);
                ((Jugador) modificado).setEdad(edad);
            }
            participantes.set((modificado.getId()-1), modificado);
            return true;
        }
        else
        {
            System.out.println("El id no pertenece a un libro");
        }

        return false;
    }

    private static int generarId(){
        return participantes.size()+1;
    }
    private static ArrayList<Personas> listarParticipantes(){
        return participantes;
    }
    private static boolean buscarEnPartida(int id){
        for (int i = 0; i < partidas.size(); i++) {
            if(partidas.get(i).getJugadorUno().getId() == id || partidas.get(i).getJugadorDos().getId() == id){
                return true;
            }
        }
        return false;
    }
    private static Personas buscarPorId(int pId){
        for(Personas unaPersona: participantes) {
            if(unaPersona.getId()==pId){
                return unaPersona;
            }
        }
        return null;
    }
}