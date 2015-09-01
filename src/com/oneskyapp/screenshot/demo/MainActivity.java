package com.oneskyapp.screenshot.demo;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
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

				public void onItemClick(AdapterView<?> listView, View view,
						int position, long id) {					
					Intent i = new Intent(getActivity(), MainActivity.class);
					startActivity(i);
				}
	        });
	        
	        Button button = (Button) view.findViewById(R.id.button);
	        button.setOnClickListener(new OnClickListener() {

				public void onClick(View view) {
					TestDialogFragment dialog = new TestDialogFragment();
					dialog.show(getFragmentManager(), "TestDialog");
				}
	        });
		}
	}
	
	public static class TestDialogFragment extends DialogFragment {
	    @Override
	    public Dialog onCreateDialog(Bundle savedInstanceState) {
	        // Use the Builder class for convenient dialog construction
	        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
	        builder.setMessage(R.string.dialog_message)
	               .setPositiveButton(R.string.okay, new DialogInterface.OnClickListener() {
	                   public void onClick(DialogInterface dialog, int id) {
	                   }
	               })
	               .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
	                   public void onClick(DialogInterface dialog, int id) {
	                   }
	               });
	        // Create the AlertDialog object and return it
	        return builder.create();
	    }
	}
}
