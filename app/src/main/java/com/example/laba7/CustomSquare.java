package com.example.laba7;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;

import javax.microedition.khronos.opengles.GL10;

public class CustomSquare
{
    private int size = 2048;
    private IntBuffer cubeBuffer;
    private ByteBuffer  byteBuffer;
    int cubeVertices[] =
            {
                -size, -size, size,
                    size, -size, size,
                    size, size, size,
                -size, size, size,

                -size, -size, -size,
                    size, -size, -size,
                    size, size, -size,
                -size, size, -size,

                -size, -size, size,
                -size, -size, -size,
                -size, size, -size,
                -size, size, size,

                    size, -size, size,
                    size, -size, -size,
                    size, size, -size,
                    size, size, size,

                -size, size, size,
                    size, size, size,
                    size, size, -size,
                -size, size, -size,

                -size, -size, size,
                    size, -size, size,
                    size, -size, -size,
                -size, -size, -size
            };

    public CustomSquare()
    {
        byteBuffer = ByteBuffer.allocateDirect(cubeVertices.length * 4);
        byteBuffer.order(ByteOrder.nativeOrder());
        cubeBuffer = byteBuffer.asIntBuffer();
        cubeBuffer.put(cubeVertices);
        cubeBuffer.position(0);
    }

    public void draw(GL10 gl)
    {
        gl.glVertexPointer(3, GL10.GL_FIXED, 0, cubeBuffer);

        gl.glColor4f(0.0f, 1.0f, 0.0f, 1.0f);
        gl.glNormal3f(0.0f, 0.0f, 1.0f);
        gl.glDrawArrays(GL10.GL_TRIANGLE_FAN, 0, 4);

        gl.glNormal3f(0.0f, 0.0f, -1.0f);
        gl.glDrawArrays(GL10.GL_TRIANGLE_FAN, 4, 4);

        gl.glColor4f(0.0f, 0.0f, 1.0f, 1.0f);
        gl.glNormal3f(-1.0f, 0.0f, 0.0f);
        gl.glDrawArrays(GL10.GL_TRIANGLE_FAN, 8, 4);

        gl.glNormal3f(1.0f, 0.0f, 0.0f);
        gl.glDrawArrays(GL10.GL_TRIANGLE_FAN, 12, 4);


        gl.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        gl.glNormal3f(0.0f, 1.0f, 0.0f);
        gl.glDrawArrays(GL10.GL_TRIANGLE_FAN, 16, 4);


        gl.glNormal3f(0.0f, -1.0f, 0.0f); // y yesis негативно
        gl.glDrawArrays(GL10.GL_TRIANGLE_FAN, 20, 4); // △P1P2P6 + △P1P6P5
    }

}
