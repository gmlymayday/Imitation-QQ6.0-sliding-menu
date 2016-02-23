package com.chinaztt.utils;

import com.chinaztt.entity.ItemBean;
import com.chinaztt.viewdrag4qq.R;

import java.util.ArrayList;
import java.util.List;

public class ItemDataUtils {
	public static List<ItemBean> getItemBeans() {
		List<ItemBean> itemBeans = new ArrayList<>();
		itemBeans.add(new ItemBean(R.drawable.sidebar_purse, "QQ钱包", false));
		itemBeans
				.add(new ItemBean(R.drawable.sidebar_decoration, "个性装扮", false));
		itemBeans.add(new ItemBean(R.drawable.sidebar_favorit, "我的收藏", false));
		itemBeans.add(new ItemBean(R.drawable.sidebar_album, "我的相册", false));
		itemBeans.add(new ItemBean(R.drawable.sidebar_file, "我的文件", false));
		return itemBeans;
	}
}
