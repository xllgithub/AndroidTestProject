package com.xll.myview;

import com.xll.R;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class OvalView extends View{
	
	private boolean isClickable;
	private int orientation;
	public static final int HORIZONTAL = 0;
	public static final int VERTICAL = 1;
	
	private OnMyClickListener mListener;
	
	private Paint paint = new Paint();
	private RectF rf = new RectF();

	public OvalView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		initViewParams();
	}
	
	public OvalView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		// TODO Auto-generated constructor stub
		initViewParams();
		
		TypedArray typeArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.OvalView, 0, 0);
		try{
			isClickable = typeArray.getBoolean(R.styleable.OvalView_clickable, true);
			orientation = typeArray.getInt(R.styleable.OvalView_orientation, HORIZONTAL);
		}finally{
			typeArray.recycle();
		}
		
	}

	public OvalView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		initViewParams();
	}
	
	private void initViewParams() {
		paint.setAntiAlias(true);
		paint.setFilterBitmap(true);
		
		isClickable = true;
		orientation = HORIZONTAL;
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		
		paint.setColor(Color.BLUE);
		switch(orientation) {
		case HORIZONTAL:
			rf.set(0f, 0f, 300f, 200f);	
			break;
		case VERTICAL:
			rf.set(0f, 0f, 200f, 300f);
			break;
		}
		canvas.drawArc(rf, 0f, 360f, true, paint);
	}
	
	public void setClickable(boolean clickable) {
		this.isClickable = clickable;
	}
	
	public void setOrientation(int orientation) {
		this.orientation = orientation;
	}
	
	public interface OnMyClickListener {
		void onMyClick();
	}
	
	public void setOnMyClickListener(OnMyClickListener onMyListener) {
		mListener = onMyListener;
	}
	
	@SuppressLint("ClickableViewAccessibility")
	public boolean onTouchEvent(MotionEvent event) {  
        if(event.getAction()==MotionEvent.ACTION_UP){  
            if(isClickable&&mListener!=null){  
                mListener.onMyClick();  
            }  
        }  
        return true;  
    }  

}
