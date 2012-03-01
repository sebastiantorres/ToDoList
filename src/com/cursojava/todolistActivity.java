package com.cursojava;

import java.util.List;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;



public class todolistActivity extends  ListActivity {
	private TareaDataSource datasource;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);
        datasource = new TareaDataSource(this);
        datasource.open();
        List<Tarea> values = datasource.getAllTareas();


		ArrayAdapter<Tarea> adapter = new ArrayAdapter<Tarea>(this,
				android.R.layout.simple_list_item_1, values);
		setListAdapter(adapter);
	
       
    }
    
   
    
    public void onClick(View view) {
    	@SuppressWarnings("unchecked")
		ArrayAdapter<Tarea> adapter = (ArrayAdapter<Tarea>) getListAdapter();
		Tarea tarea = null;
    	switch (view.getId()) {
				case R.id.ivAddTarea:
					Toast.makeText(this, "Tarea", 100).show();

					/*Intent intent=new Intent();
					intent.setClass(this,TareaAdd.class );
					startActivity(intent);*/
			    	break;
				case R.id.add:
					Intent intent=new Intent();
					intent.setClass(this,TareaAdd.class);
					startActivity(intent);
				    	break;
			   default: 
			    	Toast.makeText(this, "ENTRE", 100);
			    	break;
		}
    }
    
    @Override
	protected void onResume() {
		datasource.open();
		super.onResume();
	}

	@Override
	protected void onPause() {
		datasource.close();
		super.onPause();
	}
}