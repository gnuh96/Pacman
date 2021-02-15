import static java.lang.Thread.sleep;

public class main {
    public static void main(String [] args) throws InterruptedException {
        new windows().setVisible(true); // windows+menu
        sleep(5000);
        new model.PacFrame();
    }
}
