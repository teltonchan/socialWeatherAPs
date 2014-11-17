package util;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONObject;

import loginsystem.SignUpPage;
import loginsystem.UserData;

/**
 * This class will connect to database and update user in database.
 */
public class SignUpUser extends AsyncTask<Void,Void,Void> {

    private final RestAPI database = new RestAPI();
    private final UserData user;
    private final SignUpPage page;
    private boolean isSuccess  = false;
    private int ID;

    public SignUpUser(UserData user, SignUpPage page)
    {
        this.user = user;
        this.page = page;
    }

    @Override
    protected Void doInBackground(Void... params) {

        try {
            JSONObject reader = database.CreatePersonUser(user.getL_Name(), user.getF_Name(), user.getAddress(),
                                                    user.getCity(), user.getState(), user.getZIP(),
                                                    user.getNickName(), user.getEmail(), user.getPassword(),
                                                    "Pete", "Hola", "Sushi");
            JSONArray checkID = reader.getJSONArray("Value");
            ID = Integer.parseInt(checkID.getJSONObject(0).get("personID").toString());
            isSuccess = true;
        } catch (Exception e) {}

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        if(isSuccess){
            if(ID == 0){
                page.PopupError("Sign up fails. Please check all information again.");
                page.enableAllButton();
            }else if(ID == -1){
                page.PopupError("This information already exists.");
                page.enableAllButton();
            }else{
                page.updateDone();
            }
        }else{
            page.PopupError("Can't connect to database. Please check your internet connection.");
            page.enableAllButton();
        }

    }
}
