package edu.depaul.csc472.weathersocial;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class WeatherSocial extends Activity {

    //Set all request code.
    private final int SIGN_UP_REQUEST_CODE = 100;
    private final int FORGET_REQUEST_CODE = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_social);

        //Setup every field in the layout.

        final TextView Warning = (TextView) findViewById(R.id.WarningMessage);

        final EditText USER = (EditText) findViewById(R.id.UsernameLogin);
        final EditText PASS = (EditText) findViewById(R.id.PasswordLogin);

        final Button Sign_Up = (Button) findViewById(R.id.SignUpButton);
        final Button Clear = (Button) findViewById(R.id.ClearButton);
        final Button Forget = (Button) findViewById(R.id.ForgetButton);
        final Button Login = (Button) findViewById(R.id.LoginButton);

        /**
         * This class is for all button. You can see the detail in each section.
         */

        class ButtonHandler implements View.OnClickListener {

            @Override
            public void onClick(View v) {

                int ID = v.getId();
                //Call SignUp page if user clicks "SignUp" button.
                if (ID == R.id.SignUpButton) {
                    Intent Sign_Up_Form = new Intent(WeatherSocial.this, SignUpPage.class);
                    startActivityForResult(Sign_Up_Form, SIGN_UP_REQUEST_CODE);
                    //Call Forget page if user clicks "Forget Password" button.
                } else if (ID == R.id.ForgetButton) {
                    Intent Forget_Form = new Intent(WeatherSocial.this, ForgetPage.class);
                    startActivityForResult(Forget_Form, FORGET_REQUEST_CODE);
                    //Clear every EditText and Warning View if user clicks "Clear" button.
                } else if (ID == R.id.ClearButton) {
                    USER.setText("");
                    PASS.setText("");
                    //Check username and password if user clicks "Login" button.
                } else if (ID == R.id.LoginButton) {
                    //TODO
                    //This is login section. Send username and password to SQL server.
                    //To check username and password.
                    //Handle in case username and password doesn't exist.
                    //If it's exist, go to main page.
                    Intent weather_status = new Intent(WeatherSocial.this,WeatherStatus.class);
                    startActivity(weather_status);
                    //finish(); //clear memory and stay on main page.

                }
            }
        }

        //Set all handler.
        final ButtonHandler handler = new ButtonHandler();

        Sign_Up.setOnClickListener(handler);
        Clear.setOnClickListener(handler);
        Forget.setOnClickListener(handler);
        Login.setOnClickListener(handler);
    }

    /**
     * Once Sign up page and forget password page are done. It will call the following method.
     * It will check the response message and show some message in the warning text view field.
     * After that, let the user login.
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        TextView warning = (TextView) findViewById(R.id.WarningMessage);

        if (requestCode == SIGN_UP_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                warning.setText("Congratulation! You have already signed up. Try Login with your username and password.");
            }
        } else if (requestCode == FORGET_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                warning.setText("Your password is already sent to your email.");
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.weather_social, menu);
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
