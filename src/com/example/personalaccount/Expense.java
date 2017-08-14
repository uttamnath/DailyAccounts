package com.example.personalaccount;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;



import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Expense extends Activity {
	 EditText detl,amtE,RamtE;
	 Button btSe;
	 SQLiteDatabase DB;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.expense);
		ini();
		//database 
		
				DB=this.openOrCreateDatabase("rAccount", SQLiteDatabase.CREATE_IF_NECESSARY, null);//CREATE DATABASE by openOrcreate method that return a object as database
				DB.setVersion(1);   //set data base version
				DB.setLocale(Locale.getDefault());//character set default
				DB.setLockingEnabled(true);// thread safe,multiple thread will not work
				//String sql1="create table if not exists INCOME(date varchar,source varchar,amount int); ";//create Income table
				String sql2="create table if not exists EXPENSE(date varchar,details varchar,amount int); ";//create Expense table
				//DB.execSQL(sql1);
				DB.execSQL(sql2);
				
				
				
				//database
				btSe.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						String system_dd,system_mm,system_yyyy,Date,Details;
						int Amount,Ramount;
						 system_dd =new SimpleDateFormat("dd").format(Calendar.getInstance().getTime());//Retrieve date ,month,year from system
						 system_mm =new SimpleDateFormat("MM").format(Calendar.getInstance().getTime());
						 system_yyyy =new SimpleDateFormat("yyyy").format(Calendar.getInstance().getTime());
						 Date=system_yyyy+"-"+system_mm+"-"+system_dd;
						 Details=detl.getText().toString();
						 Amount=Integer.parseInt(amtE.getText().toString());
						 Ramount=Integer.parseInt(RamtE.getText().toString());
						 if(Amount==Ramount)
						 {
						 String sql3="insert into EXPENSE values('"+Date+"','"+Details+"',"+Amount+");";
						 DB.execSQL(sql3);
						 Toast t=Toast.makeText(getApplicationContext(), "Save successfully,please insert another one!", Toast.LENGTH_LONG);
					    	t.show();
						 
					    detl.setText("");
					    amtE.setText("");
					    RamtE.setText("");
					    
						 }
						 else{
							 Toast t=Toast.makeText(getApplicationContext(), "Sorry! Mismatch Amount,Please Try Again.", Toast.LENGTH_LONG);
						    	t.show();
						    	 
						 }
						
					}
				});
				
				
			}
	

	


	private void ini() {
		// TODO Auto-generated method stub
		detl=(EditText)findViewById(R.id.etdetailsE);
		amtE=(EditText)findViewById(R.id.etAmountE);
		RamtE=(EditText)findViewById(R.id.RamtE);
		btSe=(Button)findViewById(R.id.btsaveE); 

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
        	Intent income=new Intent(Expense.this,Income.class);
			startActivity(income);
			 return true;
        case R.id.iitem2:
        	Intent ireport=new Intent(Expense.this,View_income.class);
			startActivity(ireport);
			 return true;
        case R.id.iitem3:
        	Intent Mreport=new Intent(Expense.this,M_report_Income.class);
			startActivity(Mreport);
			 return true;
			// case R.id.menu_Bank:
		       	//Toast.makeText(Home.this, "You Clicked Help", 3000).show(); 
		          // return true;
 case R.id.bitem1:
    	Intent saving=new Intent(Expense.this,Savings.class);
			startActivity(saving);
			 return true;
    case R.id.bitem2:
    	Intent ireport1=new Intent(Expense.this,View_bank_savings.class);
			startActivity(ireport1);
			 return true;
    case R.id.bitem3:
    	Intent Mreport1=new Intent(Expense.this,M_report_Income.class);
			startActivity(Mreport1);
			 return true;
    //case R.id.menu_expense:
       // Toast.makeText(Home.this, "You Clicked Help", 3000).show();
       // return true;
        //case R.id.menu_expense:
           // Toast.makeText(Home.this, "You Clicked Help", 3000).show();
           // return true;
        case R.id.eitem1:
        	Intent exp=new Intent(Expense.this,Expense.class);
			startActivity(exp);
			 return true;
        case R.id.eitem2:
        	Intent ereport=new Intent(Expense.this,View_expense.class);
			startActivity(ereport);
            return true;
        case R.id.eitem3:
        	Intent eMreport=new Intent(Expense.this,M_report.class);
			startActivity(eMreport);
            return true;
        case R.id.menu_about:
        	Intent v=new Intent(Expense.this,About.class);
			startActivity(v);
			 return true;
       
        default:
        	 return super.onOptionsItemSelected(item);
        }
    }

	

}
