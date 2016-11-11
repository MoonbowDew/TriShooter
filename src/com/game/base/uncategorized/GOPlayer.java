package com.game.base.uncategorized;


/**
 * Created by Dew on 10/30/2016.
 */
public class GOPlayer extends GameObject
{
    public static final int SIZEX = 26;
    public static final int SIZEY = SIZEX * 4;
    public static final float SPEED = 6f;



    public GOPlayer(float x, float y)
    {
        this.x = x;
        this.y = y;
        this.sx = SIZEX;
        this.sy = SIZEY;
        this.rot = 0;

    }

    public GOPlayer()
    {

    }

    @Override
    public void update()
    {

    }

    @Override
    public void render()
    {
            Draw.triangle(x, y, sx, sy, rot);

    }

    public void moveForward(float mag)
    {
        x-= SPEED  * Math.sin(rot * Math.PI / 180);
        y+=SPEED * Math.cos(rot * Math.PI / 180);
    }

    public void moveBackward(float mag)
    {
        x+= SPEED  * Math.sin(rot * Math.PI / 180);
        y-=SPEED * Math.cos(rot * Math.PI / 180);
    }

    public void moveRotRight(float mag)
    {
        rot-=SPEED*mag;
    }

    public void moveRotLeft(float mag)
    {
        rot-=SPEED*mag;
    }

    public GOBullet fire(float x, float y, GOPlayer player)
    {
        GOBullet bullet = new GOBullet(x, y, player);
        return bullet;
    }
}
