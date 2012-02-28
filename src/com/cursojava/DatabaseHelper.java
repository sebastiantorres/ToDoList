package com.cursojava;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {
			public static final String DATABASE_NAME = 	"listadetareas.db";
			public static final int DATABASE_VERSION = 1;
			public static final String TABLE_NAME = "tarea";
			public static final String COLUMN_ID = "_id";
			public static final String COLUMN_TITULO = "titulo";
			public static final String COLUMN_DESCRIPCION = "descripcion";
			public static final String COLUMN_FECHAINICIO = "fechainicio";
			public static final String COLUMN_FECHAFIN = "fechafin";
			public static final String COLUMN_ESTADO = "estado";
			public static final String COLUMN_PRIORIDAD= "prioridad";
			
			// String para crear la tabla 
			private static final String DATABASE_CREATE = "CREATE TABLE "
					+ TABLE_NAME + "( " + COLUMN_ID
					+ " INTEGER PRIMARY KEY AUTOINCREMENT, " 
					+ COLUMN_TITULO + " text not null,"
					+ COLUMN_DESCRIPCION + " text not null,"
					+ COLUMN_FECHAINICIO + " text not null,"
					+ COLUMN_FECHAFIN    + " text not null,"
					+ COLUMN_ESTADO		 + " text,"
					+ COLUMN_PRIORIDAD 	 + " text"
					+ ");";

			// Constructor de la clase	
			public DatabaseHelper(Context  context){
				super(context, DATABASE_NAME, null,1);
			}
			
			//Metodo sobreescrito
			public void onCreate(SQLiteDatabase db){
				db.execSQL(DATABASE_CREATE);
			}
		    
			//Metodo sobreescrito
			public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
				Log.w(DatabaseHelper.class.getName(),"Actualizando la base de datos a la version " + newVersion 
						+ ", se perderan todo los datos");
				db.execSQL("DROP TABLE IF EXIST " + TABLE_NAME);
				onCreate(db);
			}

}
