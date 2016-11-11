package com.game.base.uncategorized;

import java.util.ArrayList;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;


import static org.lwjgl.opengl.GL11.GL_ONE;
import static org.lwjgl.opengl.GL11.GL_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.glBlendFunc;

/**
 * Created by Dew on 10/29/2016.
 */
public class Game
{
    private ArrayList<GameObject> objects;

    private GOPlayer player;
    private GOEnemy enemy;
    private GOEnemy enemyCurrent;
    private GOBullet bulletCurrent;
    private int killedEnemies = 0;
    private int amountOfEnemies = 20;
    private int amountOfBullets = 0;

    public Game()
    {
        objects = new ArrayList<GameObject>();
        enemy = new GOEnemy();

        player = new GOPlayer(Display.getWidth() / 2 , Display.getHeight()/2 );

        objects.add(player);

        for(int i = 0; i < amountOfEnemies; i++)
        {
            GOEnemy enemy;
            enemy = new GOEnemy();
            objects.add(enemy);
        }
    }

    public void getInput()
    {


            if (Keyboard.isKeyDown(Keyboard.KEY_W) || Keyboard.isKeyDown(Keyboard.KEY_UP)) {
                player.moveForward(1);
            }
            if (Keyboard.isKeyDown(Keyboard.KEY_S) || Keyboard.isKeyDown(Keyboard.KEY_DOWN)) {
                player.moveBackward(-1);
            }
            if (Keyboard.isKeyDown(Keyboard.KEY_A) || Keyboard.isKeyDown(Keyboard.KEY_LEFT)) {
                player.moveRotRight(1);
            }
            if (Keyboard.isKeyDown(Keyboard.KEY_D) || Keyboard.isKeyDown(Keyboard.KEY_RIGHT)) {
                player.moveRotLeft(-1);
            }
            if (Keyboard.isKeyDown(Keyboard.KEY_SPACE))
            {

                    {

                        objects.add(player.fire(player.x, player.y, player));
                        amountOfBullets++;
                    }

            }

    }

    public void update()
    {

        amountOfEnemies = 0;
        amountOfBullets = 0;


        for (int k = 0; k < objects.size(); k++)
        {
            if(objects.get(k) instanceof GOEnemy)
                amountOfEnemies++;
        }


        for (int k = 0; k < objects.size(); k++)
        {
            if(objects.get(k) instanceof GOBullet)
                amountOfBullets++;
        }

        for(int i = 0; i < amountOfEnemies + amountOfBullets + 1; i++)
        {
            objects.get(i).update();

            if(objects.get(i) instanceof GOPlayer)
            {
                if (((GOPlayer) objects.get(i)).x > Display.getWidth())
                    objects.get(i).x = objects.get(i).x - 10;

                if (((GOPlayer) objects.get(i)).x < 0)
                    objects.get(i).x = objects.get(i).x + 10;

                if(((GOPlayer) objects.get(i)).getY() < 0)
                    objects.get(i).y = objects.get(i).y + 10;

                if(((GOPlayer) objects.get(i)).getY() > Display.getHeight())
                    objects.get(i).y = objects.get(i).y - 10;


            }

            if(objects.get(i) instanceof GOBullet)
            {
                if (((GOBullet) objects.get(i)).x > (Display.getWidth()) || ((GOBullet) objects.get(i)).getX() < 0 || ((GOBullet) objects.get(i)).getY() < 0 || ((GOBullet) objects.get(i)).getY() > Display.getHeight())
                {
                    objects.remove(objects.get(i));
                    i--;
                    amountOfBullets--;
                }
            }

            if (objects.get(i) instanceof GOBullet)
            {
                bulletCurrent = (GOBullet)objects.get(i);
                for (int j = 0; j < amountOfEnemies + amountOfBullets + 1; j++)
                {
                    if(objects.get(j) instanceof GOEnemy)
                    {
                        enemyCurrent = (GOEnemy)objects.get(j);
                        if (Physics.checkCollisionsCircle(bulletCurrent, enemyCurrent))
                        {
                            objects.remove(i);
                            i--;
                            amountOfBullets--;
                            if(j == objects.size())
                                j--;
                            objects.remove(j);
                            j--;
                            amountOfEnemies--;
                            killedEnemies++;

                            if(amountOfEnemies < 20)
                            {

                                    objects.add(enemy.generateAlrogithm());
                                    amountOfEnemies++;

                            }

                        }
                    }

                }
            }

        }

    }

    public void render()
    {
        for(GameObject go: objects)
        {
            go.render();
        }
        Display.setTitle("TriShooter");
        // HUD
        glBlendFunc(GL_SRC_ALPHA, GL_ONE);
        Draw.renderTX(killedEnemies);
        glBlendFunc(GL11.GL_ONE_MINUS_SRC_ALPHA, GL11.GL_ONE_MINUS_CONSTANT_ALPHA);
    }
}
