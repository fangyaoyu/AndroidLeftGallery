package com.fangyaoyu.gallery.adapter;

import java.util.ArrayList;
import java.util.List;

import com.fangyaoyu.gallery.R;
import com.fangyaoyu.gallery.entity.Data;
import com.fangyaoyu.gallery.utils.PhoneUtils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GalleryAdapter extends BaseAdapter {
	private Context context;
	private List<Data> listAds;

	public GalleryAdapter(Context context) {
		super();
		this.context = context;
		listAds = new ArrayList<Data>();
		listAds.add(new Data(R.drawable.icon_1, "Title1", "Title11"));
		listAds.add(new Data(R.drawable.icon_2, "Title2", "Title21"));
		listAds.add(new Data(R.drawable.icon_3, "Title3", "Title31"));
		listAds.add(new Data(R.drawable.icon_4, "Title4", "Title41"));
		listAds.add(new Data(R.drawable.icon_5, "Title5", "Title51"));
		listAds.add(new Data(R.drawable.icon_6, "Title6", "Title61"));
		listAds.add(new Data(R.drawable.icon_7, "Title7", "Title71"));
		listAds.add(new Data(R.drawable.icon_8, "Title8", "Title81"));
	}

	@Override
	public int getCount() {
		return listAds.size();
	}

	@Override
	public Object getItem(int position) {
		return listAds.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if (convertView == null) {
			convertView = LayoutInflater.from(context).inflate(
					R.layout.item_gallery, parent, false);
			holder = new ViewHolder(convertView);
			convertView.getLayoutParams().width = (int) (PhoneUtils
					.getScreenWidth(context) * 0.9f);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		convertView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {

			}
		});
		holder.setData((Data) getItem(position));
		return convertView;
	}

	class ViewHolder {
		ImageView imgLogo;
		TextView tvTitle;
		TextView tvCropName;

		public ViewHolder(View view) {
			super();
			imgLogo = (ImageView) view.findViewById(R.id.img_logo);
			tvTitle = (TextView) view.findViewById(R.id.tv_title);
			tvCropName = (TextView) view.findViewById(R.id.tv_crop_name);
		}

		public void setData(Data data) {
			imgLogo.setImageResource(data.getResId());
			tvTitle.setText(data.getTitle1());
			tvCropName.setText(data.getTitle2());
		}
	}
}
