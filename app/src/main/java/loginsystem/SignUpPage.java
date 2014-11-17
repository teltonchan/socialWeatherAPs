package loginsystem;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import edu.depaul.csc472.weathersocial.R;
import util.SignUpUser;


public class SignUpPage extends Activity{

    //Image Request code.
    private final int REQUEST_IMAGE_CODE = 10;
    //List of States
    private final ArrayList<EditText> check = new ArrayList<EditText>();
    //Check process.
    private boolean isDone = false;
    //Connect to database.
    private SignUpUser connector;
    //UI Elements
    private EditText Email;
    private EditText Pass;
    private EditText NickN;
    private EditText FirstN;
    private EditText LastN;
    private EditText Address;
    private EditText City;
    private EditText ZIP;
    private EditText Answer1;
    private EditText Answer2;
    private EditText Answer3;
    private Spinner State;
    private Button submit;
    private Button cancel;
    private ImageButton image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page);

        initialize();
        addArray();

        ArrayAdapter<String> State_List = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, Information.STATES);
        State_List.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        State.setAdapter(State_List);
    }

    /**
     * Add every EditText in array to check the input.
     */
    private void addArray() {
        check.add(Email);
        check.add(Pass);
        check.add(NickN);
        check.add(FirstN);
        check.add(LastN);
        check.add(Address);
        check.add(City);
        check.add(ZIP);
    }

    /**
     * Initialize all UI View
     */
    private void initialize() {
        Email      = (EditText) findViewById(R.id.email);
        Pass       = (EditText) findViewById(R.id.password);
        NickN      = (EditText) findViewById(R.id.Nick_Name);
        FirstN     = (EditText) findViewById(R.id.F_Name);
        LastN      = (EditText) findViewById(R.id.L_Name);
        Address    = (EditText) findViewById(R.id.ADDRESS);
        City       = (EditText) findViewById(R.id.City);
        ZIP        = (EditText) findViewById(R.id.ZIP);
        State      = (Spinner)  findViewById(R.id.State);

        Answer1    = (EditText) findViewById(R.id.ans1);
        Answer2    = (EditText) findViewById(R.id.ans2);
        Answer3    = (EditText) findViewById(R.id.ans3);

        submit = (Button) findViewById(R.id.SubmitButton);
        cancel = (Button) findViewById(R.id.CancelButton);
        image = (ImageButton) findViewById(R.id.addImage);
    }

    /**
     * Handle submit button
     * @param v
     */
    public void SubmitButton(View v){
        if(!checkAllInput()){
            Toast.makeText(SignUpPage.this,"Please enter all information.",Toast.LENGTH_SHORT).show();
            return;
        }

        if(getCurrentFocus()!=null) {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
        disableAllButton();
        PrepareData();
    }

    /**
     * All buttons are disabled while updating database.
     */
    private void disableAllButton(){
        submit.setEnabled(false);
        cancel.setEnabled(false);
        image.setEnabled(false);
    }

    /**
     * Prepare Data and update with database.
     */
    private void PrepareData() {
        UserData user = new UserData(Email.getText().toString(), Pass.getText().toString(), NickN.getText().toString(),
                FirstN.getText().toString(), LastN.getText().toString(), Address.getText().toString(),
                City.getText().toString(), State.getSelectedItem().toString(), ZIP.getText().toString(),
                Answer1.getText().toString(), Answer2.getText().toString(), Answer3.getText().toString());

        connector = new SignUpUser(user, this);
        connector.execute();
    }

    /**
     * Handle cancel button.
     * @param v
     */
    public void CancelButton(View v){
        finish();
    }

    /**
     * Handle profile image button.
     * @param v
     */
    public void ProfileButton(View v){
        Intent getImage = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

        startActivityForResult(getImage,REQUEST_IMAGE_CODE);
    }

    /**
     * All buttons are enabled when updating database is failed.
     */
    public void enableAllButton(){
        submit.setEnabled(true);
        cancel.setEnabled(true);
        image.setEnabled(true);
    }

    /**
     * Go back to login page once database is updated.
     */
    public void updateDone(){
        Intent LoginPage = new Intent();
        setResult(RESULT_OK,LoginPage);
        finish();
    }

    public void PopupError(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

    /**
     * Check all input before process further.
     * @return
     */
    private boolean checkAllInput() {

        for(EditText temp : check){
            String text = temp.getText().toString();
            System.out.println(text);

            if(text.equals("") || text == null){
                return false;
            }
        }

        if(check.get(0).getText().toString().indexOf("@") < 0){
            Toast.makeText(SignUpPage.this,"Please enter a correct email form.",Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    /**
     * Receive the media storage activity in our phone. Get image and show on screen as profile image.
     * @param requestCode
     * @param resultCode
     * @param data
     */
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        ImageButton image = (ImageButton) findViewById(R.id.addImage);
        //Change code if possible
        if(requestCode == REQUEST_IMAGE_CODE){
            if(resultCode == RESULT_OK){
                Uri targetUri = data.getData();

                Bitmap bitmap;
                try {
                    bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(targetUri));
                    image.setImageBitmap(bitmap);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.sign_up_page, menu);
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
