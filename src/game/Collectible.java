// Collectible.java
package game;

import city.cs.engine.*;

public class Collectible extends Walker {
    private static final Shape collectibleShape = new PolygonShape(
            -0.25f, 0.25f, 0.25f, 0.25f, 0.25f, -0.25f, -0.25f, -0.25f);

    private static final BodyImage collectibleImage =
            new BodyImage("data/coin.jpeg", 0.5f); // Adjust the image path and scale

    public Collectible(World world) {
        super(world, collectibleShape);
        addImage(collectibleImage);
        setGravityScale(0); // Optional: Adjust the gravity scale if needed
    }
}
