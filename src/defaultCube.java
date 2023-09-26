import Gava.DrawRectComponent;
import Gava.Game;
import Gava.GameObject;
import Gava.Vector2D;

import java.awt.*;
import java.awt.event.KeyEvent;

public class defaultCube extends GameObject {
    double speed = 2;

    public defaultCube(int x, int y){

        this.getTransform().setPosition(new Vector2D(x,y));
    }

    @Override
    public void start() {
        this.addDrawableComponent(new DrawRectComponent(Color.red,this));
        this.getTransform().setScale(new Vector2D(100,100));
    }
    @Override
    public void update(double dt) {
        if(Game.getInstance().getKeyListener().isKeyPressed(KeyEvent.VK_A)){
            getTransform().setRotation(getTransform().getRotation()-0.01);
        }
        if(Game.getInstance().getKeyListener().isKeyPressed(KeyEvent.VK_E)){
            getTransform().setRotation(getTransform().getRotation()+0.01);
        }

        if(Game.getInstance().getKeyListener().isKeyPressed(KeyEvent.VK_Z)){
            getTransform().getPosition().y -=speed;
        }
        if(Game.getInstance().getKeyListener().isKeyPressed(KeyEvent.VK_S)){
            getTransform().getPosition().y +=speed;
        }
        if(Game.getInstance().getKeyListener().isKeyPressed(KeyEvent.VK_Q)){
            getTransform().getPosition().x -=speed;
        }
        if(Game.getInstance().getKeyListener().isKeyPressed(KeyEvent.VK_D)){
            getTransform().getPosition().x +=speed;
        }

    }

}
