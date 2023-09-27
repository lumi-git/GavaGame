import Gava.Debug;
import Gava.Game;
import Gava.Scene;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Game g = Game.getInstance();
        Debug.setDebugOpt("fps",true);
        Debug.setDebugOpt("GameObjects",true);

        Debug.log("add scene");
        Scene s = new defaultScene();
        s.setMainScene();
        g.addScene(s);

        Debug.log("init image library");
        g.initImageLibrary("src/Assets/img");
        g.setTitle("Demo game Gava");
        g.setFps(120);


        g.start();
    }

}