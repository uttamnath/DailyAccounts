package com.example.personalaccount;

import java.util.Locale;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Set_password extends Activity{
	Button btSet;
	EditText EdtPass,rEpass;
	
	SQLiteDatabase DB;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.create_password);
		btSet=(Button)findViewById(R.id.btCreate);
		EdtPass=(EditText)findViewById(R.id.SetPass);
		rEpass=(EditText)findViewById(R.id.rSetPass);
		
		DB = this.openOrCreateDatabase("rAccount", SQLiteDatabase.CREATE_IF_NECESSARY, null);//CREATE DATABASE by openOrcreate method that return a object as database
		DB.setVersion(1);   //set data base version
		DB.setLocale(Locale.getDefault());//character set default
		DB.setLockingEnabled(true);// thread safe,multiple thread will not work
		//String sql1="create table if not exists INCOME(date varchar,source varchar,amount int); ";//create Income table
		String sql2="create table if not exists PASSWORD(pass varchar); ";//create password table
		//DB.execSQL(sql1);
		DB.execSQL(sql2);
		
		
		btSet.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				 String pass =EdtPass.getText().toString();
				 String rEpas =rEpass.getText().toString();
				 if(pass.equals(rEpas))
				 {
					 String sql3="insert into PASSWORD values('"+pass+"');";
					 DB.execSQL(sql3);
					 Toast t=Toast.makeText(getApplicationContext(), "Password Created Successfully", Toast.LENGTH_LONG);
				    	t.show(); 
				    	Intent go=new Intent(Set_password.this,MainActivity.class);
						startActivity(go);
				    	
				 }
				 else{
					 Toast t=Toast.makeText(getApplicationContext(), "Sorry,Try Again!", Toast.LENGTH_LONG);
				    	t.show();
				    	EdtPass.setText("");
				    	rEpass.setText("");
				 }
				 
				 
				
			}
		});
		
	}
	

}
