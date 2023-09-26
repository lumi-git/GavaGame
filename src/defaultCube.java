import Gava.DrawRectComponent;
import Gava.Game;
import Gava.GameObject;

import java.awt.*;
import java.awt.event.KeyEvent;

public class defaultCube extends GameObject {
    @Override
    public void start() {
        this.addDrawableComponent(new DrawRectComponent(100, 100, Color.red,this));
    }
    @Override
    public void update(double dt) {
        getTransform().getPosition().x +=1*Math.random();
        getTransform().getPosition().y +=1;
        Boolean destroy = Game.getInstance().getKeyListener().isKeyPressed(KeyEvent.VK_E);

        if(destroy){
            this.destroy();
        }

    }

}
