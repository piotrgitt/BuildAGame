package com.beginning.main;

import java.util.Random;

public class Spawn {

    private final Random r = new Random();
    public Handler handler;
    private HUD hud;
    private int scoreKeep = 0;

    public Spawn(Handler handler, HUD hud) {
        this.handler = handler;
        this.hud = hud;
    }

    public void tick() {
        scoreKeep++;

        if (scoreKeep >= 250) {
            scoreKeep = 0;
            hud.setLevel(hud.getLevel() + 1);

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
                    handler.addObject(new BossEnemy(Game.WIDTH/2 - 40, -106 , ID.BossEnemy, handler,11));  
                    break;
                default:
                    break;
            }
        }
    }
}
