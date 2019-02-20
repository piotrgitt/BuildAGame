/*
 * Main class 
 */
package com.beginning.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable {
    private static final long serialVersionUID = 1550691097823471818L;

    public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
    private Thread thread;
    private boolean running = false;
    private Handler handler;
    private Random r;
    
    /**
     * 
     * Constructor
     */
    public Game() {
        new Window(WIDTH, HEIGHT, "Lets build a game", this);
        handler = new Handler();    //instance of Handler class
        r=new Random();
        for(int i = 0; i< 55; i++){
            handler.addObject(new Player(0, 0, ID.Player));
        }
        
    }

    public synchronized void start() {
        thread = new Thread(this);  //'this' reffers for this instance of this game class
        thread.start();
        running = true;
    }

    public synchronized void stop() {
        try {
            thread.join();
            running = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Main game loop
     */
    public void run() {
        long lastTime = System.nanoTime();    //get current time to the nanoseconds
        double amountOfTicks = 60.0;    //set the number of ticks
        double ns = 1000000000 / amountOfTicks;    // determines how many times we can divide 60 into 10^9 nano seconds or about 1 second
        double delta = 0;    //change in time
        long timer = System.currentTimeMillis();    //get current time
        int frames = 0;    //set frrame variable
        while (running) {
            long now = System.nanoTime();    //get current time in nanoseconds during current loop
            delta += (now - lastTime) / ns;    //add the amount of change since the last loop
            lastTime = now;    //set last time to now - preparing for next loop iteration
            while (delta >= 1) {
                /**
                 * one tick of time has passed in the game this ensures that we
                 * have a steady pause in our game loop so we don't have a game
                 * that runs way too fast basically we are waiting for enough
                 * time to pass so we have about 60 frames per one second
                 * interval determined to the nanosecond (accuracy) once this
                 * pause is done we render the next frame
                 */
                tick();
                delta--;   //lower deltat back to 0 to start our next frame

            }
            if (running) 
            render();   //render visual of game
            frames++;   //already frame should passed
            if (System.currentTimeMillis() - timer > 1000) {    //if one second has passed
                timer += 1000;
                System.out.println("FPS: " + frames);     //print how many frames have happend in the last second
                frames = 0;   //reset the came count for the next second    
            }
        }
        stop();
    }

    private void tick() {
        handler.tick();
    }

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);   //explanation in older films RealTutsGML
            return;
        }

        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        
        handler.render(g);
        
        g.dispose();
        bs.show();
    }
    
    
    /**
     * 
     * Main function 
     */
    public static void main(String args[]) {
        new Game();
    }
}
