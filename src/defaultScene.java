import Gava.Game;
import Gava.Input;
import Gava.Scene;
import Gava.Vector2D;

public class defaultScene extends Scene {

    @Override
    public void start() {
        int rows = 1;
        int cols = 1;
        int spaces = 2;
        int offsetx = Game.getInstance().getWidth() / 3;
        int offsety = Game.getInstance().getHeight() / 3;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++){
                Vector2D pos = new Vector2D((i * spaces) + offsetx, (j * spaces) + offsety);
                Game.Instantiate(new defaultCube(pos));
            }
        }
    }

    @Override
    public void update(double dt) {
        if (Input.isMousePressed(1)){
            Game.Instantiate(new defaultCube(Input.getMousePosition()));
        }
    }


}
