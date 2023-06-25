package com.example.laba7;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.GLU;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class MyGLRenderer implements GLSurfaceView.Renderer
{
    private CustomSquare _cube;
    private long startTime;
    public void onSurfaceCreated(GL10 gl, EGLConfig config)
    {
        gl.glEnable(GL10.GL_DEPTH_TEST);

        gl.glDepthFunc(GL10.GL_LEQUAL);

        _cube = new CustomSquare();

        startTime = System.currentTimeMillis();
    }

    public void onDrawFrame(GL10 gl)
    {
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);

        long delta = System.currentTimeMillis() - startTime;

        gl.glLoadIdentity();

        gl.glTranslatef(0.0f, 0.0f, -3.0f);

        gl.glRotatef(delta / 1000f * 15, 1.0f, 0.0f, 0.0f);
        gl.glRotatef(delta / 1000f * 20, 0.0f, 1.0f, 0.0f);
        gl.glRotatef(delta / 1000f * 25, 0.0f, 0.0f, 1.0f);

        _cube.draw(gl);

        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
    }

    public void onSurfaceChanged(GL10 gl, int width, int height)
    {
        float ratio = (float) width / height;
        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(GL10.GL_PROJECTION);
        gl.glLoadIdentity();
        GLU.gluPerspective(gl, 5.0f, ratio, 1.0f, 100.0f);
        gl.glMatrixMode(GL10.GL_MODELVIEW);
    }

    public static int uploadShader(int type, String shaderCode)
    {
        int shader = GLES20.glCreateShader(type);
        GLES20.glShaderSource(shader, shaderCode);
        GLES20.glCompileShader(shader);
        return shader;
    }
}
