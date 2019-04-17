package com.beginning.main;


import com.beginning.main.GameState;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;


public class Menu extends MouseAdapter{
    private Game game;
    private Handler handler;
    private HUD hud;
    private int timer;
    private final Random r = new Random();
    MenuParticle menuParticles;
    
    
    /**
     * Menu constructor
     * 
     * @param hud 
     * @param game
     * @param handler 
     */
    public Menu(Game game, Handler handler, HUD hud){
        this.game = game;   
        this.handler = handler;
        this.hud = hud;
        for(int i=0; i<10 ; i++){
            handler.addObject(new MenuParticle((r.nextFloat()*(Game.WIDTH-16)), (r.nextFloat()*(Game.HEIGHT-16)) , ID.MenuParticle, handler));
        }
    }
    
    /**
     * Method describes what happen after clicking LPM in specific area of program
     * @param e
     */
    @Override
    public void mousePressed(MouseEvent e){
        int mouseX = e.getX();
        int mouseY = e.getY();
        
        //=====    MENU
        if(game.gameState == GameState.Menu){
            
            //PLAY BUTTON
            //START THE GAME
            if(mouseOver(mouseX, mouseY, 170, 80, 300, 90)){
                game.gameState = GameState.Game;
                handler.removeMenuParticles();
                handler.addObject(new Player(Game.WIDTH / 2 - 32, Game.HEIGHT / 2 - 32, ID.Player, handler));     //"WIDTH/2-32" - oznacza środek ekranu w rozdzielczości 640x480

                handler.addObject(new BasicEnemy((r.nextFloat()*(Game.WIDTH-16)), (r.nextFloat()*(Game.HEIGHT-16)) , ID.BasicEnemy, handler));               
            }

            //HELP BUTTON
            if(mouseOver(mouseX, mouseY, 170, 200, 300, 90)){ 
                game.gameState = GameState.Help;
            }

            //QUIT BUTTON
            if(mouseOver(mouseX, mouseY, 170, 320, 300, 90)){
                System.exit(0);
            }
        }
        
        
        //=====   HELP MENU or END SCREEN
        //BACK BUTTON
        if(game.gameState == GameState.Help){
            if(mouseOver(mouseX, mouseY, 50, 380, 200, 60)){
                game.gameState = GameState.Menu;
            }
        }
        
        //END BUTTON
        if(game.gameState == GameState.End){
            if(mouseOver(mouseX, mouseY, 50, 380, 200, 60)){
                hud.setScore(0);
                hud.setLevel(1);
                game.gameState = GameState.Game;
                handler.removeMenuParticles();
                handler.addObject(new Player(Game.WIDTH / 2 - 32, Game.HEIGHT / 2 - 32, ID.Player, handler));     //"WIDTH/2-32" - oznacza środek ekranu w rozdzielczości 640x480

                handler.addObject(new BasicEnemy((r.nextFloat()*(Game.WIDTH-16)), (r.nextFloat()*(Game.HEIGHT-16)) , ID.BasicEnemy, handler));     
            }
        }
        
        
    }
    
    /**
     * 
     * 
     * @param mouseX
     * @param mouseY
     * @param x
     * @param y
     * @param width
     * @param height
     * @return 
     */
    private boolean mouseOver(int mouseX, int mouseY, int x, int y, int width, int height){
        if(mouseX > x && mouseX < x+width ){
            if(mouseY > y & mouseY < y+height){
                return true;
            }else return false;
        }else return false;
    }
    
    public void mouseReleased(MouseEvent e){
    
    }
    
    
    public void render(Graphics g){
        
        //MENU SYSTEM
        if(game.gameState == GameState.Menu){
            Font font1 = new Font("arial", 11, 34);
            g.setFont(font1);

            g.setColor(Color.WHITE);
            g.drawRoundRect(170, 80, 300, 90,10, 10);
            g.drawString("PLAY", 270, 140);

            g.drawRoundRect(170, 200, 300, 90,10, 10);
            g.drawString("HELP", 270, 140+120);

            g.drawRoundRect(170, 320, 300, 90,10, 10);
            g.drawString("QUIT", 270, 140+240); 
        }
        
        //HELP STATE
        if(game.gameState == GameState.Help){
            Font font1 = new Font("arial", 11, 34);
            Font font2 = new Font("arial", 11, 16);
            g.setFont(font1);

            g.setColor(Color.WHITE);
            g.drawString("HELP", 270, 140);
            g.drawRoundRect(50, 380, 200, 60,10, 10);
            g.drawString("BACK", 100, 422);
            
            g.setFont(font2);
            g.drawString("Use 'arrows' to move around and avoid enemies!", 100, 250);
        }
        
        if(game.gameState == GameState.End){
            Font font1 = new Font("arial", 10, 34);
            Font font2 = new Font("arial", 10, 25);
            Font font3 = new Font("hack", 3, 18);
            
            g.setFont(font1);
            g.setColor(Color.WHITE);
            
            //GAME OVER STRING
            g.drawString("GAME OVER", 215, 140); 
            
            //PLAY AGAIN button
            g.setFont(font2);
            g.drawRoundRect(50, 380, 200, 60,10, 10);
            g.drawString("PLAY AGAIN", 76, 419);
            
            //TEXTs
            g.setFont(font3);
            g.drawString("You lose with score of: "+hud.getScore(), 50, 250);
        }
    }
    
    
    public void tick(){

        
    }
    
    
}
