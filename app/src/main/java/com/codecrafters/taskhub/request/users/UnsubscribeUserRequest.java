package com.codecrafters.taskhub.request.users;

import android.os.AsyncTask;

import com.codecrafters.taskhub.utils.ConnectionFactory;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class UnsubscribeUserRequest extends AsyncTask<String, Void, Boolean> {

    @Override
    protected Boolean doInBackground(String... strings) {
        try {
            URL delete = new URL("http://" + ConnectionFactory.SERVER_IP + ":8080/usuarios/" + strings[0] + "/" + strings[1] + "/desinscrever");
            HttpURLConnection connection = (HttpURLConnection) delete.openConnection();
            connection.setRequestMethod("PATCH");
            connection.setDoOutput(false);
            connection.setConnectTimeout(15000);
            connection.connect();

            if (connection.getResponseCode() == 200) return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
