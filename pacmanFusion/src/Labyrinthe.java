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
                    //System.out.println(ligne);
                    tableau += ligne + "\n" ;

                }

            }
            //System.out.println(tableau);
        } catch (Exception ex){
            System.err.println("Error. "+ex.getMessage());
        }
    }
    
    public static int[][] convertion(String tab){
        int[][] lab;
        lab = new int[21][21];

        //int i = tab.length();
        //System.out.println(i);
        int y = 0;
        int z = 0;
        for (int x=0; x<tab.length(); x++){
            //System.out.println(tab.charAt(x));
            if (tab.charAt(x) == '1'){
                lab[y][z] = 1;
                y++;
            }
            if (tab.charAt(x) == '0'){
                lab[y][z] = 0;
                y++;
            }
            if (tab.charAt(x) == '8'){
                lab[y][z] = 8;
                y++;
            }
            if (tab.charAt(x) == '}'){
                z++;
                y=0;
            }

        }

        //for (int a=0; a<21;a++){
        //    for (int b=0; b<21; b++){
        //        System.out.println(lab[b][a]);
        //    }
        //}

        return lab;
    }
    
    
}
