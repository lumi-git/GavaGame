import Gava.Debug;
import Gava.Game;
public class Main {
    public static void main(String[] args) {
        Game g = Game.getInstance();
        Debug.setDebugOpt("fps",true);
        Debug.setDebugOpt("GameObjects",true);

        Debug.log("add scene");
        g.addScene(new defaultScene());

        Debug.log("set current scene");
        g.setCurrentScene(0);

        Debug.log("init image library");
        g.initImageLibrary("src/Assets/img");
        g.setTitle("black bars");
        g.setFps(120);

        g.start();

    }

}