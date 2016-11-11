package com.game.base.uncategorized;

import org.lwjgl.opengl.Display;
import java.util.Random;

/**
 * Created by Dew on 11/1/2016.
 */
public class GOEnemy extends GameObject
{
    public static final int RADIUS = 5;

    private GOEnemy enemy;
    private Random rndX;
    private Random rndY;
    private Random rnd;

    GOEnemy()
    {
        this.rndX = new Random();
        this.rndY = new Random();
        this.x = rndX.nextFloat() * Display.getWidth();
        this.y = rndY.nextFloat() * Display.getHeight();
    }


    public GOEnemy generateAlrogithm()
    {

            rnd = new Random();
            enemy = new GOEnemy();
        return enemy;

    }

    @Override
    public void update()
    {

    }


    @Override
    public void render()
    {
        Draw.blueCircle(this.x, this.y, this.RADIUS, 0);
    }



}
