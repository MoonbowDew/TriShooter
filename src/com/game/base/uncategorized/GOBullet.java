package com.game.base.uncategorized;


/**
 * Created by Dew on 10/31/2016.
 */
public class GOBullet extends GameObject
{
    public static final int RADIUS = 10;
    public static final float SPEED = 4f;

    private GOPlayer player;

    public float velX; //velocity (speed in a specific direction)
    public float velY; //velocity

    public GOBullet(float x, float y, GOPlayer player)
    {
        this.player = player;
        this.x = x;
        this.y = y;
        velX = SPEED  * (float)(Math.sin(player.rot * Math.PI / 180));
        velY = SPEED * (float)(Math.cos(player.rot * Math.PI / 180));
    }

    @Override
    public void render()
    {
        Draw.redCircle(this.x, this.y, this.RADIUS, player.rot);
    }


    @Override
    public void update()
    {
        x-= velX;
        y+= velY;
    }

}
