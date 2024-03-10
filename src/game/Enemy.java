// Enemy.java
package game;

import city.cs.engine.*;

public class Enemy extends Walker {
    private static final Shape enemyShape = new PolygonShape(
            -0.46f, 0.49f, 0.46f, 0.49f, 0.0f, -0.49f);

    private static final BodyImage enemyImage =
            new BodyImage("data/enemy.png", 1.0f); // Adjust the image path

    public Enemy(World world) {
        super(world, enemyShape);
        addImage(enemyImage);
        setGravityScale(0); // Optional: Adjust the gravity scale if needed
    }
}
