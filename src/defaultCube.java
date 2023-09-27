import Gava.DrawableComponents.DrawRectComponent;
import Gava.Game;
import Gava.GameObject;
import Gava.Vector2D;
import Gava.Input;
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

        smoothMove();
    }

    private void preciseMove(){
        Vector2D mousePos = Input.getMousePosition();
        getTransform().setPosition(mousePos);
    }

    private void smoothMove(){
        Vector2D mousePos = Input.getMousePosition();
        Vector2D direction = mousePos.subtract(getTransform().getPosition()).normalize();


        if (Input.isMousePressed(1) ){
            getTransform().Move(direction,speed);
        }

        if(Input.isKeyPressed(KeyEvent.VK_Z)){

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

}
