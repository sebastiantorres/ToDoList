package com.cursojava;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.cursojava.todolist.R;
public class todolistActivity extends Activity {
	private TareaDataSource datasource;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);
        datasource = new TareaDataSource(this);
        datasource.open();
        AdapterView<Tarea>  adapter =  new AdapterView<Tarea>(this) {
		};
        
        
    }
    
    public void showAddTarea(View view){
    	setContentView(R.layout.addtarea);
 
    }
    
    public void saveTarea(){
    //	
    	Bundle bundle = getIntent() .getExtras();
    	String titulo = bundle.getString("etTitulo");
    	String descripcion = bundle.getString("etDescripcion");
    	String fechainicio = bundle.getString("dpFechaInicio");
    	String fechafin  = bundle.getString("dpFechaFin");
    	String prioridad = bundle.getString("spPrioridad");
    	datasource.createTarea(titulo, descripcion, fechainicio, fechafin, '1', prioridad);
    }
}