package com.fangyaoyu.gallery.entity;

public class Data {
	private int resId;
	private String title1;
	private String title2;

	public Data() {
		super();
	}

	public Data(int resId, String title1, String title2) {
		super();
		this.resId = resId;
		this.title1 = title1;
		this.title2 = title2;
	}

	public int getResId() {
		return resId;
	}

	public void setResId(int resId) {
		this.resId = resId;
	}

	public String getTitle1() {
		return title1;
	}

	public void setTitle1(String title1) {
		this.title1 = title1;
	}

	public String getTitle2() {
		return title2;
	}

	public void setTitle2(String title2) {
		this.title2 = title2;
	}

}
