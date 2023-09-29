import Gava.*;
import Gava.DefaultGameObjects.CameraObject;
import Gava.DefaultGameObjects.Light;
import Gava.DrawableComponents.LightComponent;

import java.awt.*;

public class defaultScene extends Scene {


    @Override
    public void start() {
        Debug.log("start the main scene");
        Light lt = new Light(255,400,Color.red);
        Game.getInstance().getFrame().setBackground(Color.red);
        int rows = 0;
        int cols = 0;
        int spaces = 2;
        int offsetx = Game.getInstance().getWidth() / 3;
        int offsety = Game.getInstance().getHeight() / 3;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++){
                Vector2D pos = new Vector2D(Math.random()*Game.getInstance().getWidth(),Math.random()*Game.getInstance().getHeight());
                defaultCube dc = new defaultCube(pos);

                Game.Instantiate(dc);
            }
        }


        player p = new player();
        Game.Instantiate(p);
        Game.Instantiate(lt);



    }

    @Override
    public void update(double dt) {
        if (Input.isMouseClicked(1)){
            Game.Instantiate(new defaultCube(Input.getMousePosition()));
        }

    }


}
