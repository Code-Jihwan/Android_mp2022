package com.example.myapplication9;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

//p.56~     그래픽스 실습
public class MyView extends View {
    private Paint paint;    //붓 설정 (한번만 호줄하면 된다.)
    private Bitmap bitmap;  //이미지위한 bitmap (한번만 호출함으로 전역변수로 사용)

    public MyView(Context context){     //생성자 메소드
        super(context);
        paint = new Paint();    //붓 설정
        paint.setColor(0xffff0000);
        paint.setStrokeWidth(5);

        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.event4);   //bitmap 객체를 얻음.
    }
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);   //도와지 설정
        canvas.drawColor(0xffffff00);
        
        //선
        canvas.drawLine(0,0,getWidth(), getHeight(), paint);    //선 그리기
        
        //사각형
        paint.setColor(0xff0000ff);
        canvas.drawRect(100,100,200,200, paint); //시작 좌표, 끝 좌표 (사각형 그리기)
        
        //사각형 테두리만
        paint.setColor(0xffff0000);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawRect(500, 500, 700, 700, paint);
        
        //원
        canvas.drawCircle(600, 1100, 200, paint);
        
        //텍스트
        paint.setColor(0xff00ff00);
        paint.setTextSize(100);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawText("Hello World!", 200, 1000, paint);

        //bitmap (사진 보이기)
        canvas.drawBitmap(bitmap, 0, 1200, paint);
    }
}
