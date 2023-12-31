import Gava.*;
import Gava.DefaultComponent.RigidBody;
import Gava.DefaultGameObjects.TextGameObject;
import Gava.DrawableComponents.DrawRectComponent;
import java.awt.*;
import Gava.Debug;

public class defaultCube extends GameObject {
    private double lastAngle = 0;
    TextGameObject text;
    private double totalTurns = 0;
    public defaultCube(Vector2D position){

        this.getModificationTransform().setPosition(position);

    }

    @Override
    public void start() {
        RigidBody rb = new RigidBody(this,10,0.5,false);
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
        //smoothMove();
        getDrawableComponent(DrawRectComponent.class).setColor(Color.black);
        if  (Input.isMouseClicked(1)){
            destroy();
        }
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
        text.setText(this.getName() + " Rot "+Math.round(totalTurns/3.1415));
        lastAngle = angle;


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
