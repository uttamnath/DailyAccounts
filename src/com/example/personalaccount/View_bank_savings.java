package com.example.personalaccount;

import java.util.ArrayList;
import java.util.Locale;



import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class View_bank_savings extends Activity {

	SQLiteDatabase DB; 
	 TextView tv;
	 Button btSE;
	 ListView list;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.view_bank_savings);
		list=(ListView)findViewById(R.id.listV);
		DB=this.openOrCreateDatabase("rAccount", SQLiteDatabase.CREATE_IF_NECESSARY, null);//CREATE DATABASE by openOrcreate method that return a object as database
		DB.setVersion(1);   //set data base version
		DB.setLocale(Locale.getDefault());//character set default
		DB.setLockingEnabled(true);// thread safe,multiple thread will not work
		try{
			String dat,detl, res="",tot="";
			int am, total=0,i=1;
			Cursor c;
			ArrayList<String> arrayList = new ArrayList<String>();
			
			

		     String sql = "select *from SAVINGS ;";
			 c=DB.rawQuery(sql,null);
			c.moveToFirst();
			do
			{
				dat= c.getString(c.getColumnIndex("date"));
				detl=c.getString(c.getColumnIndex("source"));
				am=c.getInt(c.getColumnIndex("amount"));
				total+=am;
				res="Sl.No:"+String.valueOf(i)+"\nDate:"+dat+"\nSource:"+detl+"\nAmount:"+am;
				arrayList.add(res);
				// Toast t=Toast.makeText(getApplicationContext(), res, Toast.LENGTH_LONG);
			    //	t.show();
			  i++; 
			}while(c.moveToNext());
			tot="Total Income="+String.valueOf(total)+"Taka";
			arrayList.add(tot);
		   
	//tv.setText(res);
//	ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, R.layout.view_data,arrayList);
	//list.setAdapter(adapter);
	ArrayAdapter<String> adapter = new ArrayAdapter<String>(View_bank_savings.this,
             android.R.layout.simple_list_item_1, arrayList);
     list.setAdapter(adapter);
		}
		catch(Exception e)
		{
ArrayList<String> arrayList = new ArrayList<String>();
			
			arrayList.add("No Data Found ,Please insert data..");
			ArrayAdapter<String> adapter = new ArrayAdapter<String>(View_bank_savings.this,
		              android.R.layout.simple_list_item_1, arrayList);
		      list.setAdapter(adapter);
		}
				

	}
	@Override
   public boolean onCreateOptionsMenu(Menu menu)
   {
       MenuInflater menuInflater = getMenuInflater();
       menuInflater.inflate(R.menu.menu_bar, menu);
       return true;
   } 
	
	@Override
   public boolean onOptionsItemSelected(MenuItem item)
   {

       switch (item.getItemId())
       {
      // case R.id.menu_income:
       	//Toast.makeText(Home.this, "You Clicked Help", 3000).show(); 
          // return true;
       case R.id.iitem1:
       	Intent income=new Intent(View_bank_savings.this,Income.class);
			startActivity(income);
			 return true;
       case R.id.iitem2:
       	Intent ireport=new Intent(View_bank_savings.this,View_income.class);
			startActivity(ireport);
			 return true;
       case R.id.iitem3:
       	Intent Mreport=new Intent(View_bank_savings.this,M_report_Income.class);
			startActivity(Mreport);
			 return true;
			// case R.id.menu_Bank:
		       	//Toast.makeText(Home.this, "You Clicked Help", 3000).show(); 
		          // return true;
    case R.id.bitem1:
       	Intent saving=new Intent(View_bank_savings.this,Savings.class);
			startActivity(saving);
			 return true;
       case R.id.bitem2:
       	Intent ireport1=new Intent(View_bank_savings.this,View_bank_savings.class);
			startActivity(ireport1);
			 return true;
       case R.id.bitem3:
       	Intent Mreport1=new Intent(View_bank_savings.this,M_report_Income.class);
			startActivity(Mreport1);
			 return true;
       //case R.id.menu_expense:
          // Toast.makeText(Home.this, "You Clicked Help", 3000).show();
          // return true;
       case R.id.eitem1:
       	Intent exp=new Intent(View_bank_savings.this,Expense.class);
			startActivity(exp);
			 return true;
       case R.id.eitem2:
       	Intent ereport=new Intent(View_bank_savings.this,View_expense.class);
			startActivity(ereport);
           return true;
       case R.id.eitem3:
       	Intent eMreport=new Intent(View_bank_savings.this,M_report.class);
			startActivity(eMreport);
           return true;
       case R.id.menu_about:
       	Intent v=new Intent(View_bank_savings.this,About.class);
			startActivity(v);
			 return true;
      
       default:
       	 return super.onOptionsItemSelected(item);
       }
   }

}

