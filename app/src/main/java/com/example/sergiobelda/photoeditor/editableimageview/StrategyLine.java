package com.example.sergiobelda.photoeditor.editableimageview;

import android.view.MotionEvent;
import com.example.sergiobelda.photoeditor.editableimageview.figures.Line;

/**
 * Manages the Paint tool
 */
public class StrategyLine extends StrategyTool {

    @Override
    public void onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                float x = event.getX();
                float y = event.getY();
                Line line = new Line(x, y, x, y, imageView.currentColor);
                imageView.lines.add(line);
                break;
            }
            case MotionEvent.ACTION_MOVE: {
                int i = imageView.lines.size() - 1;
                float xf = event.getX();
                float yf = event.getY();
                if (imageView.lines.size() > 0) {
                    Line mLine = imageView.lines.get(i);
                    mLine.setXf(xf);
                    mLine.setYf(yf);
                    imageView.lines.set(i, mLine);
                }
                break;
            }
        }
        invalidate();
    }
}