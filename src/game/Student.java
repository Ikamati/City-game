package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import java.awt.event.KeyEvent;

public class Student extends Walker {

    private static final Shape studentShape = new PolygonShape(
            -0.5f, 1.5f, 0.5f, 1.5f, 0.5f, -1.5f, -0.5f, -1.5f);

    private static final BodyImage studentImage =
            new BodyImage("data/student.png", 3.0f);

    private static final float JUMP_FORCE = 15.0f; // Adjust jump force as needed

    private boolean leftKeyPressed;
    private boolean rightKeyPressed;

    public Student(World world) {
        super(world, studentShape);
        addImage(studentImage);
    }

    // Getter methods for key states
    public boolean isLeftKeyPressed() {
        return leftKeyPressed;
    }

    public boolean isRightKeyPressed() {
        return rightKeyPressed;
    }

    // Setter methods for key states
    public void setLeftKeyPressed(boolean leftKeyPressed) {
        this.leftKeyPressed = leftKeyPressed;
    }

    public void setRightKeyPressed(boolean rightKeyPressed) {
        this.rightKeyPressed = rightKeyPressed;
    }

    public void jump() {
        if (this.getLinearVelocity().y < 0.01f && this.getLinearVelocity().y > -0.01f) {
            Vec2 jumpForce = new Vec2(0, JUMP_FORCE);
            this.applyImpulse(jumpForce, this.getPosition());
        }
    }
}
