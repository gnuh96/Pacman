public class main {
    public static void main(String[] args) {
        init();
        window();
    }
    public static void init(){
        pacman man = new pacman(100,100, 'm');
        pacman yel = new pacman(200,200, 'y');
        pacman blue = new pacman(300,100, 'b');
        pacman pink = new pacman(300,300, 'p');
        pacman red = new pacman(400,400, 'r');
    }
    public static void window(){
        windows NewWindow = new windows();
        NewWindow.setVisible(true);
    }
}
