package com.example.laba7;

import androidx.appcompat.app.AppCompatActivity;

import android.opengl.GLSurfaceView;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity
{
    private GLSurfaceView glSurfaceView;
    private MyGLRenderer cubeSurfaceView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        glSurfaceView = new GLSurfaceView(this);
        cubeSurfaceView = new MyGLRenderer();
        glSurfaceView.setRenderer(cubeSurfaceView);
        setContentView(glSurfaceView);
    }
}


