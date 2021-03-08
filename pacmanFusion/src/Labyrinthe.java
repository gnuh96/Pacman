import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.*;

public class Labyrinthe {

    private int [][] tab;
    private String path = "resources/Laby.txt";

    public Labyrinthe(){//Constructeur
        setTab();//Creer tab
    }

    private void setTab() {//Init tab
        String tableau = readFile(this.path);//Lire fichier Laby
        this.tab = convertion(tableau);
    }

    public int[][] getTab(){//Obtenir tab
        return this.tab;
    }//Obtenir tab

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
    public int[][] convertion(String tab){
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
