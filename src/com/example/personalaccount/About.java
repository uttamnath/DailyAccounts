package com.example.personalaccount;


import com.example.personalaccount.R;

import com.example.personalaccount.R.id;
import com.example.personalaccount.R.layout;
import com.example.personalaccount.R.menu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class About extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.about);
		
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
        	Intent income=new Intent(About.this,Income.class);
			startActivity(income);
			 return true;
        case R.id.iitem2:
        	Intent ireport=new Intent(About.this,View_income.class);
			startActivity(ireport);
			 return true;
        case R.id.iitem3:
        	Intent Mreport=new Intent(About.this,M_report_Income.class);
			startActivity(Mreport);
			 return true;
			// case R.id.menu_Bank:
		       	//Toast.makeText(Home.this, "You Clicked Help", 3000).show(); 
		          // return true;
 case R.id.bitem1:
    	Intent saving=new Intent(About.this,Savings.class);
			startActivity(saving);
			 return true;
    case R.id.bitem2:
    	Intent ireport1=new Intent(About.this,View_bank_savings.class);
			startActivity(ireport1);
			 return true;
    case R.id.bitem3:
    	Intent Mreport1=new Intent(About.this,M_report_Income.class);
			startActivity(Mreport1);
			 return true;
    //case R.id.menu_expense:
       // Toast.makeText(Home.this, "You Clicked Help", 3000).show();
       // return true;
        //case R.id.menu_expense:
           // Toast.makeText(Home.this, "You Clicked Help", 3000).show();
           // return true;
        case R.id.eitem1:
        	Intent exp=new Intent(About.this,Expense.class);
			startActivity(exp);
			 return true;
        case R.id.eitem2:
        	Intent ereport=new Intent(About.this,View_expense.class);
			startActivity(ereport);
            return true;
        case R.id.eitem3:
        	Intent eMreport=new Intent(About.this,M_report.class);
			startActivity(eMreport);
            return true;
        case R.id.menu_about:
        	Intent v=new Intent(About.this,About.class);
			startActivity(v);
			 return true;
       
        default:
        	 return super.onOptionsItemSelected(item);
        }
    }


}
