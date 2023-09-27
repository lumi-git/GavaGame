import Gava.Game;
import Gava.Scene;

public class defaultScene extends Scene {

    @Override
    public void update(double dt) {
    }

    @Override
    public void start() {
        for (int i = 0; i < 1000; i++) {
            Game.Instantiate(new defaultCube( (int)(Game.getInstance().getSize().width *  Math.random()),(int)(Game.getInstance().getSize().height *  Math.random())));
        }
    }
}
