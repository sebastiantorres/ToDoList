package com.cursojava;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

public class TareaAdd extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.addtarea);
	}
	
	 public void onClick(View view) {
	    	
	    	switch (view.getId()) {
					case R.id.btnAceptar:
						guardar();
				    	break;
	    	}
					
	    }
	    
	public void guardar(){
		EditText titulo=(EditText)findViewById(R.id.ettitulo);
		EditText descripcion=(EditText)findViewById(R.id.etdescripcion);
		Spinner prioridad=(Spinner)findViewById(R.id.spprioridad);
	//	DatePicker desde=(DatePicker)findViewById(R.id.dpFechaInicio);
	//	DatePicker hasta=(DatePicker)findViewById(R.id.dpFechaFin);
		
		
		
		
		String stitulo = titulo.getText().toString();
		String sdescripcion = descripcion.getText().toString();
		String sprioridad = prioridad.getSelectedItem().toString();
		String sdesde = "01/01/1900" ;// desde.getDayOfMonth()+'/'+ desde.getMonth()+'/'+desde.getYear();
		String shasta = "01/01/1900" ;// hasta.getDayOfMonth()+'/'+hasta.getMonth()+'/'+hasta.getYear();
		TareaDataSource dbtarea = new TareaDataSource(this);
		Tarea tarea =dbtarea.createTarea(stitulo, sdescripcion, sdesde, shasta, "0", sprioridad);
		Intent intent=new Intent();
		intent.setClass(this,todolistActivity.class);
		startActivity(intent);
		
	}
}
