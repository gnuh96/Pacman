import javax.swing.*;

public class windows extends JFrame{
   public windows(){
       super("Pac-Man");
       this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
       this.setSize(800, 600);
       this.setLocationRelativeTo(null);

       JPanel contentPane = (JPanel) this.getContentPane();
       //contentPane.add();
   }
}
