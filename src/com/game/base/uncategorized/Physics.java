package com.game.base.uncategorized;


/**
 * Created by Dew on 10/29/2016.
 */
public class Physics
{
    static float d;
    static float targetD;
    static boolean booleanCircle;


    public static boolean checkCollisionsCircle(GOBullet go1, GOEnemy go2)
    {
        booleanCircle = false;

                d = (go1.x - go2.x) * (go1.x - go2.x) + (go1.y - go2.y) * (go1.y - go2.y);
                targetD = (5 + 10) * (5 + 10);
                if(d < targetD)
                {
                    booleanCircle = true;
                }
        return booleanCircle;
    }
}
