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
    private Spawn spawn;
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
    public Menu(Game game, Handler handler, HUD hud, Spawn spawn){
        this.game = game;   
        this.handler = handler;
        this.hud = hud;
        this.spawn = spawn;
        AudioPlayer.load();
        for(int i=0; i<10 ; i++){
            handler.addObject(new MenuParticle((r.nextFloat()*(Game.WIDTH-16)), (r.nextFloat()*(Game.HEIGHT-16)) , ID.MenuParticle, handler));
        }
    }
    
    /**
     * Method describes what happen after clicking LPM in specific area of program
     * Method 
     * @param e
     */
    public void mousePressed(MouseEvent e){
        int mouseX = e.getX();
        int mouseY = e.getY();
        
        //=====    MENU
        if(game.gameState == GameState.Menu){
            //PLAY BUTTON
            if(mouseOver(mouseX, mouseY, 170, 80, 300, 90)){
                game.gameState = GameState.Select;
                AudioPlayer.getSound("click_sound").play();
                return;
            }

            //HELP BUTTON
            if(mouseOver(mouseX, mouseY, 170, 200, 300, 90)){ 
                game.gameState = GameState.Help;
                AudioPlayer.getSound("click_sound").play();
                return;
            }

            //QUIT BUTTON
            if(mouseOver(mouseX, mouseY, 170, 320, 300, 90)){
                AudioPlayer.getSound("click_sound").play();
                System.exit(0);      
            }
        }
        
        
        
        //==========  HELP MENU ========
        if(game.gameState == GameState.Help){
            //BACK BUTTON
            if(mouseOver(mouseX, mouseY, 50, 380, 200, 60)){
                game.gameState = GameState.Menu;
                AudioPlayer.getSound("click_sound").play();
                return;
            }
        }
        
        
        //========= END SCREEN =========
        if(game.gameState == GameState.End){
            //PLAY AGAIN BUTTON
            if(mouseOver(mouseX, mouseY, 50, 380, 200, 60)){
                hud.setScore(0);
                spawn.setScoreKeep(0);
                hud.setLevel(1);
                game.gameState = GameState.Game;
                handler.removeMenuParticles();
                handler.addObject(new Player(Game.WIDTH / 2 - 32, Game.HEIGHT / 2 - 32, ID.Player, handler));     //"WIDTH/2-32" - oznacza środek ekranu w rozdzielczości 640x480
                if(game.diff == 0){
                    handler.addObject(new BasicEnemy((r.nextFloat()*(Game.WIDTH-16)), (r.nextFloat()*(Game.HEIGHT-16)) , ID.BasicEnemy, handler));
                } else handler.addObject(new SmartEnemy((r.nextFloat()*(Game.WIDTH-16)), (r.nextFloat()*(Game.HEIGHT-16)) , ID.SmartEnemy, handler));
                
                AudioPlayer.getMusic("music").stop();
                AudioPlayer.getMusic("in_game_music").loop(); 
                AudioPlayer.getSound("click_sound").play();
            }
            
            //MENU BUTTON
            if(mouseOver(mouseX, mouseY, 220, 280, 200, 60)){
                hud.setScore(0);
                spawn.setScoreKeep(0);
                hud.setLevel(1);
                game.gameState = GameState.Menu;
                AudioPlayer.getSound("click_sound").play();
            }
            
            //QUIT BUTTON
            if(mouseOver(mouseX, mouseY, 400, 380, 200, 60)){
                System.exit(0);
            }     
        }
        
        //========= SELECT DIFFICULTY ===========
        if(game.gameState == GameState.Select){
            //NORMAL BUTTON
            if(mouseOver(mouseX, mouseY, 170, 80, 300, 90)){
                game.diff = 0;
                game.gameState = GameState.Game;
                handler.removeMenuParticles();
                handler.addObject(new Player(Game.WIDTH / 2 - 32, Game.HEIGHT / 2 - 32, ID.Player, handler));     //"WIDTH/2-32" - oznacza środek ekranu w rozdzielczości 640x480
                handler.addObject(new BasicEnemy((r.nextFloat()*(Game.WIDTH-16)), (r.nextFloat()*(Game.HEIGHT-16)) , ID.BasicEnemy, handler));               
                AudioPlayer.getMusic("music").stop();
                AudioPlayer.getMusic("in_game_music").loop();
                AudioPlayer.getSound("click_sound").play();
                return;
            }

            //HARD BUTON
            if(mouseOver(mouseX, mouseY, 170, 200, 300, 90)){ 
                game.diff = 1;
                game.gameState = GameState.Game;
                handler.removeMenuParticles();
                handler.addObject(new Player(Game.WIDTH / 2 - 32, Game.HEIGHT / 2 - 32, ID.Player, handler));     //"WIDTH/2-32" - oznacza środek ekranu w rozdzielczości 640x480
                handler.addObject(new SmartEnemy((r.nextFloat()*(Game.WIDTH-16)), (r.nextFloat()*(Game.HEIGHT-16)) , ID.SmartEnemy, handler));               
                AudioPlayer.getMusic("music").stop();
                AudioPlayer.getMusic("in_game_music").loop();
                AudioPlayer.getSound("click_sound").play();
                return;
            }

            //BACK BUTTON
            if(mouseOver(mouseX, mouseY, 170, 320, 300, 90)){
                game.gameState = GameState.Menu;
                AudioPlayer.getSound("click_sound").play(); 
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
            g.drawString("- Use 'arrows' to move around and avoid enemies,", 100, 250);
            g.drawString("- Press P for Pause,", 100, 270);
            g.drawString("- Press SPACE to enter shop.", 100, 290);
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
            
            //MENU BUTTON
            g.setFont(font2);
            g.drawRoundRect(220, 280, 200, 60,10, 10);
            g.drawString("MENU", 280, 318);
            
            //QUIT button
            g.setFont(font2);
            g.drawRoundRect(400, 380, 200, 60,10, 10);
            g.drawString("QUIT", 474, 419);
            
            //YOU LOSE WITH SCORE text
            g.setFont(font3);
            g.drawString("You lose with score of: "+hud.getScore(), 50, 250);
        }
        
        //SELECT DIFFICULTY
        if(game.gameState == GameState.Select){
            Font font1 = new Font("arial", 11, 34);
            g.setFont(font1);
            
            g.setColor(Color.WHITE);
            g.drawString("Select difficulty", 210, 40);
            g.drawRoundRect(170, 80, 300, 90,10, 10);
            g.drawString("NORMAL", 255, 140);

            g.drawRoundRect(170, 200, 300, 90,10, 10);
            g.drawString("HARD", 270, 140+120);

            g.drawRoundRect(170, 320, 300, 90,10, 10);
            g.drawString("BACK", 270, 140+240); 
        }
        
    }
    
    
    public void tick(){
    }
    
    
}
