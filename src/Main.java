import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner entrada = new Scanner(System.in);
    static ArrayList<Personas> participantes;
    static ArrayList<Personas> jueces;
    static ArrayList<Partida> partidas;


    public static void main(String[] args) {

        System.out.println("-- BIENVENIDO AL MENU --\n");
        int opcion = 0;
        while(opcion!=-1){
            System.out.println("Ingrese una de las opciones:");
            System.out.println("1. Agregar jugador"); //
            System.out.println("2. Eliminar jugador"); //
            System.out.println("3. Modificar jugador"); //
            System.out.println("4. Agregar arbitro"); //
            System.out.println("5. Eliminar arbitro"); //
            System.out.println("6. Modificar arbitro"); //
            System.out.println("7. Agregar partida"); //
            System.out.println("8. Eliminar partida"); //
            System.out.println("9. Modificar partida"); //
            System.out.println("10. Mostrar todos los jugadores");
            System.out.println("10. Mostrar todas las partidas de un jugador");
            System.out.println("10. Mostrar todas las partidas de una fecha");




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
            int id = generarIdParticipantes();
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

    private static boolean agregarArbitro(){
        try{
            System.out.println("** AGREGAR UN ARBITRO **");
            int id = generarIdJueces();
            System.out.println("Ingrese nombre:");
            String nombre = entrada.nextLine();
            System.out.println("Ingrese apellido:");
            String apellido = entrada.nextLine();
            System.out.println("Ingrese cedula:");
            String cedula = entrada.nextLine();
            System.out.println("Ingrese pais:");
            String pais = entrada.nextLine();
            System.out.println("Ingrese nivel:");
            int nivel = Integer.parseInt(entrada.nextLine());
            if(nivel<1){
                System.out.println("Ingrese un nivel mayor o igual a 1");
                return false;
            }
            if(nivel>3){
                System.out.println("Ingrese un nivel menor o igual a 3");
                return false;
            }
            Personas unArbitro = new Juez(id, nombre, apellido, cedula, pais, nivel);
            jueces.add(unArbitro);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
    private static boolean eliminarArbitro(){
        try{
            System.out.println("**Eliminar un arbitro**");
            System.out.println(listarArbitros());
            int opcion = Integer.parseInt(entrada.nextLine());
            if(buscarArbitroEnPartida(opcion)){
                System.out.println("El arbitro se encuentra en una partida, no se puede eliminar.");
                return false;
            }
            else{
                jueces.remove(opcion-1);
                return true;
            }
        }
        catch (Exception e){
            System.out.println("Hubo un error para eliminar." +e.getMessage());
            return false;
        }

    }

    private static boolean modificarArbitro(){
        System.out.println(" ** SELECCIONE EL ARBITRO A MODIFICAR **");
        System.out.println(listarArbitros());
        int opcion = Integer.parseInt(entrada.nextLine());
        Personas modificado = buscarPorIdArbitro(opcion);
        if(modificado != null){
            System.out.println(modificado.toString());
            System.out.println("Ingrese nombre:");
            String nombre = entrada.nextLine();
            System.out.println("Ingrese apellido:");
            String apellido = entrada.nextLine();
            System.out.println("Ingrese cedula:");
            String cedula = entrada.nextLine();
            System.out.println("Ingrese pais:");
            String pais = entrada.nextLine();
            System.out.println("Ingrese nivel:");
            int nivel = Integer.parseInt(entrada.nextLine());
            modificado.setNombre(nombre);
            modificado.setApellido(apellido);
            modificado.setCedula(cedula);
            modificado.setPais(pais);
            Class clase = modificado.getClass();
            if(clase == Juez.class){
                ((Juez) modificado).setNivel(nivel);
            }
            jueces.set((modificado.getId()-1), modificado);
            return true;
        }
        else
        {
            System.out.println("El id no pertenece a un libro");
        }

        return false;
    }

    private static boolean agregarPartida(){
        try{
            System.out.println("** AGREGAR UNA PARTIDA **");
            int id = generarIdPartidas();
            System.out.println(" ** SELECCIONE EL JUGADOR 1 **");
            System.out.println(listarParticipantes());
            int opcion = Integer.parseInt(entrada.nextLine());
            Personas jugadorUno = buscarPorId(opcion);
            System.out.println(" ** SELECCIONE EL JUGADOR 2 **");
            System.out.println(listarParticipantes());
            int opcion2 = Integer.parseInt(entrada.nextLine());
            Personas jugadorDos = buscarPorId(opcion2);
            System.out.println(" ** SELECCIONE EL ARBITRO **");
            System.out.println(listarArbitros());
            int opcion3 = Integer.parseInt(entrada.nextLine());
            Personas juez = buscarPorIdArbitro(opcion3);
            System.out.println("INGRESE FECHA:");
            String fecha = entrada.nextLine();
            System.out.println("INGRESE TIPO DE PARTIDA:");
            String tipo = entrada.nextLine();
            if(tipo != "regional" || tipo != "nacional" || tipo != "internacional"){
                System.out.println("INGRESE TIPO DE PARTIDA CORRECTO.");
                return false;
            }

            Partida unaPartida = new Partida(id, (Jugador) jugadorUno, (Jugador) jugadorDos,(Juez) juez, fecha, tipo,(Jugador) jugadorUno);
            partidas.add(unaPartida);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
    private static boolean eliminarPartida(){
        try{
            System.out.println("**Eliminar una partida**");
            System.out.println(listarPartidas());
            int opcion = Integer.parseInt(entrada.nextLine());
            partidas.remove(opcion-1);
                return true;
        }
        catch (Exception e){
            System.out.println("Hubo un error para eliminar." +e.getMessage());
            return false;
        }

    }

    private static boolean modificarPartida(){
        System.out.println(" ** SELECCIONE LA PARTIDA A MODIFICAR **");
        System.out.println(listarPartidas());
        int opcion = Integer.parseInt(entrada.nextLine());
        Partida modificado = buscarPartida(opcion);
        if(modificado != null){
            System.out.println(" ** SELECCIONE EL JUGADOR 1 **");
            System.out.println(listarParticipantes());
            int opcion1 = Integer.parseInt(entrada.nextLine());
            Personas jugadorUno = buscarPorId(opcion);
            System.out.println(" ** SELECCIONE EL JUGADOR 2 **");
            System.out.println(listarParticipantes());
            int opcion2 = Integer.parseInt(entrada.nextLine());
            Personas jugadorDos = buscarPorId(opcion2);
            System.out.println("INGRESE TIPO DE PARTIDA:");
            String tipo = entrada.nextLine();

            if(tipo != "regional" || tipo != "nacional" || tipo != "internacional"){
                System.out.println("INGRESE TIPO DE PARTIDA CORRECTO.");
                return false;
            }

            System.out.println(" ** SELECCIONE EL ARBITRO **");
            System.out.println(listarArbitros());
            int opcion3 = Integer.parseInt(entrada.nextLine());
            Personas juez = buscarPorIdArbitro(opcion3);

            if(tipo.equals("nacional")){
                if( ((Juez) juez).getNivel() < 2 ){
                    System.out.println("ARBITRO NO APTO PARA ÉSTA PARTIDA.");
                    return false;
                }
            }
            if(tipo.equals("internacional")){
                if( ((Juez) juez).getNivel() < 3 ){
                    System.out.println("ARBITRO NO APTO PARA ÉSTA PARTIDA.");
                    return false;
                }
            }

            System.out.println("INGRESE FECHA:");
            String fecha = entrada.nextLine();

            System.out.println(" ** SELECCIONE EL GANADOR **" +
                                "   -1:"+jugadorUno.getNombre()+ " " + jugadorUno.getApellido()
                               +"   -2:"+jugadorDos.getNombre()+ " " + jugadorDos.getApellido());

            int opcion4 = Integer.parseInt(entrada.nextLine());
            Personas ganador = buscarPorId(opcion4);

            if(ganador.getId() == jugadorUno.getId() && ((Jugador) jugadorDos).getElo() == 0){

                ((Jugador) jugadorUno).setElo(((Jugador) jugadorUno).getElo()+10);

            }else if(((Jugador) jugadorUno).getElo() < ((Jugador) jugadorDos).getElo()) {

                ((Jugador) jugadorUno).setElo(((Jugador) jugadorUno).getElo() + (((Jugador) jugadorDos).getElo() - ((Jugador) jugadorUno).getElo()) / 4);
                ((Jugador) jugadorDos).setElo(((Jugador) jugadorDos).getElo() - (((Jugador) jugadorDos).getElo() - ((Jugador) jugadorUno).getElo()) / 4);

            }else{

                ((Jugador) jugadorUno).setElo( ((Jugador) jugadorUno).getElo() + (((Jugador) jugadorUno).getElo() - ((Jugador) jugadorDos).getElo())/8);
                ((Jugador) jugadorDos).setElo( ((Jugador) jugadorDos).getElo() - (((Jugador) jugadorUno).getElo() - ((Jugador) jugadorDos).getElo())/8);

            }

            if(ganador.getId() == jugadorDos.getId() &&((Jugador) jugadorUno).getElo()== 0){

                ((Jugador) jugadorDos).setElo( ((Jugador) jugadorDos).getElo()+10);

            }else if(((Jugador) jugadorDos).getElo() < ((Jugador) jugadorUno).getElo()){

                ((Jugador) jugadorDos).setElo( ((Jugador) jugadorDos).getElo() + (((Jugador) jugadorUno).getElo() - ((Jugador) jugadorDos).getElo())/4);

                ((Jugador) jugadorUno).setElo( ((Jugador) jugadorUno).getElo() - (((Jugador) jugadorUno).getElo() - ((Jugador) jugadorDos).getElo())/4);

            }else{

                ((Jugador) jugadorDos).setElo( ((Jugador) jugadorDos).getElo() + (((Jugador) jugadorDos).getElo() - ((Jugador) jugadorUno).getElo())/8);

                ((Jugador) jugadorUno).setElo( ((Jugador) jugadorUno).getElo() - (((Jugador) jugadorDos).getElo() - ((Jugador) jugadorUno).getElo())/8);

            }

            modificado.setJugadorUno((Jugador) jugadorUno);
            modificado.setJugadorDos((Jugador) jugadorDos);
            modificado.setArbitro((Juez) juez);
            modificado.setFecha(fecha);
            modificado.setTipo(tipo);
            modificado.setGanador((Jugador) ganador);
            partidas.set((modificado.getId()-1), modificado);
            return true;
        }
        else
        {
            System.out.println("El id no pertenece a un libro");
        }

        return false;
    }
    private static int generarIdParticipantes(){
        return participantes.size()+1;
    }
    private static int generarIdJueces(){
        return jueces.size()+1;
    }
    private static int generarIdPartidas(){
        return partidas.size()+1;
    }
    private static ArrayList<Personas> listarParticipantes(){
        return participantes;
    }
    private static ArrayList<Partida> listarPartidas(){
        return partidas;
    }
    private static ArrayList<Personas> listarArbitros(){
        return jueces;
    }
    private static boolean buscarEnPartida(int id){
        for (int i = 0; i < partidas.size(); i++) {
            if(partidas.get(i).getJugadorUno().getId() == id || partidas.get(i).getJugadorDos().getId() == id){
                return true;
            }
        }
        return false;
    }
    private static boolean buscarArbitroEnPartida(int id){
        for (int i = 0; i < partidas.size(); i++) {
            if(partidas.get(i).getArbitro().getId() == id){
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
    private static Personas buscarPorIdArbitro(int pId){
        for(Personas unaPersona: jueces) {
            if(unaPersona.getId()==pId){
                return unaPersona;
            }
        }
        return null;
    }
    private static Partida buscarPartida(int pId){
        for(Partida unaPartida: partidas) {
            if(unaPartida.getId()==pId){
                return unaPartida;
            }
        }
        return null;
    }
}