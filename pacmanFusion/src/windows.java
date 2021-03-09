import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class windows extends javax.swing.JFrame{

    private ImageIcon image1;   //image
    private JLabel label;   //JLabel = à intérieur de JFrame, de la fenêtre
    private JFrame frame;   //JFrame c'est la fenêtre

    public windows(){

        //ajout image de fond
        image1 = new ImageIcon(this.getClass().getResource("resources/menu.jpg"));
        label = new JLabel(image1);
        label.setSize(800,600); //taille de l'image dans la fenêtre
        frame = new JFrame("Pac-Man");   //"titre" de la fenêtre
        frame.add(label); //ajout de l'image dans JLabel
        frame.setSize(800, 630); //taille de la fenêtre
        frame.setLayout(null);
        frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
        frame.setResizable(false); //interdire le redimensionnement de la fenêtre
        frame.setLocationRelativeTo(null); //méthode permettant d'annuler la disposition de la fenêtre par défaut (en haut à droite)
        frame.setVisible(true); //obligatoire pour afficher la fenêtre graphique

        // mise en place des boutons
        JButton bouton = new JButton("Commencer la partie");
        bouton.setBounds(310, 165, 170, 55); // position bouton 1
        label.add(bouton);

        JButton bouton2 = new JButton("Charger une partie");
        bouton2.setBounds(310, 300, 170, 50); // position bouton 2
        label.add(bouton2);

        JButton bouton3 = new JButton("Mode multijoueur");
        bouton3.setBounds(310, 350, 170, 50); // position bouton 3
        label.add(bouton3);

        JButton bouton4 = new JButton("Options");
        bouton4.setBounds(310, 400, 170, 50); // position bouton 4
        label.add(bouton4);

        JButton bouton5 = new JButton("Règles du jeu");
        bouton5.setBounds(310, 450, 170, 50); // position bouton 5
        label.add(bouton5);

        JButton bouton6 = new JButton("Quitter le jeu");
        bouton6.setBounds(310, 500, 170, 50); // position bouton 6
        label.add(bouton6);
        
        // mise en place de l'action des boutons (quand on clique dessus)
        // bouton "Commencer la partie"
        bouton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new model.PacFrame();
            }
        });
        
        // bouton "Quitter le jeu"
        bouton6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0); //on clique sur le bouton, la fenêtre se ferme
            }
        });
    }

}
