package org.apache.cordova.filetransfer;

import android.app.NotificationManager;
import android.os.AsyncTask;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

class FileProgressBarTask extends AsyncTask<Void, Integer, Integer> {

    private NotificationCompat.Builder mBuilder;
    private NotificationManager mNotificationManager;
    int id = 0;
    int progress = 0;

    FileProgressBarTask(NotificationCompat.Builder mBuilder, NotificationManager mNotificationManager, int id){

        Log.d("TAG", "Progress Bar");

        this.mBuilder = mBuilder;
        this.mNotificationManager = mNotificationManager;
        this.id = id;

        super.execute();
    }

    @Override
    protected void onPreExecute(){
        super.onPreExecute();

        mBuilder.setProgress(150, 0, false);
        mNotificationManager.notify(id, mBuilder.build());
    }

    @Override
    protected void onProgressUpdate(Integer... values){
        mBuilder.setProgress(150, values[0], false);
        mNotificationManager.notify(id, mBuilder.build());
        super.onProgressUpdate(values);
    }

    @Override
    protected Integer doInBackground(Void... params) {
        return null;
    }

    @Override
    protected void onPostExecute(Integer result){
        super.onPostExecute(result);
        mBuilder.setContentText("Download Concluído");

        mBuilder.setProgress(0, 0, false);
        mNotificationManager.notify(id, mBuilder.build());
    }
}