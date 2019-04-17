package gameClasses;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class BossBullet extends GameObject {

    private Handler handler;
    private final Random randomNumber = new Random();

    public BossBullet(float x, float y, ID id, Handler handler) {
        super(x, y, id);

        this.handler = handler;

        velX = (randomNumber.nextFloat())*10 -5;
        velY = 4.0f;

    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        /**
         * if an Enemy hits our window wall, his velocity will reverse - he just
         * bounce off(multiplying by -1)
         */
//        if (x > Game.WIDTH - 16 || x < 0) {
//            handler.removeObject(this);
//        }
//        if (y > Game.HEIGHT - 16 || y < 0) {
//            handler.removeObject(this);
//        }

          if(x > Game.WIDTH) handler.removeObject(this);
          if(y > Game.HEIGHT) handler.removeObject(this);

        handler.addObject(new Trail(x, y, Color.red, 16, 16, 0.025f, ID.Trail, handler));
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.red);  //set color of render object
        g.fillRect((int)x, (int)y, 16, 16);  //fill renctangle - Dimenstion of him is 16x16px
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, 16, 16);  //16 x 16 is dimensions of our rectangle
    }

}
