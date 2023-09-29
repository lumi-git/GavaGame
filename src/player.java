import Gava.DefaultGameObjects.CameraObject;
import Gava.DefaultGameObjects.Light;
import Gava.DrawableComponents.DrawRectComponent;
import Gava.Game;
import Gava.Input;

import java.awt.*;
import java.awt.event.KeyEvent;

public class player extends Gava.GameObject{
    double speed = 2;

    public player(){
        this.getModificationTransform().setScale(new Gava.Vector2D(50,50));
    }

    @Override
    public void start() {
        CameraObject cam = (CameraObject) Game.Instantiate(new CameraObject());
        addChild(cam);
        this.addDrawableComponent(new DrawRectComponent(Color.red,this));

        this.addChild(Game.Instantiate(new Light(255,200,Color.red)));
    }

    @Override
    public void update(double dt) {
        if(Input.isKeyPressed(KeyEvent.VK_Z)){
            getModificationTransform().getPosition().y -=speed;
        }
        if(Input.isKeyPressed(KeyEvent.VK_S)){
            getModificationTransform().getPosition().y +=speed;
        }
        if(Input.isKeyPressed(KeyEvent.VK_Q)){
            getModificationTransform().getPosition().x -=speed;
        }
        if(Input.isKeyPressed(KeyEvent.VK_D)){
            getModificationTransform().getPosition().x +=speed;
        }
    }
}
