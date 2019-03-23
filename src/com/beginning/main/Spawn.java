package com.beginning.main;

import java.util.Random;

public class Spawn {

    private Random r = new Random();
    public Handler handler;
    private HUD hud;
    private int scoreKeep = 0;

    public Spawn(Handler handler, HUD hud) {
        this.handler = handler;
        this.hud = hud;
    }

    public void tick() {
        scoreKeep++;

        if (scoreKeep >= 100) {
            scoreKeep = 0;
            hud.setLevel(hud.getLevel() + 1);

            switch (hud.getLevel()) {
                case 2: //WHEN LV 2 is begin
                    //-16 so object doesnt appear partly behind frame and block himself
                    for(int i=0;i<33;i++){
                    handler.addObject(new BasicEnemy((float)r.nextInt((int)(Game.WIDTH-16)),(float)r.nextInt((int) (Game.HEIGHT-16)) , ID.BasicEnemy, handler));                 
                    }
                    break;
                case 3:
                    handler.addObject(new FastEnemy((float)r.nextInt((int)(Game.WIDTH-16)),(float)r.nextInt((int) (Game.HEIGHT-16)) , ID.FastEnemy, handler));                 
                    break;
                case 4:
                    handler.addObject(new SmartEnemy((r.nextFloat()*Game.WIDTH)-16,(r.nextFloat()*Game.HEIGHT)-16, ID.SmartEnemy, handler));
                    break;
                case 5:
                    //handler.addObject(new SmartEnemy(r.nextInt(Game.HEIGHT-16), r.nextInt(Game.HEIGHT-16), ID.SmartEnemy, handler));
                    break;
                default:
                    break;
            }
        }
    }
}
