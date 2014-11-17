package util;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONObject;

import loginsystem.LoginPage;

/**
 * Created by pete on 11/16/14.
 */
public class LoginProcess extends AsyncTask<Void,Void,Void> {

    private final RestAPI connector = new RestAPI();
    private final String email;
    private final String password;
    private final LoginPage page;
    private boolean isAccess = false;
    private String WarningMessage;
    private int userID;
    private int personID;
    private int GID;

    public LoginProcess(String email, String password, LoginPage page){
        this.email = email;
        this.password = password;
        this.page = page;
    }

    @Override
    protected Void doInBackground(Void... params) {

        try {
            JSONObject object = connector.UserAuthentication(email, password);
            JSONArray data = object.getJSONArray("Value");

            userID = Integer.parseInt(data.getJSONObject(0).get("UserID").toString());
            personID = Integer.parseInt(data.getJSONObject(0).get("PersonID").toString());
            GID = Integer.parseInt(data.getJSONObject(0).get("gid").toString());

            if(userID > 0 || personID > 0 || GID > 0) {
                isAccess = true;
            }else{
                WarningMessage = "This email and password are invalid. Please try again.";
            }
        } catch (Exception e) {
            isAccess = false;
            WarningMessage = "No internet Connection. Please check your internet status.";
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        if(isAccess) {
            page.storeData(userID,personID,GID);
            page.accessDone();
        }else {
            page.Warning.setText(WarningMessage);
            page.enableButton();
        }
    }
}
