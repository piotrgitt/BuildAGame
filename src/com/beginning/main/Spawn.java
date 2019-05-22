package com.beginning.main;

import java.util.Random;

public class Spawn {

    private final Random r = new Random();
    private Game game;
    public Handler handler;
    private HUD hud;
    private Player player;
    private int scoreKeep = 0;

    public Spawn(Handler handler, HUD hud, Game game) {
        this.handler = handler;
        this.hud = hud;
        this.game = game;
    }

    public void tick() {
        scoreKeep++;

        if (scoreKeep >= 250) {
            scoreKeep = 0;
            hud.setLevel(hud.getLevel() + 1);
            
            if(game.diff == 0){
                switch (hud.getLevel()) {
                    case 2: 
                        //WHEN LV 2 is begin
                        //-16 so object doesnt appear partly behind frame and block himself
                        handler.addObject(new BasicEnemy((r.nextFloat()*(Game.WIDTH-16)), (r.nextFloat()*(Game.HEIGHT-16)) , ID.BasicEnemy, handler));  
                        break;
                    case 3:
                        handler.addObject(new BasicEnemy((r.nextFloat()*(Game.WIDTH-16)), (r.nextFloat()*(Game.HEIGHT-16)) , ID.BasicEnemy, handler));                 
                        break;
                    case 4:
                        handler.addObject(new FastEnemy((r.nextFloat()*(Game.WIDTH-16)), (r.nextFloat()*(Game.HEIGHT-16)) , ID.FastEnemy, handler));                 
                        break;
                    case 5:
                        handler.addObject(new FastEnemy((r.nextFloat()*(Game.WIDTH-16)), (r.nextFloat()*(Game.HEIGHT-16)) , ID.FastEnemy, handler));                 
                        break;
                    case 6:
                        handler.addObject(new BasicEnemy((r.nextFloat()*(Game.WIDTH-16)), (r.nextFloat()*(Game.HEIGHT-16)) , ID.BasicEnemy, handler)); 
                        break;
                    case 7:
                        handler.addObject(new SmartEnemy((r.nextFloat()*(Game.WIDTH-16)), (r.nextFloat()*(Game.HEIGHT-16)) , ID.SmartEnemy, handler));
                        break;
                    case 8:
                        handler.addObject(new SmartEnemy((r.nextFloat()*(Game.WIDTH-16)), (r.nextFloat()*(Game.HEIGHT-16)) , ID.SmartEnemy, handler)); 
                        break;
                    case 9:
                        handler.addObject(new SmartEnemy((r.nextFloat()*(Game.WIDTH-16)), (r.nextFloat()*(Game.HEIGHT-16)) , ID.SmartEnemy, handler)); 
                        break;
                    case 10:
                        handler.removeAllEnemies();
                        handler.addObject(new BossEnemy(Game.WIDTH/2 - 40, -106 , ID.BossEnemy, handler,5));  
                        break;
                    default:
                        break;
                }           
            } else {
                switch (hud.getLevel()) {
                    case 2: 
                        //WHEN LV 2 is begin
                        //-16 so object doesnt appear partly behind frame and block himself
                        handler.addObject(new HardEnemy((r.nextFloat()*(Game.WIDTH-16)), (r.nextFloat()*(Game.HEIGHT-16)) , ID.HardEnemy, handler));  
                        break;
                    case 3:
                        handler.addObject(new HardEnemy((r.nextFloat()*(Game.WIDTH-16)), (r.nextFloat()*(Game.HEIGHT-16)) , ID.HardEnemy, handler));  
                        break;
                    case 4:
                        handler.addObject(new FastEnemy((r.nextFloat()*(Game.WIDTH-16)), (r.nextFloat()*(Game.HEIGHT-16)) , ID.FastEnemy, handler));                 
                        break;
                    case 5:
                        handler.addObject(new FastEnemy((r.nextFloat()*(Game.WIDTH-16)), (r.nextFloat()*(Game.HEIGHT-16)) , ID.FastEnemy, handler));                 
                        break;
                    case 6:
                        handler.addObject(new HardEnemy((r.nextFloat()*(Game.WIDTH-16)), (r.nextFloat()*(Game.HEIGHT-16)) , ID.HardEnemy, handler));  
                        break;
                    case 7:
                        handler.addObject(new SmartEnemy((r.nextFloat()*(Game.WIDTH-16)), (r.nextFloat()*(Game.HEIGHT-16)) , ID.SmartEnemy, handler));
                        break;
                    case 8:
                        handler.addObject(new SmartEnemy((r.nextFloat()*(Game.WIDTH-16)), (r.nextFloat()*(Game.HEIGHT-16)) , ID.SmartEnemy, handler)); 
                        break;
                    case 9:
                        handler.addObject(new SmartEnemy((r.nextFloat()*(Game.WIDTH-16)), (r.nextFloat()*(Game.HEIGHT-16)) , ID.SmartEnemy, handler)); 
                        break;
                    case 10:
                        handler.removeAllEnemies();
                        handler.addObject(new BossEnemy(Game.WIDTH/2 - 40, -106 , ID.BossEnemy, handler,11));  
                        break;
                    default:
                        break;
                }    
            }
            
        }
    }
    
    public void setScoreKeep(int scoreKeep){
        this.scoreKeep = scoreKeep;
    }
}
