import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.*;

public class Labyrinthe {
    public static void main(String[] args) {
        readFile("Data/Laby.txt");
    }

    public static void readFile(String pathToFile){
        String tableau = "";

        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(pathToFile)));
            String ligne;
            while((ligne = reader.readLine()) != null){
                if(ligne.startsWith("{")||ligne.startsWith("}")){
                    System.out.println(ligne);
                    tableau += ligne + "\n" ;

                }

            }
            System.out.println(tableau);
        } catch (Exception ex){
            System.err.println("Error. "+ex.getMessage());
        }
    }
}