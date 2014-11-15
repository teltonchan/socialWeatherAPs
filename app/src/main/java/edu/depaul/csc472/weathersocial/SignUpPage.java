package edu.depaul.csc472.weathersocial;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;
import java.io.FileNotFoundException;
import java.util.ArrayList;


public class SignUpPage extends Activity {

    private final int REQUEST_IMAGE_CODE = 10;
    private final ArrayList<EditText> check = new ArrayList<EditText>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page);
        ArrayAdapter<String> State_List = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,Information.STATES);
        State_List.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ImageButton profileImage = (ImageButton) findViewById(R.id.addImage);

        final EditText Email      = (EditText) findViewById(R.id.email);
        final EditText Pass       = (EditText) findViewById(R.id.password);
        final EditText NickN      = (EditText) findViewById(R.id.Nick_Name);
        final EditText FirstN     = (EditText) findViewById(R.id.F_Name);
        final EditText LastN      = (EditText) findViewById(R.id.L_Name);
        final EditText Address    = (EditText) findViewById(R.id.ADDRESS);
        final EditText City       = (EditText) findViewById(R.id.City);
        final EditText ZIP        = (EditText) findViewById(R.id.ZIP);

        final Spinner State       = (Spinner)  findViewById(R.id.State);

        final Button Submit       = (Button)   findViewById(R.id.SubmitButton);
        final Button Cancel       = (Button)   findViewById(R.id.CancelButton);


        check.add(Email);
        check.add(Pass);
        check.add(NickN);
        check.add(FirstN);
        check.add(LastN);
        check.add(Address);
        check.add(City);
        check.add(ZIP);

        class ImageHandler implements View.OnClickListener{

            @Override
            public void onClick(View v) {
                Intent getImage = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                startActivityForResult(getImage,REQUEST_IMAGE_CODE);
            }
        }

        class ButtonHandler implements  View.OnClickListener{

            @Override
            public void onClick(View v) {

                int type = v.getId();

                if(type == R.id.SubmitButton){

                    if(!checkAllInput()){
                        Toast.makeText(SignUpPage.this,"Please enter all information.",Toast.LENGTH_SHORT).show();
                        return;
                    }
                    //After check every thing, you can update on the server.
                    //Please continue at this line.
                    //TODO
                    Intent LoginPage = new Intent();
                    setResult(RESULT_OK,LoginPage);
                    finish();
                }else {
                    finish();
                }
            }
        }

        ButtonHandler handler = new ButtonHandler();

        profileImage.setOnClickListener(new ImageHandler());
        State.setAdapter(State_List);
        Submit.setOnClickListener(handler);
        Cancel.setOnClickListener(handler);

    }

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
