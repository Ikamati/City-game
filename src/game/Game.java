package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game {

    private static final int FRAME_WIDTH = 500;
    private static final int FRAME_HEIGHT = 500;

    public Game() {
        // Create a new game world
        GameWorld world = new GameWorld();

        // Create a ground platform
        Shape groundShape = new BoxShape(15, 0.5f);
        new StaticBody(world, groundShape).setPosition(new Vec2(0, -10));

        // Create the player character
        Student student = new Student(world);
        student.setPosition(new Vec2(0, -8));

        // Create a view for the game world
        GameView view = new GameView(world, FRAME_WIDTH, FRAME_HEIGHT);

        // Create a JFrame and add the game view to it
        JFrame frame = new JFrame("City Game");
        frame.add(view);

        // Configure the JFrame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);

        // Add keyboard control for the player
        frame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                // Unused
            }

            @Override
            public void keyPressed(KeyEvent e) {
                handleKeyPress(e.getKeyCode(), student);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                handleKeyRelease(e.getKeyCode(), student);
            }
        });

        // Start the game world simulation
        world.start();
    }

    private void handleKeyPress(int keyCode, Student player) {
        switch (keyCode) {
            case KeyEvent.VK_SPACE:
                player.jump();
                break;
            case KeyEvent.VK_LEFT:
                player.startWalking(-5);
                break;
            case KeyEvent.VK_RIGHT:
                player.startWalking(5);
                break;
            // Add more key press cases as needed
        }
    }

    private void handleKeyRelease(int keyCode, Student player) {
        switch (keyCode) {
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_RIGHT:
                player.stopWalking();
                break;
            // Add more key release cases as needed
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Game());
    }
}
