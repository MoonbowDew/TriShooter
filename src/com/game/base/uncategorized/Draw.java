package com.game.base.uncategorized;




import java.awt.Font;
import java.awt.geom.AffineTransform;
import java.io.InputStream;
import org.newdawn.slick.Color;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.util.ResourceLoader;


import static org.lwjgl.opengl.GL11.*;

/**
 * Created by Dew on 10/29/2016.
 */
public class Draw
{
    private static TrueTypeFont font;
    private static String numberAsString;
    private GOPlayer player;

    Draw(GOPlayer player)
    {
        this.player = player;
    }



    public static void triangle(float x, float y, float width, float height)
    {
        triangle(x, y, width, height, 0);
    }

    public static void triangle(float x, float y, float width, float height,float rot)
    {
        glPushMatrix();
        {
            glTranslatef(x, y, 0);
            glRotatef(rot, 0, 0, 1);

            glBegin(GL_TRIANGLES);
            {
                glColor3f(1.0f,0.0f,0.0f);
                glVertex2f(0, 0);
                glColor3f(0.0f,1.0f,0.0f);
                glVertex2f(0 + width/2, height);
                //glVertex2f(width, height);
                glColor3f(0.0f,0.0f,1.0f);
                glVertex2f(width, 0);
            }
            glEnd();
        }
        glPopMatrix();
    }

    public static void redCircle(float x, float y, float radius)
    {
        redCircle(x, y, radius, 0);
    }

    public static void redCircle(float x, float y, float radius, float rot) {
        glPushMatrix();
        {
            glTranslatef(x, y, 0);
            glRotatef(rot, 0, 0, 1);

            glBegin(GL_POLYGON);
            {
                glColor3f(1.0f,0.0f,0.0f);
                for(double i = 0; i < 2 * Math.PI; i += Math.PI / 6)
                    glVertex3f((float)(Math.cos(i) * radius), (float)(Math.sin(i) * radius), 0.0f);
            }
            glEnd();
        }
        glPopMatrix();
    }

    public static void blueCircle(float x, float y, float radius)
    {
        blueCircle(x, y, radius, 0);
    }

    public static void blueCircle(float x, float y, float radius, float rot) {
        glPushMatrix();
        {
            glTranslatef(x, y, 0);
            glRotatef(rot, 0, 0, 1);

            glBegin(GL_POLYGON);
            {
                glColor3f(0.0f,0.0f,1.0f);
                for(double i = 0; i < 2 * Math.PI; i += Math.PI / 6)
                    glVertex3f((float)(Math.cos(i) * radius), (float)(Math.sin(i) * radius), 0.0f);
            }
            glEnd();
        }
        glPopMatrix();
    }

    public static void initTX()
    {
        // load a default java font
        Font awtFont = new Font("Times New Roman", Font.BOLD, 24);
        font = new TrueTypeFont(awtFont, false);

        // load font from a .ttf file
        try {
            InputStream inputStream	= ResourceLoader.getResourceAsStream("EMPORO.TTF");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void renderTX(int amountOfObjectsArg)
    {

        AffineTransform t = new AffineTransform();
        t.scale(1.0, -1.0);
        font.drawString(100, 50,numberAsString.valueOf(amountOfObjectsArg), Color.yellow);

    }

}
