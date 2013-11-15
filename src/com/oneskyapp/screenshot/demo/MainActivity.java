package com.oneskyapp.screenshot.demo;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		if (getFragmentManager().findFragmentById(android.R.id.content) == null){
			DemoFragment f = new DemoFragment();
            getFragmentManager().beginTransaction().add(android.R.id.content, f).commit();
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
	        formatView.setText(getString(R.string.test_format, 123f, "format", 12, false));
	        
	        TextView nonLocalizableFormatView = (TextView)view.findViewById(R.id.non_localizable_format);
	        String nonLocalizableFormat = "xfloat = %1$.1f\nnew line = \nxstring = %2$s\nint = %3$d\nboolean = %4$B";        
	        nonLocalizableFormatView.setText(String.format(nonLocalizableFormat, 123f, "format", 12, false));
		}
	}
}
