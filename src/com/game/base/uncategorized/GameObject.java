package com.game.base.uncategorized;

/**
 * Created by Dew on 10/29/2016.
 */
public abstract class GameObject
{
    protected float x;
    protected float y;
    protected float sx; //size of X
    protected float sy; //size of Y
    protected float rot;

    abstract void update();
    abstract void render();

    public float getX()
    {
        return x;
    }

    public float getY()
    {
        return y;
    }


}
