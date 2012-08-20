package org.lxh.demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SlidingDrawer;
import android.widget.SlidingDrawer.OnDrawerCloseListener;
import android.widget.SlidingDrawer.OnDrawerOpenListener;
import android.widget.SlidingDrawer.OnDrawerScrollListener;
import android.widget.TextView;
import android.widget.Toast;

public class MySlidingDrawerDemo extends Activity {
	private String data[] = { "����ħ�ֿƼ�", "www.mldnjava.cn", "��ʦ�����˻�",
			"�й���У��������", "www.jiangker.com"};					// ������ʾ������
	private ListView listView;  									// ����ListView���
	private SlidingDrawer slidingDrawer ;							// ����SlidingDrawer
	private ImageView handle ;										// ����ͼƬ��ʾ

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.main);
		LinearLayout layout = (LinearLayout) super.findViewById(R.id.content) ;
		this.listView = new ListView(this) ;						// ʵ�������
		listView.setAdapter(new ArrayAdapter<String>(this,			// �����ݰ�װ
				android.R.layout.simple_expandable_list_item_1, 	// ÿ����ʾһ������
				this.data));										// �����������
		layout.addView(this.listView) ;								// �������
		this.slidingDrawer = (SlidingDrawer) super.findViewById(R.id.slidingdrawer) ;
		this.handle = (ImageView) super.findViewById(R.id.handle) ;// ȡ�����
		this.slidingDrawer.setOnDrawerOpenListener(new OnDrawerOpenListenerImpl()) ;	// ���ü���										
		this.slidingDrawer.setOnDrawerCloseListener(new OnDrawerCloseListenerImpl()) ;	// ���ü���													
		this.slidingDrawer.setOnDrawerScrollListener(new OnDrawerScrollListenerImpl()) ;// ���ü���
	    
		TextView textview = (TextView)findViewById(R.id.textview);
		textview.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(MySlidingDrawerDemo.this, "asdfaf", 200).show();
			}
		});
	}
	private class OnDrawerOpenListenerImpl implements OnDrawerOpenListener {
		@Override
		public void onDrawerOpened() {
			handle.setImageResource(R.drawable.ico_right) ;			// ���ڴ򿪼���
		}
	}
	private class OnDrawerCloseListenerImpl implements OnDrawerCloseListener {
		@Override
		public void onDrawerClosed() {
			handle.setImageResource(R.drawable.ico_left) ;			// ���ڹرռ���
		}
	}
	private class OnDrawerScrollListenerImpl implements OnDrawerScrollListener {
		@Override
		public void onScrollEnded() {								// �϶�����
			Toast.makeText(MySlidingDrawerDemo.this, "�����϶�������", Toast.LENGTH_SHORT).show();
		}
		@Override
		public void onScrollStarted() {								// �϶���ʼ
			Toast.makeText(MySlidingDrawerDemo.this, "�����϶����ڡ�", Toast.LENGTH_SHORT).show();
		}
	}
	public void abc(View view){
		
	}
}