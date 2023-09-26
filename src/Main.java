import Gava.Game;

public class Main {
    public static void main(String[] args) {
        Game.getInstance().addScene(new defaultScene());
        Game.getInstance().setCurrentScene(0);
        Game.getInstance().start();
    }

}