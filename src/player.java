import Gava.Debug;
import Gava.DefaultGameObjects.CameraObject;
import Gava.DefaultGameObjects.TextGameObject;
import Gava.DrawableComponents.DrawRectComponent;
import Gava.Game;
import Gava.GameObject;
import Gava.Input;

import java.awt.*;
import java.awt.event.KeyEvent;

public class player extends Gava.GameObject{
    double speed = 5;
    int points=0;
    TextGameObject text = new TextGameObject();
    public player(){
        this.getModificationTransform().setScale(new Gava.Vector2D(50,50));
    }

    @Override
    public void start() {
        setName("player");

        addChild(Game.Instantiate(text));
        addComponent(new Gava.DefaultComponent.PlayerBody(this,speed));
        CameraObject cam = (CameraObject) Game.Instantiate(new CameraObject());
        addChild(cam);
        this.addDrawableComponent(new DrawRectComponent(Color.green,this));
    }

    @Override
    public void onCollisionStay(GameObject other) {
        getDrawableComponent(DrawRectComponent.class).setColor(Color.blue);
    }

    @Override
    public void update(double dt){
        text.setText("Points : "+points);
        getDrawableComponent(DrawRectComponent.class).setColor(Color.green);
        getModificationTransform().setRotation(getModificationTransform().getRotation()+0.1);
    }

    public void addPoint(int i){
        this.points+=i;
    }

}
