import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.*;

public class Labyrinthe {
    private String tab;
    private String path = "resources/Laby.txt";
    public Labyrinthe(){//Constructeur
        setTab();//Creer tab
    }
    public void setTab() {//Init tab
        this.tab = readFile(this.path);//Lire fichier Laby
    }
    public String getTab(){//Obtenir tab
        return this.tab;
    }
    public static String readFile(String pathToFile){//Lire path
        String tableau = "";

        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(pathToFile)));
            String ligne;
            while((ligne = reader.readLine()) != null){
                if(ligne.startsWith("{")||ligne.startsWith("}")){
                    System.out.println(ligne);
                    tableau += ligne;

                }
            }
        } catch (Exception ex){
            System.err.println("Error. "+ex.getMessage());
        }
        return tableau;
    }
}