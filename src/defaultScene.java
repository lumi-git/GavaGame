import Gava.*;
import Gava.DefaultGameObjects.LineObject;
import Gava.DefaultGameObjects.VoidGameObject;
import java.awt.*;
import java.awt.event.KeyEvent;

public class defaultScene extends Scene {
    @Override
    public void start() {
        Game.getInstance().getFrame().setBackground(Color.red);
        int rows = 1;
        int cols = 1;
        int spaces = 2000;
        int offsetx = Game.getInstance().getWidth() / 3;
        int offsety = Game.getInstance().getHeight() / 3;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++){
                Vector2D pos = new Vector2D(Gava.utility.MathUtils.randint(offsetx,offsetx+spaces),Gava.utility.MathUtils.randint(offsety,offsety+spaces));
                defaultCube dc = new defaultCube(pos);

                Game.Instantiate(dc);
            }
        }
        player p = new player();
        Game.Instantiate(new LineObject(p,new VoidGameObject()));
        Game.Instantiate(p);

    }

    @Override
    public void update(double dt) {
        if (Input.isMouseClicked(3)){
            Game.Instantiate(new defaultCube(Input.getMousePosition()));
        }
        if (Input.isKeyPressed(KeyEvent.VK_X)){
            Game.Instantiate(new defaultCubeMooving(Input.getMousePosition()));
        }

    }


}
