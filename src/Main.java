import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("-- BIENVENIDO AL MENU --\n");
        int opcion = 0;
        while(opcion!=-1){
            System.out.println("Ingrese una de las opciones:");
            System.out.println("1. Agregar jugador");
            System.out.println("2. Eliminar jugador");
            System.out.println("3. Modificar jugador");
            System.out.println("4. Crear torneo");
            System.out.println("5. Listar torneos");
            System.out.println("6. Agregar arbitro");
            System.out.println("7. Eliminar arbitro");
            System.out.println("8. Modificar arbitro");

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
    private static boolean agregarJugadorTorneo(){
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
            Torneo.addPlayer(unJugador);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    private static int generarId(){
        return Torneo.getSize()+1;
    }
}