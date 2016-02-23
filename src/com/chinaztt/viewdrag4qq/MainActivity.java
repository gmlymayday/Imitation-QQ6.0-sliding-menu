package com.chinaztt.viewdrag4qq;

import java.util.List;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.chinaztt.entity.ItemBean;
import com.chinaztt.utils.ItemDataUtils;
import com.chinaztt.widget.DragLayout;
import com.nineoldandroids.view.ViewHelper;

public class MainActivity extends BaseActivity {
	private DragLayout dl;
	private ListView lv;
	private ImageView iv_icon, iv_bottom;
	private QQAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setStatusBar();
		initDragLayout();
		initView();
	}

	private void initDragLayout() {
		dl = (DragLayout) findViewById(R.id.dl);
		dl.setDragListener(new DragLayout.DragListener() {
			// 界面打开的时候
			@Override
			public void onOpen() {
			}

			// 界面关闭的时候
			@Override
			public void onClose() {
			}

			// 界面滑动的时候
			@Override
			public void onDrag(float percent) {
				ViewHelper.setAlpha(iv_icon, 1 - percent);
			}
		});
	}

	private void initView() {
		iv_icon = (ImageView) findViewById(R.id.iv_icon);
		iv_bottom = (ImageView) findViewById(R.id.iv_bottom);

		lv = (ListView) findViewById(R.id.lv);
		adapter = new QQAdapter(this, ItemDataUtils.getItemBeans());
		lv.setAdapter(adapter);
		iv_icon.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				dl.open();
			}
		});
	}

	class QQAdapter extends BaseAdapter {
		private Context context;
		private List<ItemBean> itemBeans;

		public QQAdapter(Context context, List<ItemBean> itemBeans) {
			super();
			this.context = context;
			this.itemBeans = itemBeans;
		}

		@Override
		public int getCount() {
			return itemBeans.size();
		}

		@Override
		public Object getItem(int position) {
			return itemBeans.get(position);
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@SuppressLint("InflateParams")
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			ViewHolder viewHolder = null;
			if (convertView == null) {
				viewHolder = new ViewHolder();
				convertView = LayoutInflater.from(context).inflate(
						R.layout.item_left_layout, null);
				viewHolder.iv = (ImageView) convertView
						.findViewById(R.id.item_img);
				viewHolder.tv = (TextView) convertView
						.findViewById(R.id.item_tv);
				convertView.setTag(viewHolder);
			} else {
				viewHolder = (ViewHolder) convertView.getTag();
			}
			viewHolder.iv.setBackgroundResource(itemBeans.get(position)
					.getImg());
			viewHolder.tv.setText(itemBeans.get(position).getTitle());
			return convertView;
		}

		class ViewHolder {
			TextView tv;
			ImageView iv;
		}
	}
}
