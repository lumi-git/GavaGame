import Gava.Game;
import Gava.Debug;
public class Main {
    public static void main(String[] args) {
        Game.getInstance().setSize(800,600);
        Game.getInstance().addScene(new defaultScene());

        Debug.setDebugOpt("fps",true);
        Debug.setDebugOpt("GameObjects",true);
        Game.getInstance().initImageLibrary("src/Assets");
        Game.getInstance().setCurrentScene(0);

        Game.getInstance().setTitle("black bars");
        Game.getInstance().setFps(120);


        Game.getInstance().start();

    }

}