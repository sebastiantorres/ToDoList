package com.cursojava;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.cursojava.todolist.R;
public class todolistActivity extends Activity {
	private TareaDataSource datasource;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);
        datasource = new TareaDataSource(this);
        datasource.open();
       
    }
    
    public void showAddTarea(View view){
    	setContentView(R.layout.addtarea);
 
    }
    
    public void onClick(View view) {
    	Tarea tarea = null;
    	String titulo = "HOLA";//bundle.getString("etTitulo");
    	String descripcion ="HOLA"; // bundle.getString("etDescripcion");
    	String fechainicio = "HOLA";// bundle.getString("dpFechaInicio");
    	String fechafin  = "HOLA";// bundle.getString("dpFechaFin");
    	String prioridad ="HOLA";// bundle.getString("spPrioridad");
    	
		switch (view.getId()) {
				case R.id.ivAddTarea:
					Toast toast = Toast.makeText(this,"HOLA",100);
			    	toast.show();
			    //	tarea = datasource.createTarea(titulo, descripcion, fechainicio, fechafin, "1", prioridad);
			    	setContentView(R.layout.addtarea);

			    	break;
				case R.id.btnAceptar:
		    	//	ArrayAdapter<Tarea> adapter = (ArrayAdapter<Tarea>) getListAdapter();
		    
		    	datasource.createTarea(titulo, descripcion, fechainicio, fechafin, "1", prioridad);
		    	datasource.close();
		    	break;
				case R.id.btnCancelar:
			    	mostrarerror(this);
			    	break;
		}
    }
    public void mostrarerror(Context context){
    	Toast.makeText(context, "tarea cread", 100);
    	//R.id.ettitulo = "algo";
    }
}