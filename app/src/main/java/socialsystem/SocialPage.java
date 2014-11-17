package socialsystem;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ListView;

import edu.depaul.csc472.weathersocial.R;
import edu.depaul.csc472.weathersocial.WeatherStatus;
import loginsystem.LoginPage;
import util.ProcessListener;


public class SocialPage extends ListActivity implements ProcessListener{

    private boolean isDone = false;
    private Comment AllComment;
    private ListView view;
    private EditText box;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social_page);

        AllComment = new Comment(this);
        initialize();
        setList();
    }

    private void setList() {
        view = getListView();
        view.setAdapter(AllComment);
    }

    private void updateList(Post newPost){
        AllComment.add(newPost);
        AllComment.notifyDataSetChanged();
    }

    private void initialize() {
        box = (EditText) findViewById(R.id.messageBox);

        //TODO CONNECT TO DATABASE, GET ALL POSTS, ADD IN ARRAY AND SHOW ON SCREEN
        updateList(new Post("Name1", "City1", "Address1", "Comment1"));
    }

    public void WButtonHandler(View v){
        Intent WeatherPage = new Intent(SocialPage.this,WeatherStatus.class);
        startActivity(WeatherPage);
        finish();
    }

    public void PostHandler(View v){
        int choice = v.getId();

        if (choice == R.id.logout) {
            Intent loginPage = new Intent(SocialPage.this, LoginPage.class);
            startActivity(loginPage);
            finish();

        }else if(choice == R.id.posting){
            //TODO GET TEXT FROM TEXT BOX, UPDATE WITH DATABASE AND UPDATE LIST.
            updateList(new Post("Name1", "City1", "Address1", "Comment1"));

        }

        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(box.getWindowToken(), 0);
        box.setText("");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.social_page, menu);
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

    @Override
    public boolean isProcessing() {
        return isDone;
    }

    @Override
    public void jobDone() {
        isDone = true;
    }

}
