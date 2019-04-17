
package gameClasses;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class BossEnemy extends GameObject {

    private Handler handler;
    private int timer = 200;
    private int timer2 = 80;
    private int spawn;
    private boolean readyToFire = false;
    private int chanceToFireBullet; // highier number - less chance to

    public BossEnemy(float x, float y, ID id, Handler handler, int chanceToFireBullet) {
        super(x, y, id);

        this.handler = handler;

        velX = 0.0f;
        velY = 0.85f;
        
        this.chanceToFireBullet = chanceToFireBullet;

    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        
        if (x > Game.WIDTH - 96 || x < 0) {
            velX *= -1;
        }
//        if (y > Game.HEIGHT - 96 || y < 0) {  //Collision with top and bottom walls
//            velY *= -1;
//        }
        
        //handler.addObject(new Trail(x, y, Color.red, 96.0f, 96.0f, 0.025f, ID.Trail, handler));
        
        if(timer == 0) {
            
            velY = 0;
            timer2--;
            
        } else timer --;
        
        if(timer2 == 0) {
            velX = 2;
            readyToFire = true;
        }
        
        //SPAWN BULLET SECTION --------------------
        if(readyToFire == true){
            velX += 0.01f*Math.signum(velX);
            spawn = random.nextInt(chanceToFireBullet);
            if(spawn == 0){
                handler.addObject(new BossBullet(x+40, y+40, ID.BossBullet, handler));
           }
        }
        
        
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.red);                        //set color of boss
        g.fillRect((int)x, (int)y, 96, 96);           //fill renctangle - Dimenstion of him is 16x16px
    }   

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, 96, 96 );  //16 x 16 is dimensions of our rectangle
    }

}
