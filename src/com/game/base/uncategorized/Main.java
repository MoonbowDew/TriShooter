package com.game.base.uncategorized;


import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import static org.lwjgl.opengl.GL11.*;
import org.lwjgl.opengl.GL11;




/**
 * Created by Dew on 10/30/2016.
 */
public class Main
{
    private static Game game;

    public static void main(String[] args)
    {
        //Initialize program
        InitDisplay();
        initGL();
        Draw.initTX();

        initGame();

        gameLoop();
        cleanUp();

    }

    private static void initGame()
    {
        game = new Game();
    }

    private static void getInput()
    {
        game.getInput();
    }

    private static void update()
    {
        game.update();
    }

    private static void render()
    {
        glClear(GL_COLOR_BUFFER_BIT);
        glLoadIdentity();

        game.render();


        Display.update();
        Display.sync(60);
    }

    private static void gameLoop()
    {
        while(!Display.isCloseRequested())
        {
            getInput();
            update();
            render();

        }
    }

    private static void initGL()
    {
        initGLTX();
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        glOrtho(0, Display.getWidth(),Display.getHeight(),0 ,1,-1);
        glMatrixMode(GL_MODELVIEW);

        glClearColor(0,0,0,1);

        glDisable(GL_DEPTH_TEST);
    }

    private static void cleanUp()
    {
        Display.destroy();
        Keyboard.destroy();
    }

    private static void InitDisplay()
    {
        //Create display
        try {
            Display.setDisplayMode(new DisplayMode(800, 600));
            Display.create();
            Display.setVSyncEnabled(true);
            Keyboard.create();
        }
        catch (LWJGLException e)
        {
            e.printStackTrace();
        }
    }




    private static void initGLTX()
    {
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glShadeModel(GL11.GL_SMOOTH);
        GL11.glDisable(GL11.GL_DEPTH_TEST);
        GL11.glDisable(GL11.GL_LIGHTING);

        GL11.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GL11.glClearDepth(1);

        GL11.glEnable(GL11.GL_BLEND);

        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GL11.glViewport(0, 0, Display.getWidth(),Display.getHeight());
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
    }
}
