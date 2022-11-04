package com.example.myapplication10;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;

public class MyView extends View {      //view의 하위 클래서 Myview는
    private Paint paint;
    private int x, y;   //임이의 좌표 지정

    public MyView(Context context) {
        super(context);
        paint = new Paint();
        x = y = 2;  //초기값 설정
    }

    public void left() {    //left 메소드를 둔다.
        if (--x < 0)
            x = 0;      //감소 시키는데 음수면 x를 0으로 함.
        invalidate();   //그림을 다시 그림
        Log.e("1111","11111");
    }

    public void right() {
        if (++x > 4)
            x = 4;
        invalidate();   //그림을 다시 그림
        Log.e("22222","2222222");
    }

    public void up() {
        if (--y < 0)
            y = 0;
        invalidate();   //그림을 다시 그림
        Log.e("33333","3333");
    }

    public void down() {
        if (++y > 4)    //5보다 클수는 없고 만약 넘으면 4로 고정
            y = 4;
        invalidate();   //그림을 다시 그림
        Log.e("444444444","44444444");
    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);   //자기 부모 클래스에 onDraw를 부름
        canvas.drawRGB(255,255,0);  //도화지 색

        paint.setStrokeWidth(2); //선 굵기
        int width = getWidth();
        int height = getHeight();
        int w = width/5;
        int h = height/5;
        paint.setColor(Color.BLACK);
        for (int i=1; i<5; i++) {
            canvas.drawLine(0,i*h, width, i*h, paint);  //가로줄
            canvas.drawLine(i*w,0, i*w, height, paint);  //세로줄
        }

        paint.setColor(Color.RED);
        canvas.drawRect(w*x, h*y, w*(x+1), h*(y+1), paint); //사각형의 좌표 설정
    }
}
