package com.cursojava;

import java.util.List;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Path.FillType;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;



public class todolistActivity extends  ListActivity {
	private TareaDataSource datasource;
	private long pos;
	private Cursor cursor;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list);

		datasource = new TareaDataSource(this);
		datasource.open();
		//fillData();
		
		
		List<Tarea> values = datasource.getAllTareas();

		
		ArrayAdapter<Tarea> adapter = new ArrayAdapter<Tarea>(this,
				android.R.layout.simple_list_item_1, values);
		setListAdapter(adapter);
		
		ListView lv=getListView();
		lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
		    @Override
		    public void onItemClick(AdapterView<?> av, View v, int pos, long id) {
		        onListItemClick(v,pos,id);
		    }
		});
		
		
		
	}
    
	protected void onListItemClick(View v, int pos, long id) {
		this.pos=id;
		
	}
    public void onClick(View view) {  
    	@SuppressWarnings("unchecked")
		ArrayAdapter<Tarea> adapter = (ArrayAdapter<Tarea>) getListAdapter();
		Tarea tarea = null;
    	switch (view.getId()) {		
				case R.id.ivAddTarea:
					Intent intent=new Intent();
					intent.setClass(this,TareaAdd.class);
					startActivity(intent);
				    	break;		
				case R.id.delete:
					if (getListAdapter().getCount() > 0) {
						tarea = (Tarea) getListAdapter().getItem((int)pos);
						Toast.makeText(this, "Se elimino la tarea " + tarea.getTitulo() , 10).show();
						datasource.deleteTarea(tarea);
						adapter.remove(tarea);
						//fillData();
					}
					break;
				}
				adapter.notifyDataSetChanged();    	
	 }
    
    private void fillData() {
 		cursor = datasource.fetchAllTareas();
 		startManagingCursor(cursor);
 
 		String[] from = new String[] { DatabaseHelper.COLUMN_TITULO };
 		int[] to = new int[] { R.id.label };
 
 		SimpleCursorAdapter notes = new SimpleCursorAdapter(this,
 				R.layout.row, cursor, from, to);
 		setListAdapter(notes);
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