package com.cursojava;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Resultado extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.resulttarea);
		TextView resul=(TextView)findViewById(R.id.resultado);
		Bundle bundle=getIntent().getExtras();
		
		if(bundle.getString("Cancel")!=null){
			resul.setText("Operacion Cancelada");
		}
		else{
			
			resul.setText("Operacion Exitosa");
		}
		
	}
	
	public void listo(View botton){
		Intent intent=new Intent();
		intent.setClass(this,todolistActivity.class);
		startActivity(intent);
	}
}
