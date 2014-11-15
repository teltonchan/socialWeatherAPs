package edu.depaul.csc472.weathersocial;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;
import android.content.Context;


public class ForgetPage extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_page);
    }
    //Handle Submit button. Send email with user's password and go back to login Page.
    public void SubmitHandler(View v){

        final TextView warning = (TextView) findViewById(R.id.ErrorMessage);
        final EditText email    = (EditText) findViewById(R.id.sendingEmail);

        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(email.getWindowToken(), 0);

        String mail = email.getText().toString();

        if(mail.indexOf("@") < 0){
            warning.setText("This email is invalid. Try again.");
            return;
        }else{
            //Sending password that matches with email address.
            //TODO

            //Go back to login page.
            Intent LoginPage = new Intent();
            setResult(RESULT_OK,LoginPage);
            finish();
        }
    }
    //Handle cancel button. Destroy this activity and go back to Login page
    public void CancelHandler(View v){
         finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.forget_page, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
