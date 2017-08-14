package com.example.personalaccount;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;


import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class M_report_Income extends Activity{
	Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12;
	String from="",to="";
	 ListView MrList;
	 SQLiteDatabase DB;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.monthly_report);
		initial();
		final String system_yyyy =new SimpleDateFormat("yyyy").format(Calendar.getInstance().getTime());
		//final String system_mm =new SimpleDateFormat("MM").format(Calendar.getInstance().getTime());
		
		DB=this.openOrCreateDatabase("rAccount", SQLiteDatabase.CREATE_IF_NECESSARY, null);//CREATE DATABASE by openOrcreate method that return a object as database
		DB.setVersion(1);   //set data base version
		DB.setLocale(Locale.getDefault());//character set default
		DB.setLockingEnabled(true);// thread safe,multiple thread will not work
		
		b1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				from=system_yyyy+"-01-01";//(yyyy-mm-dd)
				to=system_yyyy+"-01-31";
				try{
					String dat,detl, res="" ,tot="";
					int am, i=1;
					long total=0;
					Cursor c;
					ArrayList<String> arrayList = new ArrayList<String>();
					
					

				     String sql = "select *from INCOME where date BETWEEN '"+ from + "' AND '" + to + "';";
				     //"SELECT * FROM expenses WHERE date BETWEEN '"+ start + "' AND '" + end + "'"
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
						
					  i++; 
					}while(c.moveToNext());
					tot="Total Income="+String.valueOf(total)+"Taka";
					arrayList.add(tot);
					
		
			ArrayAdapter<String> adapter = new ArrayAdapter<String>(M_report_Income.this,
		              android.R.layout.simple_list_item_1, arrayList);
		      MrList.setAdapter(adapter);
				}
				catch(Exception e){
					ArrayList<String> arrayList = new ArrayList<String>();
					
					arrayList.add("No Data Found for this month in this year, for previous year's data see view total report.");
					ArrayAdapter<String> adapter = new ArrayAdapter<String>(M_report_Income.this,
				              android.R.layout.simple_list_item_1, arrayList);
				      MrList.setAdapter(adapter);
					
					
				}
				
				
				
			}

			
		});
    b2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				from=system_yyyy+"-02-01";
				to=system_yyyy+"-02-31";
				
				
				try{
					String dat,detl, res="" ,tot="";
					int am,i=1;
					long total=0;
					Cursor c;
					ArrayList<String> arrayList = new ArrayList<String>();
					
					

				     String sql = "select *from INCOME where date BETWEEN '"+ from + "' AND '" + to + "';";
				     //"SELECT * FROM expenses WHERE date BETWEEN '"+ start + "' AND '" + end + "'"
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
						
					  i++; 
					}while(c.moveToNext());
					tot="Total Income="+String.valueOf(total)+"Taka";
					arrayList.add(tot);
					
		
			ArrayAdapter<String> adapter = new ArrayAdapter<String>(M_report_Income.this,
		              android.R.layout.simple_list_item_1, arrayList);
		      MrList.setAdapter(adapter);
				}
				catch(Exception e){
					ArrayList<String> arrayList = new ArrayList<String>();
					
					arrayList.add("No Data Found for this month in this year, for previous year's data see view total report.");
					ArrayAdapter<String> adapter = new ArrayAdapter<String>(M_report_Income.this,
				              android.R.layout.simple_list_item_1, arrayList);
				      MrList.setAdapter(adapter);
					
					
				}
			}
		});
    b3.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			from=system_yyyy+"-03-01";
			to=system_yyyy+"-03-31";
			try{
				String dat,detl, res="" ,tot="";
				int am, i=1;
				long total=0;
				Cursor c;
				ArrayList<String> arrayList = new ArrayList<String>();
				
				

			     String sql = "select *from INCOME where date BETWEEN '"+ from + "' AND '" + to + "';";
			     //"SELECT * FROM expenses WHERE date BETWEEN '"+ start + "' AND '" + end + "'"
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
					
				  i++; 
				}while(c.moveToNext());
				tot="Total Income="+String.valueOf(total)+"Taka";
				arrayList.add(tot);
				
	
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(M_report_Income.this,
	              android.R.layout.simple_list_item_1, arrayList);
	      MrList.setAdapter(adapter);
			}
			catch(Exception e){
				ArrayList<String> arrayList = new ArrayList<String>();
				
				arrayList.add("No Data Found for this month in this year, for previous year's data see view total report.");
				ArrayAdapter<String> adapter = new ArrayAdapter<String>(M_report_Income.this,
			              android.R.layout.simple_list_item_1, arrayList);
			      MrList.setAdapter(adapter);
				
			}
		}
	});
    b4.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			from=system_yyyy+"-04-01";
			to=system_yyyy+"-04-31";
			try{
				String dat,detl, res="" ,tot="";
				int am, i=1;
				long total=0;
				Cursor c;
				ArrayList<String> arrayList = new ArrayList<String>();
				
				

			     String sql = "select *from INCOME where date BETWEEN '"+ from + "' AND '" + to + "';";
			     //"SELECT * FROM expenses WHERE date BETWEEN '"+ start + "' AND '" + end + "'"
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
					
				  i++; 
				}while(c.moveToNext());
				tot="Total Income="+String.valueOf(total)+"Taka";
				arrayList.add(tot);
				
	
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(M_report_Income.this,
	              android.R.layout.simple_list_item_1, arrayList);
	      MrList.setAdapter(adapter);
			}
			catch(Exception e){
				ArrayList<String> arrayList = new ArrayList<String>();
				
				arrayList.add("No Data Found for this month in this year, for previous year's data see view total report.");
				ArrayAdapter<String> adapter = new ArrayAdapter<String>(M_report_Income.this,
			              android.R.layout.simple_list_item_1, arrayList);
			      MrList.setAdapter(adapter);
				
				
			}
		}
	});
    b5.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			from=system_yyyy+"-05-01";
			to=system_yyyy+"-05-31";
			try{
				String dat,detl, res="" ,tot="";
				int am,i=1;
				long total=0;
				Cursor c;
				ArrayList<String> arrayList = new ArrayList<String>();
				
				

			     String sql = "select *from INCOME where date BETWEEN '"+ from + "' AND '" + to + "';";
			     //"SELECT * FROM expenses WHERE date BETWEEN '"+ start + "' AND '" + end + "'"
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
					
				  i++; 
				}while(c.moveToNext());
				tot="Total Income="+String.valueOf(total)+"Taka";
				arrayList.add(tot);
				
	
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(M_report_Income.this,
	              android.R.layout.simple_list_item_1, arrayList);
	      MrList.setAdapter(adapter);
			}
			catch(Exception e){
				ArrayList<String> arrayList = new ArrayList<String>();
				
				arrayList.add("No Data Found for this month in this year, for previous year's data see view total report.");
				ArrayAdapter<String> adapter = new ArrayAdapter<String>(M_report_Income.this,
			              android.R.layout.simple_list_item_1, arrayList);
			      MrList.setAdapter(adapter);
				
				
			}
		}
	});
    b6.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			from=system_yyyy+"-06-01";
			to=system_yyyy+"-06-31";
			try{
				String dat,detl, res="" ,tot="";
				int am,i=1;
				long total=0;
				Cursor c;
				ArrayList<String> arrayList = new ArrayList<String>();
				
				

			     String sql = "select *from INCOME where date BETWEEN '"+ from + "' AND '" + to + "';";
			     //"SELECT * FROM expenses WHERE date BETWEEN '"+ start + "' AND '" + end + "'"
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
					
				  i++; 
				}while(c.moveToNext());
				tot="Total Income="+String.valueOf(total)+"Taka";
				arrayList.add(tot);
				
	
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(M_report_Income.this,
	              android.R.layout.simple_list_item_1, arrayList);
	      MrList.setAdapter(adapter);
			}
			catch(Exception e){
				ArrayList<String> arrayList = new ArrayList<String>();
				
				arrayList.add("No Data Found for this month in this year, for previous year's data see view total report.");
				ArrayAdapter<String> adapter = new ArrayAdapter<String>(M_report_Income.this,
			              android.R.layout.simple_list_item_1, arrayList);
			      MrList.setAdapter(adapter);
				
				
			}
		}
	});
    b7.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			from=system_yyyy+"-07-01";
			to=system_yyyy+"-07-31";
			try{
				String dat,detl, res="" ,tot="";
				int am, i=1;
				long total=0;
				Cursor c;
				ArrayList<String> arrayList = new ArrayList<String>();
				
				

			     String sql = "select *from INCOME where date BETWEEN '"+ from + "' AND '" + to + "';";
			     //"SELECT * FROM expenses WHERE date BETWEEN '"+ start + "' AND '" + end + "'"
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
					
				  i++; 
				}while(c.moveToNext());
				tot="Total Income="+String.valueOf(total)+"Taka";
				arrayList.add(tot);
				
	
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(M_report_Income.this,
	              android.R.layout.simple_list_item_1, arrayList);
	      MrList.setAdapter(adapter);
			}
			catch(Exception e){
				ArrayList<String> arrayList = new ArrayList<String>();
				
				arrayList.add("No Data Found for this month in this year, for previous year's data see view total report.");
				ArrayAdapter<String> adapter = new ArrayAdapter<String>(M_report_Income.this,
			              android.R.layout.simple_list_item_1, arrayList);
			      MrList.setAdapter(adapter);
				
				
			}
		}
	});
    b8.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			from=system_yyyy+"-08-01";
			to=system_yyyy+"-08-31";
			try{
				String dat,detl, res="" ,tot="";
				int am,i=1;
				long total=0;
				Cursor c;
				ArrayList<String> arrayList = new ArrayList<String>();
				
				

			     String sql = "select *from INCOME where date BETWEEN '"+ from + "' AND '" + to + "';";
			     //"SELECT * FROM expenses WHERE date BETWEEN '"+ start + "' AND '" + end + "'"
				 c=DB.rawQuery(sql,null);
				c.moveToFirst();
				do
				{
					dat= c.getString(c.getColumnIndex("date"));
					detl=c.getString(c.getColumnIndex("source"));
					am=c.getInt(c.getColumnIndex("amount"));
					total+=am;
					res="Sl.No:"+String.valueOf(i)+"\nDate:"+dat+"\nsource:"+detl+"\nAmount:"+am;
					arrayList.add(res);
					
				  i++; 
				}while(c.moveToNext());
				tot="Total Income="+String.valueOf(total)+"Taka";
				arrayList.add(tot);
				
	
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(M_report_Income.this,
	              android.R.layout.simple_list_item_1, arrayList);
	      MrList.setAdapter(adapter);
			}
			catch(Exception e){
				ArrayList<String> arrayList = new ArrayList<String>();
				
				arrayList.add("No Data Found for this month in this year, for previous year's data see view total report.");
				ArrayAdapter<String> adapter = new ArrayAdapter<String>(M_report_Income.this,
			              android.R.layout.simple_list_item_1, arrayList);
			      MrList.setAdapter(adapter);
				
				
			}
		}
	});
    b9.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			from=system_yyyy+"-09-01";
			to=system_yyyy+"-09-31";
			try{
				String dat,detl, res="" ,tot="";
				int am,i=1;
				long total=0;
				Cursor c;
				ArrayList<String> arrayList = new ArrayList<String>();
				
				

			     String sql = "select *from INCOME where date BETWEEN '"+ from + "' AND '" + to + "';";
			     //"SELECT * FROM expenses WHERE date BETWEEN '"+ start + "' AND '" + end + "'"
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
					
				  i++; 
				}while(c.moveToNext());
				tot="Total Income="+String.valueOf(total)+"Taka";
				arrayList.add(tot);
				
	
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(M_report_Income.this,
	              android.R.layout.simple_list_item_1, arrayList);
	      MrList.setAdapter(adapter);
			}
			catch(Exception e){
				ArrayList<String> arrayList = new ArrayList<String>();
				
				arrayList.add("No Data Found for this month in this year, for previous year's data see view total report.");
				ArrayAdapter<String> adapter = new ArrayAdapter<String>(M_report_Income.this,
			              android.R.layout.simple_list_item_1, arrayList);
			      MrList.setAdapter(adapter);
				
				
			}
		}
	});
    b10.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			from=system_yyyy+"-10-01";
			to=system_yyyy+"-10-31";
			try{
				String dat,detl, res="" ,tot="";
				int am,i=1;
				long total=0;
				Cursor c;
				ArrayList<String> arrayList = new ArrayList<String>();
				
				

			     String sql = "select *from INCOME where date BETWEEN '"+ from + "' AND '" + to + "';";
			     //"SELECT * FROM expenses WHERE date BETWEEN '"+ start + "' AND '" + end + "'"
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
					
				  i++; 
				}while(c.moveToNext());
				tot="Total Income="+String.valueOf(total)+"Taka";
				arrayList.add(tot);
				
	
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(M_report_Income.this,
	              android.R.layout.simple_list_item_1, arrayList);
	      MrList.setAdapter(adapter);
			}
			catch(Exception e){
				ArrayList<String> arrayList = new ArrayList<String>();
				
				arrayList.add("No Data Found for this month in this year, for previous year's data see view total report.");
				ArrayAdapter<String> adapter = new ArrayAdapter<String>(M_report_Income.this,
			              android.R.layout.simple_list_item_1, arrayList);
			      MrList.setAdapter(adapter);
				
				
			}
		}
	});
    b11.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			from=system_yyyy+"-11-01";
			to=system_yyyy+"-11-31";
			try{
				String dat,detl, res="" ,tot="";
				int am, i=1;
				long total=0;
				Cursor c;
				ArrayList<String> arrayList = new ArrayList<String>();
				
				

			     String sql = "select *from INCOME where date BETWEEN '"+ from + "' AND '" + to + "';";
			     //"SELECT * FROM expenses WHERE date BETWEEN '"+ start + "' AND '" + end + "'"
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
					
				  i++; 
				}while(c.moveToNext());
				tot="Total Income="+String.valueOf(total)+"Taka";
				arrayList.add(tot);
				
	
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(M_report_Income.this,
	              android.R.layout.simple_list_item_1, arrayList);
	      MrList.setAdapter(adapter);
			}
			catch(Exception e){
				ArrayList<String> arrayList = new ArrayList<String>();
				
				arrayList.add("No Data Found for this month in this year, for previous year's data see view total report.");
				ArrayAdapter<String> adapter = new ArrayAdapter<String>(M_report_Income.this,
			              android.R.layout.simple_list_item_1, arrayList);
			      MrList.setAdapter(adapter);
				
				
			}
		}
	});
    b12.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			from=system_yyyy+"-12-01";
			to=system_yyyy+"-12-31";
			try{
				String dat,detl, res="" ,tot="";
				int am, i=1;
				long total=0;
				Cursor c;
				ArrayList<String> arrayList = new ArrayList<String>();
				
				

			     String sql = "select *from INCOME where date BETWEEN '"+ from + "' AND '" + to + "';";
			     //"SELECT * FROM expenses WHERE date BETWEEN '"+ start + "' AND '" + end + "'"
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
					
				  i++; 
				}while(c.moveToNext());
				tot="Total Income="+String.valueOf(total)+"Taka";
				arrayList.add(tot);
				
	
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(M_report_Income.this,
	              android.R.layout.simple_list_item_1, arrayList);
	      MrList.setAdapter(adapter);
			}
			catch(Exception e){
				ArrayList<String> arrayList = new ArrayList<String>();
				
				arrayList.add("No Data Found for this month in this year, for previous year's data see view total report.");
				ArrayAdapter<String> adapter = new ArrayAdapter<String>(M_report_Income.this,
			              android.R.layout.simple_list_item_1, arrayList);
			      MrList.setAdapter(adapter);
				
			}
		}
	});
	}
    
	private void initial() {
		// TODO Auto-generated method stub
		b1=(Button)findViewById(R.id.button1);
		b2=(Button)findViewById(R.id.button2);
		b3=(Button)findViewById(R.id.button3);
		b4=(Button)findViewById(R.id.button4);
		b5=(Button)findViewById(R.id.button5);
		b6=(Button)findViewById(R.id.button6);
		b7=(Button)findViewById(R.id.button7);
		b8=(Button)findViewById(R.id.button8);
		b9=(Button)findViewById(R.id.button9);
		b10=(Button)findViewById(R.id.button10);
		b11=(Button)findViewById(R.id.button11);
		b12=(Button)findViewById(R.id.button12);
		MrList=(ListView)findViewById(R.id.listViewM);
		
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
        	Intent income=new Intent(M_report_Income.this,Income.class);
			startActivity(income);
			 return true;
        case R.id.iitem2:
        	Intent ireport=new Intent(M_report_Income.this,View_income.class);
			startActivity(ireport);
			 return true;
        case R.id.iitem3:
        	Intent Mreport=new Intent(M_report_Income.this,M_report_Income.class);
			startActivity(Mreport);
			 return true;
			// case R.id.menu_Bank:
		       	//Toast.makeText(Home.this, "You Clicked Help", 3000).show(); 
		          // return true;
case R.id.bitem1:
 	Intent saving=new Intent(M_report_Income.this,Savings.class);
			startActivity(saving);
			 return true;
 case R.id.bitem2:
 	Intent ireport1=new Intent(M_report_Income.this,View_bank_savings.class);
			startActivity(ireport1);
			 return true;
 case R.id.bitem3:
 	Intent Mreport1=new Intent(M_report_Income.this,M_report_Income.class);
			startActivity(Mreport1);
			 return true;
        //case R.id.menu_expense:
           // Toast.makeText(Home.this, "You Clicked Help", 3000).show();
           // return true;
        case R.id.eitem1:
        	Intent exp=new Intent(M_report_Income.this,Expense.class);
			startActivity(exp);
			 return true;
        case R.id.eitem2:
        	Intent ereport=new Intent(M_report_Income.this,View_expense.class);
			startActivity(ereport);
            return true;
        case R.id.eitem3:
        	Intent eMreport=new Intent(M_report_Income.this,M_report.class);
			startActivity(eMreport);
            return true;
        case R.id.menu_about:
        	Intent v=new Intent(M_report_Income.this,About.class);
			startActivity(v);
			 return true;
       
        default:
        	 return super.onOptionsItemSelected(item);
        }
    }


}
