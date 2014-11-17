package loginsystem;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import edu.depaul.csc472.weathersocial.R;
import edu.depaul.csc472.weathersocial.WeatherStatus;
import util.LoginProcess;

public class LoginPage extends Activity {

    //Set all request code.
    private final int SIGN_UP_REQUEST_CODE = 100;
    private final int FORGET_REQUEST_CODE = 200;

    private LoginProcess checkUser;


    //UI Element
    private EditText USER;
    private EditText PASS;
    private Button LOGIN;
    private Button CLEAR;
    private Button FORGET;
    private Button SIGNUP;
    //For user information.
    private int userID;
    private int personID;
    private int GID;

    public TextView Warning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        initialize(); //Set up UI.
    }

    private void disableButton(){
        LOGIN.setEnabled(false);
        SIGNUP.setEnabled(false);
        CLEAR.setEnabled(false);
        FORGET.setEnabled(false);
    }

    /**
     * Set up every Text UI.
     */
    private void initialize() {
        Warning     = (TextView) findViewById(R.id.WarningMessage);
        USER        = (EditText) findViewById(R.id.UsernameLogin);
        PASS        = (EditText) findViewById(R.id.PasswordLogin);
        LOGIN       = (Button) findViewById(R.id.LoginButton);
        CLEAR       = (Button) findViewById(R.id.ClearButton);
        FORGET      = (Button) findViewById(R.id.ForgetButton);
        SIGNUP      = (Button) findViewById(R.id.SignUpButton);
    }
    //Handle clear button
    public void clearButton(View v){
        USER.setText("");
        PASS.setText("");
    }
    //Handle sign up button
    public void SignUpButton(View v){
        Intent Sign_Up_Form = new Intent(LoginPage.this, SignUpPage.class);
        startActivityForResult(Sign_Up_Form, SIGN_UP_REQUEST_CODE);
    }
    //Handle forget button
    public void ForgetButton(View v){
        Intent Forget_Form = new Intent(LoginPage.this, ForgetPage.class);
        startActivityForResult(Forget_Form, FORGET_REQUEST_CODE);
    }
    //Handle login button
    public void LoginButton(View v){
        disableButton();

        if(getCurrentFocus()!=null) {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }

        checkUser = new LoginProcess(USER.getText().toString(), PASS.getText().toString(), this);
        checkUser.execute();
    }

    public void storeData(int userID, int personID, int GID){
        this.userID = userID;
        this.personID = personID;
        this.GID = GID;
    }

    public void accessDone(){
        Intent weather_status = new Intent(LoginPage.this,WeatherStatus.class);
        weather_status.putExtra("USER_ID",userID);
        weather_status.putExtra("PERSON_ID",personID);
        weather_status.putExtra("GID",GID);

        startActivity(weather_status);
        finish(); //clear memory and stay on main page.
    }

    public void enableButton(){
        LOGIN.setEnabled(true);
        SIGNUP.setEnabled(true);
        CLEAR.setEnabled(true);
        FORGET.setEnabled(true);
    }

    /**
     * Once Sign up page and forget password page are done. It will call the following method.
     * It will check the response message and show some message in the warning text view field.
     * After that, let the user login.
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == SIGN_UP_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                Warning.setText("Congratulation! You have already signed up. Try Login with your username and password.");
            }
        } else if (requestCode == FORGET_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                Warning.setText("Your password is already sent to your email.");
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
