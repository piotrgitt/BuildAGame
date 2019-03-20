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
                case 2:
                    //-16 so object doesnt appear partly behind frame
                    handler.addObject(new SmartEnemy(r.nextInt(Game.HEIGHT-16), r.nextInt(Game.HEIGHT-16), ID.SmartEnemy, handler));
                    break;
                case 3:
                    handler.addObject(new BasicEnemy(r.nextInt(Game.HEIGHT-16), r.nextInt(Game.HEIGHT-16), ID.BasicEnemy, handler));
                    break;
                case 4:
                    handler.addObject(new FastEnemy(r.nextInt(Game.HEIGHT-16), r.nextInt(Game.HEIGHT-16), ID.BasicEnemy, handler));
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
