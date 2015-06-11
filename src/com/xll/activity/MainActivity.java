package com.xll.activity;

import com.xll.R;
import com.xll.R.id;
import com.xll.R.layout;
import com.xll.R.menu;
import com.xll.myview.OvalView;
import com.xll.myview.OvalView.OnMyClickListener;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends ActionBarActivity {

	private OvalView ov;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ov = (OvalView)findViewById(R.id.myview);
		ov.setOnMyClickListener(new OnMyClickListener() {
			
			@Override
			public void onMyClick() {
				// TODO Auto-generated method stub
				startActivity(new Intent(MainActivity.this, TActivity.class));
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
