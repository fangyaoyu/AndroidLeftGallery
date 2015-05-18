package com.fangyaoyu.gallery.widget;

import com.fangyaoyu.gallery.utils.PhoneUtils;

import android.content.Context;
import android.graphics.Camera;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Transformation;
import android.widget.Gallery;
import android.widget.SpinnerAdapter;

@SuppressWarnings("deprecation")
public class AndroidGallery extends Gallery {
	private Camera camera;
	/** the width of every item,default is screenWidth * 0.9 */
	private int width;

	public AndroidGallery(Context context) {
		super(context);
		initVirable();
	}

	public AndroidGallery(Context paramContext, AttributeSet paramAttributeSet) {
		super(paramContext, paramAttributeSet);
		initVirable();
	}

	public AndroidGallery(Context paramContext, AttributeSet paramAttributeSet,
			int paramInt) {
		super(paramContext, paramAttributeSet, paramInt);
		initVirable();
	}

	protected void initVirable() {

		this.setSoundEffectsEnabled(false);
		this.setSpacing(0);
		this.setFadingEdgeLength(0);

		camera = new Camera();

		width = (int) (PhoneUtils.getScreenWidth(getContext()) * 0.9f);
	}

	@Override
	public boolean onFling(MotionEvent event1, MotionEvent event2,
			float velocityX, float velocityY) {
		if ((event1 == null) || (event2 == null)) {
			return false;
		}
		int kEvent = 0;
		if (isScollToLeft(event1, event2)) {
			kEvent = KeyEvent.KEYCODE_DPAD_LEFT;
		} else {
			kEvent = KeyEvent.KEYCODE_DPAD_RIGHT;
		}
		onKeyDown(kEvent, null);
		return true;
	}

	private boolean isScollToLeft(MotionEvent e1, MotionEvent e2) {
		return (e1.getX() < e2.getX());
	}

	public boolean onInterceptTouchEvent(MotionEvent ev) {
		return true;
	}

	protected boolean getChildStaticTransformation(View child, Transformation t) {
		t.clear();
		t.setTransformationType(Transformation.TYPE_MATRIX);
		camera.save();
		final Matrix imageMatrix = t.getMatrix();
		if (isLastPostion()) {
			camera.translate(PhoneUtils.getScreenWidth(getContext()) / 2
					- width / 2, 0f, 0f);
		} else {
			camera.translate(
					width / 2 - PhoneUtils.getScreenWidth(getContext()) / 2,
					0f, 0f);
		}
		camera.getMatrix(imageMatrix);
		camera.restore();

		getPositionForView(child);
		return true;
	}

	protected boolean isLastPostion() {
		boolean isLast = false;
		SpinnerAdapter adapter = getAdapter();
		if (adapter != null) {
			isLast = (getSelectedItemPosition() == (adapter.getCount() - 1));
		}
		return isLast;
	}

	public void setWidth(int width) {
		this.width = width;
	}
}
