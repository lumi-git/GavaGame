import Gava.*;
import Gava.DefaultComponent.KinematicComponent;

import Gava.DefaultGameObjects.CameraObject;
import Gava.DefaultGameObjects.Light;
import Gava.DefaultGameObjects.TextGameObject;
import Gava.DrawableComponents.DrawRectComponent;
import Gava.DrawableComponents.DrawSpriteComponent;
import Gava.DrawableComponents.LightComponent;

import java.awt.*;
import java.awt.event.KeyEvent;

public class defaultCube extends GameObject {
    private double lastAngle = 0;
    TextGameObject text;
    private double totalTurns = 0;
    public defaultCube(Vector2D position){

        this.getModificationTransform().setPosition(position);
    }

    @Override
    public void start() {
        this.addDrawableComponent(new DrawRectComponent(Color.red,this));
        this.addDrawableComponent(new DrawSpriteComponent("Logo.png",this));
        KinematicComponent kc = new KinematicComponent(this);
        kc.UseGravity(true);
        //this.addComponent(kc);
        this.getModificationTransform().setScale(new Vector2D(100,100));
        //SoundPlayer.playSound("src/Assets/sounds/jump.wav");

        // probleme avec les start des objets, ici le parent de la light n'est pas encore instancié quand on appele start de la light, pas bien
        // surement besoin de faire un start global pour tous les objets en prenant en compte les relations parents
        addChild(Game.Instantiate(new Light(255,500,Color.red)));

        text = new TextGameObject();
        addChild(text);
        Game.Instantiate(text);
    }
    @Override
    public void update(double dt) {
        smoothMove();
        getDrawableComponent(DrawRectComponent.class).setColor(Color.black);
    }

    private void preciseMove(){
        Vector2D mousePos = Input.getMousePosition();
        getModificationTransform().setPosition(mousePos);
    }

    private void smoothMove(){
        Vector2D mousePos = Input.getMousePosition();
        Vector2D direction = mousePos.subtract(getReadonlyTransform().getCenteredPosition());
        if(direction.y == 0)
            direction.y=0.00000001;
        if (direction.x == 0)
            direction.x=0.00000001;
        double angle = Math.atan(direction.y/direction.x);
        getModificationTransform().setRotation(angle);
        totalTurns += Math.abs(angle-lastAngle);
        text.setText("Rot "+Math.round(totalTurns/3.1415));
        lastAngle = angle;
        if  (Input.isMousePressed(3)){
            destroy();
        }
    }

    @Override
    public void end() {
        Debug.log("destroyed");
    }
}
