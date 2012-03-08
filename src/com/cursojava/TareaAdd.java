package com.cursojava;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class TareaAdd extends Activity {
	private TareaDataSource datasource;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.addtarea);
		datasource = new TareaDataSource(this);
	    datasource.open();
		
	}
	
	 
	    
	public void guardar(View botton){
	
		
		EditText titulo=(EditText)findViewById(R.id.ettitulo);
		EditText descripcion=(EditText)findViewById(R.id.etdescripcion);
		Spinner prioridad=(Spinner)findViewById(R.id.spprioridad);
		DatePicker desde=(DatePicker)findViewById(R.id.dpFechaInicio);
		DatePicker hasta=(DatePicker)findViewById(R.id.dpFechaFin);
		
		
		String stitulo = titulo.getText().toString();
		String sdescripcion = descripcion.getText().toString();
		String sprioridad = prioridad.getSelectedItem().toString();
		String sdesde = desde.toString(); // desde.getDayOfMonth()+'/'+ desde.getMonth()+'/'+desde.getYear();
		String shasta = desde.toString(); // hasta.getDayOfMonth()+'/'+hasta.getMonth()+'/'+hasta.getYear();
		
		Tarea tarea = null;
		tarea = datasource.createTarea(stitulo, sdescripcion, sdesde, shasta,"0", sprioridad);

		Intent intent=new Intent();
		intent.setClass(this,Resultado.class);
		
		
	
		
		intent.putExtra("taskTitle", titulo.getText().toString());
		intent.putExtra("taskDescription", descripcion.getText().toString());
		intent.putExtra("taskPriority", prioridad.getSelectedItem().toString());
		intent.putExtra("taskDesde", desde.toString());
		intent.putExtra("taskHasta", hasta.toString());
		
		startActivity(intent);

		
	}
	
	public void finalizartask(View botton){
		Intent intent=new Intent();
		intent.setClass(this,Resultado.class);
		intent.putExtra("Cancel","Cancel");
		startActivity(intent);
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
