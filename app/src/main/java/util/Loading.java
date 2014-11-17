package util;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;

/**
 * Created by pete on 11/15/14.
 * this latest
 */
public class Loading<E> extends AsyncTask<Void,Void,Void> {
    private final ProcessListener listener;
    private final ProgressDialog loading;
    private final Activity mainAct;
    private boolean isProgress = false;
    private final E type;

    public Loading(Activity mainAct,ProcessListener listener,E type){
        this.mainAct = mainAct;
        this.listener = listener;
        this.loading = new ProgressDialog(mainAct);
        this.type = type;
    }

    @Override
    protected Void doInBackground(Void... params) {

        try{
            while (!isProgress) {
                Thread.sleep(1500);
                publishProgress();
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        loading.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        loading.setTitle("Please Wait");
        loading.setMessage("Data is loading.");
        loading.show();
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
        isProgress = listener.isProcessing();
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        loading.dismiss();

    }
}
