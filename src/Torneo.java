import java.util.ArrayList;

public class Torneo {
    private static ArrayList<Personas> participantes;

    public static int getSize(){
        return participantes.size();
    }

    public static void addPlayer( Personas player){
        participantes.add(player);
    }
    public void deletePlayer (Personas player){
        participantes.remove(player);
    }

}
