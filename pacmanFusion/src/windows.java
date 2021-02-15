import javax.swing.*;

public class windows extends JFrame{

    private ImageIcon image1;
    private JLabel label1;

    public windows(){
        super("Pac-Man");   //"titre" de la fenetre
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(800, 600); //taille de la fenetre
        setResizable(false); //interdire le redimensionnement de la fenetre
        this.setLocationRelativeTo(null);


        JPanel contentPane = (JPanel) this.getContentPane();
        setContentPane(MenuPrincipal());    //appel du menu principal
        image1 = new ImageIcon(getClass().getResource("resources/png/menu.jpg"));
        label1 = new JLabel(image1);
        add(label1);
    }
    private JPanel MenuPrincipal(){
        JPanel panel = new JPanel();
        //panel.setLayout(new FlowLayout());
        //setLayout(null);
        // mise en place des boutons
        JButton bouton = new JButton("Commencer la partie");
        //pas réussi à déplacer le bouton
        bouton.setBounds(190, 200, 900, 30);
        panel.add(bouton);

        JButton bouton2 = new JButton("Charger une partie");
        panel.add(bouton2);

        JButton bouton3 = new JButton("Mode multijoueur");
        panel.add(bouton3);

        JButton bouton4 = new JButton("Options");
        panel.add(bouton4);

        JButton bouton5 = new JButton("Règles du jeu");
        panel.add(bouton5);

        JButton bouton6 = new JButton("Règles du jeu");
        panel.add(bouton6);

        JButton bouton7 = new JButton("Quitter le jeu");
        panel.add(bouton7);

        return panel;
    }

}
