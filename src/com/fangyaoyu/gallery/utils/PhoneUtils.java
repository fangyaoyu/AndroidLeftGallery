package com.fangyaoyu.gallery.utils;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

public class PhoneUtils {
	private static int SCREEN_WIDTH = 0;

	
	public static int getScreenWidth(Context context) {
		if (SCREEN_WIDTH == 0) {
			WindowManager systemService = (WindowManager) context
					.getSystemService(Context.WINDOW_SERVICE);
			DisplayMetrics metric = new DisplayMetrics();
			systemService.getDefaultDisplay().getMetrics(metric);
			SCREEN_WIDTH = metric.widthPixels;
		}
		return SCREEN_WIDTH;
	}
}
