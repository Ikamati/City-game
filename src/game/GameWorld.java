package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class GameWorld extends World {
    private Student player;

    public GameWorld() {
        super();

        // Make the ground
        Shape groundShape = new BoxShape(11, 0.5f);
        StaticBody ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(0f, -11.5f));

        // Make the character
        player = new Student(this);
        player.setPosition(new Vec2(7, -9));

        // Add some platforms
        for (int i = 0; i < 5; i++) {
            Shape platformShape = new BoxShape(2, 0.2f);
            StaticBody platform = new StaticBody(this, platformShape);
            platform.setPosition(new Vec2(i * 4 - 8, -5 + i * 2));
        }

        // Add enemies and collectibles
        for (int i = 0; i < 3; i++) {
            Enemy enemy = new Enemy(this);
            enemy.setPosition(new Vec2(i * 5 - 5, 0));

            Collectible collectible = new Collectible(this);
            collectible.setPosition(new Vec2(i * 5 - 5, 5));
        }

    }
}
