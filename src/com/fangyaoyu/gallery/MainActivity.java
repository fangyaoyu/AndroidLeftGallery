package com.fangyaoyu.gallery;

import com.fangyaoyu.gallery.adapter.GalleryAdapter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Gallery;

@SuppressWarnings("deprecation")
public class MainActivity extends Activity implements OnItemClickListener {
	private Gallery gallery;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		this.findView();
		this.initVriable();
	}

	private void findView() {
		gallery = (Gallery) findViewById(R.id.gallery);
	}

	private void initVriable() {
		gallery.setOnItemClickListener(this);
		gallery.setAdapter(new GalleryAdapter(getApplicationContext()));
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		Toast.makeText(getApplicationContext(), "" + position,
				Toast.LENGTH_SHORT).show();
	}

	@Override
	protected void onDestroy() {
		gallery.setOnItemClickListener(null);
		super.onDestroy();
	}
}
