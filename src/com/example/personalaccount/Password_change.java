package com.example.personalaccount;

import java.util.Locale;

import android.app.Activity;
import android.content.ContextWrapper;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Password_change extends Activity {
	EditText nps,ops;//new=n,old=o,password=ps
	Button btcng,del;
	SQLiteDatabase DB;
	String ne,old,p=null;
	Cursor c;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);		
	setContentView(R.layout.change_password);
	nps=(EditText)findViewById(R.id.n_pass);
	ops=(EditText)findViewById(R.id.o_pass);
	btcng=(Button)findViewById(R.id.buttonChange);
	del=(Button)findViewById(R.id.buttonDrop);
	
	DB = this.openOrCreateDatabase("rAccount", SQLiteDatabase.CREATE_IF_NECESSARY, null);//CREATE DATABASE by openOrcreate method that return a object as database
	DB.setVersion(1);   //set data base version
	DB.setLocale(Locale.getDefault());//character set default
	DB.setLockingEnabled(true);// thread safe,multiple thread will not work
	
	btcng.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			try{
			// TODO Auto-generated method stub
			ne=nps.getText().toString();
			old=ops.getText().toString();
			String sql = "select *from PASSWORD;";
			 c=DB.rawQuery(sql,null);
			c.moveToFirst();
			 p= c.getString(c.getColumnIndex("pass"));
			 
			if(old.equals(p)){
				
				 String sql3="UPDATE PASSWORD SET pass='"+ ne +"' ";
				 
				 c=DB.rawQuery(sql3,null);
					c.moveToFirst();
					Toast t=Toast.makeText(getApplicationContext(), "Password has been Changed Successfully!", Toast.LENGTH_LONG);
			    	t.show();
				 
				 Intent go=new Intent(Password_change.this,MainActivity.class);
					startActivity(go);
			}
			else
			{
				Toast t=Toast.makeText(getApplicationContext(), "Sorry,Try Again!", Toast.LENGTH_LONG);
		    	t.show();
		    	nps.setText("");
		    	ops.setText("");
			}
			}
			catch(Exception e){
				Toast t=Toast.makeText(getApplicationContext(), "Please Create Password ,First", Toast.LENGTH_LONG);
		    	t.show();
			}
			
		}
	});
	del.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			ContextWrapper context;
			// TODO Auto-generated method stub
			try{
				String sqlI="DROP TABLE INCOME ;";
				 DB.execSQL(sqlI);
				 String sqlE="DROP TABLE EXPENSE ;";
				 DB.execSQL(sqlE);
				 String sqlP="DROP TABLE PASSWORD ;";
				 DB.execSQL(sqlP);
				 Toast t=Toast.makeText(getApplicationContext(), "All data are Delated! You have lost your Data Parmanently.", Toast.LENGTH_LONG);
			    	t.show();
			    	 Intent goC=new Intent(Password_change.this,Set_password.class);
						startActivity(goC);
			}
			catch(Exception e){
				Toast t=Toast.makeText(getApplicationContext(), "Try Again", Toast.LENGTH_LONG);
		    	t.show();
		    	 Intent goM=new Intent(Password_change.this,MainActivity.class);
					startActivity(goM);
			}
			 
			
		}
	});
	



	
	
	


	}


	

}
