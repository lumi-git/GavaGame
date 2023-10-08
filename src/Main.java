import Gava.Debug;
import Gava.Game;
import Gava.Scene;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Game g = Game.getInstance();
        Debug.setDebugOpt("fps",true);
        Debug.setDebugOpt("GameObjects",true);
        //Debug.setDebugOpt("collisionLayer",true);


        Scene s = new defaultScene();
        s.setMainScene();
        g.addScene(s);


        //g.initImageLibrary("src/Assets/img");
        g.setTitle("Demo game Gava");
        g.setFps(120);


        g.start();
    }

}