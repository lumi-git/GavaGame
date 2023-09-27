import Gava.*;
import Gava.DrawableComponents.DrawCircleComponent;
import Gava.DrawableComponents.DrawRectComponent;
import Gava.DrawableComponents.DrawTextComponent;

import java.awt.*;
import java.awt.event.KeyEvent;

public class defaultCube extends GameObject {
    double speed = 2;

    public defaultCube(Vector2D position){

        this.getTransform().setPosition(position);
    }

    @Override
    public void start() {
        this.addDrawableComponent(new DrawRectComponent(Color.red,this));
        this.getTransform().setScale(new Vector2D(100,10));
    }
    @Override
    public void update(double dt) {

        smoothMove();
        getDrawableComponent(DrawRectComponent.class).setColor(Color.black);

    }

    private void preciseMove(){
        Vector2D mousePos = Input.getMousePosition();
        getTransform().setPosition(mousePos);
    }

    private void smoothMove(){
        Vector2D mousePos = Input.getMousePosition();
        Vector2D direction = mousePos.subtract(getTransform().getCenteredPosition());

        if(direction.y == 0)
            direction.y=0.00000001;

        if (direction.x == 0)
            direction.x=0.00000001;

        getTransform().setRotation( Math.atan2(direction.y,direction.x));


        if  (Input.isMousePressed(3)){
            destroy();
        }

        if(Input.isKeyPressed(KeyEvent.VK_Z)){
            getTransform().getPosition().y -=speed;
        }
        if(Input.isKeyPressed(KeyEvent.VK_S)){
            getTransform().getPosition().y +=speed;
        }
        if(Input.isKeyPressed(KeyEvent.VK_Q)){
            getTransform().getPosition().x -=speed;
        }
        if(Input.isKeyPressed(KeyEvent.VK_D)){
            getTransform().getPosition().x +=speed;
        }
    }

    @Override
    public void end() {
        Debug.log("destroyed");
    }
}
