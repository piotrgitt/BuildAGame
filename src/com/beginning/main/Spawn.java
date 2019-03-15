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

        if (scoreKeep >= 200) {
            scoreKeep = 0;
            hud.setLevel(hud.getLevel() + 1);

            if (hud.getLevel() == 2) {
                handler.addObject(new BasicEnemy(r.nextInt(Game.HEIGHT), r.nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
            } else if (hud.getLevel() == 3) {
                handler.addObject(new BasicEnemy(r.nextInt(Game.HEIGHT), r.nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
            } else if (hud.getLevel() == 4) {
                handler.addObject(new FastEnemy(r.nextInt(Game.HEIGHT), r.nextInt(Game.HEIGHT), ID.FastEnemy, handler));
            }
        }
    }
}
