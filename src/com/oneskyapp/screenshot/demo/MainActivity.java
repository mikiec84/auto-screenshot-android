package com.oneskyapp.screenshot.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		requestWindowFeature(Window.FEATURE_CONTEXT_MENU);
		
		if (getSupportFragmentManager().findFragmentById(android.R.id.content) == null){
			DemoFragment f = new DemoFragment();
			getSupportFragmentManager().beginTransaction().add(android.R.id.content, f).commit();
		}		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public static class DemoFragment extends Fragment {

		ListView mListView;
		
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
	
			View layout = inflater.inflate(R.layout.activity_main, container, false);		
			return layout;
		}
		
    	@Override
    	public void onViewCreated(View view, Bundle savedInstanceState) {

    		super.onViewCreated(view, savedInstanceState);
			
			mListView = (ListView) view.findViewById(R.id.list_view);
			
			String[] array = getResources().getStringArray(R.array.array);
			
	        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
	                    android.R.layout.simple_list_item_1, array);
	        
	        mListView.setAdapter(adapter);
	        
	        TextView formatView = (TextView)view.findViewById(R.id.test_format);
	        formatView.setText(getString(R.string.test_format, 1231223f, "format", 12, false));
	        
	        mListView.setOnItemClickListener(new OnItemClickListener(){

				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1,
						int arg2, long arg3) {
					
					Intent i = new Intent(getActivity(), MainActivity.class);
					startActivity(i);
				}	        	
	        });
		}
	}
}
