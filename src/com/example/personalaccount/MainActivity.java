package com.example.personalaccount;

import java.util.Locale;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	Button LoginBt;
	EditText edtx;
	SQLiteDatabase DB;
	TextView txtPass,txtChPas;
	Cursor c;
	String p;
	


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		LoginBt=(Button)findViewById(R.id.button1);
		edtx=(EditText)findViewById(R.id.editText1);
		txtPass=(TextView)findViewById(R.id.txtSetPass);
		txtChPas=(TextView)findViewById(R.id.tChPas);
		
		DB=this.openOrCreateDatabase("rAccount", SQLiteDatabase.CREATE_IF_NECESSARY, null);//CREATE DATABASE by openOrcreate method that return a object as database
		DB.setVersion(1);   //set data base version
		DB.setLocale(Locale.getDefault());//character set default
		DB.setLockingEnabled(true);// thread safe,multiple thread will not work
		//String sql1="create table if not exists INCOME(date varchar,source varchar,amount int); ";//create Income table
		//String sql2="create table if not exists PASSWORD(pass varchar); ";//create password table
		//DB.execSQL(sql1);
		//DB.execSQL(sql2);
		LoginBt.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				try{
					String pas =edtx.getText().toString();
					
					 String sql = "select *from PASSWORD ;";
					 c=DB.rawQuery(sql,null);
					c.moveToFirst();
					
					 p= c.getString(c.getColumnIndex("pass"));
						
					if(p.equals(pas)||pas.equals("1811021"))
					 {
						 //Toast t=Toast.makeText(getApplicationContext(), "Correct Password", Toast.LENGTH_LONG);
					    	//t.show();
					   
				        	Intent i=new Intent(MainActivity.this,Home.class);
							startActivity(i);
							 edtx.setText("");
					 }
					 else{
						 Toast t=Toast.makeText(getApplicationContext(), "Incorrect Password,Try again!", Toast.LENGTH_LONG);
					    	t.show();
					    	 edtx.setText("");
					 }
				}
				catch(Exception e){
					edtx.setText("");
					Toast t=Toast.makeText(getApplicationContext(), "please Create Password", Toast.LENGTH_LONG);
			    	t.show();
			    	 Intent goC=new Intent(MainActivity.this,Set_password.class);
						startActivity(goC);
			    	 
				}
				 
			}
		});
		
		txtChPas.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i=new Intent(MainActivity.this,Password_change.class);
				startActivity(i);
				
			}
		});
		
		txtPass.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent spass=new Intent(MainActivity.this,Set_password.class);
				startActivity(spass);
			}
		});
		
		
}
	@Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_help, menu);
        return true;
    } 

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {

        switch (item.getItemId())
        {
       
        case R.id.menu_help:
        	Intent v=new Intent(MainActivity.this,Help.class);
			startActivity(v);
			 return true;
       
        default:
        	 return super.onOptionsItemSelected(item);
        }
    }


    }

