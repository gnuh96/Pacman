package model;
import javax.swing.*;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;


public class PacFrame extends JFrame implements KeyListener,ActionListener{

    PacCompoments kcomp;
    private static Timer t;
    boolean stopped = true;

    private ImageIcon laby;//POUR TESTER LIMPORTATION DUN LABY
    private JLabel labytest;

    //during initialization frame is set, keylistener and action listener are set
    public PacFrame() {
        setLayout(new BorderLayout());
        laby = new ImageIcon(this.getClass().getResource("labytest.jpg"));//COMME AVEC LE MENU
        labytest = new JLabel(laby);//POUR AJOUTER LIMAGE
        kcomp = new PacCompoments();
        getContentPane().add(kcomp, BorderLayout.CENTER); //game is in center
        getContentPane().add(labytest);//REMPLACER "labytest" par METHODE CREER LABY
        addKeyListener(this);
        ActionListener listener = this;
        final int DELAY = 20;
        t = new Timer(DELAY, listener);
        setTitle("PAC-MAN");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(994,738));
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void AfficherLaby(){

    }
    public void keyPressed(KeyEvent e) {
        //inputs have a use while game is not finished
        if(!(kcomp.gameOver||kcomp.win)){
            //if game is not stopped and key code is space game stops
            if (!stopped &&e.getKeyCode() == KeyEvent.VK_SPACE){
                kcomp.stopped = true;
                stopped = true;
                t.stop();
                kcomp.reDraw();
            }
            //if game is stopped and keycode is space game continues
            else if (stopped&&e.getKeyCode() == KeyEvent.VK_SPACE){
                kcomp.stopped = false;
                stopped = false;
                t.start();
                kcomp.reDraw();
            }
            kcomp.pac.getInput(e.getKeyCode());
        }
    }
    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e){}
    public void actionPerformed(ActionEvent event){
        kcomp.reDraw();

    }
}