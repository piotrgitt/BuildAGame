/*
 * Main class 
 */
package com.beginning.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class Game extends Canvas implements Runnable {

    private static final long serialVersionUID = 1550691097823471818L;
    public static final float WIDTH = 640.0f, HEIGHT = WIDTH / 12 * 9;
    
    private Thread thread;
    private boolean running = false;
    public int diff = 0;
    //diff = 0 -> NORMAL
    //diff = 1 -> HARD
    
    public GameState gameState = GameState.Menu;
    private final Random r = new Random();
    private final Handler handler;
    private Spawn spawner;
    public Menu menu;
    private Shop shop;
    private HUD hud;
    private Player player;
    public static boolean paused = false;
    public static BufferedImage sprite_sheet;
    
    //int averageFPS, sum, iterator = 0;
    
    /**
     * @link 
     */
    
    

    /**
     *
     * Constructor
     */
    public Game() {
        BufferedImageLoader loader = new BufferedImageLoader();
        try{
            sprite_sheet = loader.loadImage("sprite_sheet2.png");
            System.out.println("Loaded sprited_sheet image");
        }catch(Exception e){
            e.printStackTrace();
            System.err.println("- Cant load sprite-sheet image");
        }
        
        handler = new Handler();
        hud = new HUD();
        shop = new Shop(handler, hud, this);
        
        spawner = new Spawn(handler, hud, this);
        menu = new Menu(this, handler, hud, spawner);
        
        this.addKeyListener(new KeyInput(handler, this));    //it listen all the time our keyboard
        this.addMouseListener(menu);
        this.addMouseListener(shop);
        
        AudioPlayer.load();
        AudioPlayer.getMusic("music").loop();
        
        Window window = new Window(WIDTH, HEIGHT, "Lets build a game", this);
        
        
        //Player added in "PLAY BUTTON" from Menu class
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
     * Main game loop Uses two methods: tick(), render()
     */
    public void run() {
        this.requestFocus();//
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
            if (running) {
                render();  //render visual of game    
            }
            frames++;   //already frame should passed

            if (System.currentTimeMillis() - timer > 1000) {    //if one second has passed
                timer += 1000;
                System.out.println("FPS: " + frames);     //print how many frames have happend in the last second
                /** Average FPS of last 10 second
                if(iterator==30) {sum = 0; iterator = 0;}
                iterator++;
                sum += frames;
                averageFPS=sum/iterator;
                System.out.println("Average FPS: " + averageFPS);
                */
                frames = 0;   //reset the came count for the next second    
            }
        }
        stop();
    }

    private void tick() {
        
        if(gameState == GameState.Game){
            if(!paused){
                handler.tick();
                hud.tick();
                spawner.tick();
                
                /**
                 * DEATH MECHANISM
                 */
                if(HUD.HEALTH <= 0){
                    HUD.HEALTH = 100.0f;
                    
                    handler.removeAllEnemies();
                    handler.removePlayer();
                    //AudioPlayer.getMusic("in_game_music").stop();
                    AudioPlayer.getMusic("music").loop();
                    gameState = GameState.End; 

                }
            } 
        } else if(gameState == GameState.Menu || gameState == GameState.Help || gameState == GameState.End || gameState == GameState.Select){
            menu.tick();
            handler.tick();
        }
    }
    
    

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);   //explanation in older films RealTutsGML
            return;
        }
        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.black);    //set background color to Black
        g.fillRect(0, 0, (int)WIDTH, (int)HEIGHT);
        
        if(paused){
            g.drawString("PAUSE", 200, 200);
        }
        
        if(gameState == GameState.Game){
            hud.render(g);
            handler.render(g);
        }else if(gameState == GameState.Shop){
            shop.render(g);
        }else if(gameState == GameState.Menu || gameState == GameState.Help || gameState == GameState.End ||  gameState == GameState.Select){
            menu.render(g);
            handler.render(g);
        }
        g.dispose();
        bs.show();
    }

    /**
     *
     * Clamp for player, so he cannot go trough our frame window,
     */
    public static float clamp(float var, float min, float max) {
        if (var >= max) {
            return max;
        }
        if (var <= min) {
            return min;
        } else {
            return var;
        }
    }

    /**
     *
     * Starts the program
     */
    public static void main(String args[]) {
        new Game();
    }

    /**
     *
     * TIP:
     *
     * Tip: Add handler to the constructor of GameObject, and have it do
     * this.handler=handler; handler.addObject(this); That way you don't have to
     * add every object to the handler yourself with 
     * "handler.addObject(New Player(x,y,etc))",
     * instead you can just use "new Player(x,y,etc)" and it
     * will automatically add itself to the handler.﻿
     */
}
