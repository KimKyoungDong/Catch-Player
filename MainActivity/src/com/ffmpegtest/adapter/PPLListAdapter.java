package com.ffmpegtest.adapter;

import java.util.ArrayList;

import com.ffmpegtest.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class PPLListAdapter extends BaseAdapter {

	private LayoutInflater inflater = null;
	private ArrayList<String> PPLList = null;
	private ViewHolder viewHolder = null;
	private Context mContext = null;

	public PPLListAdapter(Context c , ArrayList<String> arrays){
		this.mContext = c;
		this.inflater = LayoutInflater.from(c);
		this.PPLList = arrays;
	}

	// Adapter가 관리할 List의 개수를 설정 합니다.
	@Override
	public int getCount() {
		return PPLList.size();
	}

	// Adapter가 관리하는 List의 Item 의 Position을 <객체> 형태로 얻어 옵니다.
	@Override
	public String getItem(int position) {
		return PPLList.get(position);
	}

	// Adapter가 관리하는 List의 Item 의 position 값의 ID 를 얻어 옵니다.
	@Override
	public long getItemId(int position) {
		return position;
	}

	// ListView의 뿌려질 한줄의 Row를 설정 합니다.
	@Override
	public View getView(int position, View convertview, ViewGroup parent) {

		View v = convertview;

		if(v == null){
			viewHolder = new ViewHolder();
			v = inflater.inflate(R.layout.ppl_data_list, null);
			viewHolder.tv_title = (TextView)v.findViewById(R.id.tv_ppl_title);
			viewHolder.tv_img = (ImageView)v.findViewById(R.id.iv_ppl_img);
			viewHolder.tv_info = (TextView)v.findViewById(R.id.tv_ppl_info);

			v.setTag(viewHolder);

		}else {
			viewHolder = (ViewHolder)v.getTag();
		}

		viewHolder.tv_title.setText(getItem(position));
		viewHolder.tv_img.setBackgroundResource(R.drawable.ic_launcher);
		viewHolder.tv_info.setText("PPL 상품 정보입니다. 이 상품은 어쩌구저쩌고 쏼라쏼라 입니다.");

		return v;
	}

	// Adapter가 관리하는 List List를 교체 한다. 
	// 교체 후 Adapter.notifyListSetChanged() 메서드로 변경 사실을
	// Adapter에 알려 주어 ListView에 적용 되도록 한다.
	public void setArrayList(ArrayList<String> arrays){
		this.PPLList = arrays;
	}

	public ArrayList<String> getArrayList(){
		return PPLList;
	}

	/*
	 * ViewHolder 
	 * getView의 속도 향상을 위해 쓴다.
	 * 한번의 findViewByID 로 재사용 하기 위해 viewHolder를 사용 한다.
	 */
	class ViewHolder{
		public TextView tv_title = null;
		public ImageView tv_img = null;
		public TextView tv_info = null;
	}

	@Override
	protected void finalize() throws Throwable {
		free();
		super.finalize();
	}

	private void free(){
		inflater = null;
		PPLList = null;
		viewHolder = null;
		mContext = null;
	}

}
