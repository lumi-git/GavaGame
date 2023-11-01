import Gava.*;
import Gava.DefaultComponent.RigidBody;
import Gava.DefaultGameObjects.TextGameObject;
import Gava.DrawableComponents.DrawRectComponent;

import java.awt.*;

public class defaultCubeMooving extends GameObject {
    private double lastAngle = 0;
    TextGameObject text;
    private double totalTurns = 0;
    public defaultCubeMooving(Vector2D position){

        this.getModificationTransform().setPosition(position);
    }

    @Override
    public void start() {
        RigidBody rb = new RigidBody(this,Float.POSITIVE_INFINITY,0,false);
        addComponent(rb);
        this.addDrawableComponent(new DrawRectComponent(Color.red,this));
        //this.addDrawableComponent(new DrawSpriteComponent("Logo.png",this));
        this.getModificationTransform().setScale(new Vector2D(Gava.utility.MathUtils.randint(101,101),Gava.utility.MathUtils.randint(101,101)));
        //SoundPlayer.playSound("src/Assets/sounds/jump.wav");
        text = new TextGameObject();
        text.setColor(Color.orange);
        addChild(text);
        Game.Instantiate(text);
    }
    @Override
    public void update(double dt) {
        text.setText(this.getName());
        getModificationTransform().setPosition(Input.getMousePosition());
        getDrawableComponent(DrawRectComponent.class).setColor(Color.black);
        if  (Input.isMouseClicked(1)){
            destroy();
        }
    }



    @Override
    public void end() {
    }

    @Override
    public void onCollisionStay(CollisionInformation info) {
        getDrawableComponent(DrawRectComponent.class).setColor(Color.green);
        //if (Objects.equals(other.getName(), "player")){
        //    player p = (player) other;
        //    p.addPoint(1);
        //    destroy();
        //}

    }
}
