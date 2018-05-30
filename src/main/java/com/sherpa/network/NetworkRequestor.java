package com.sherpa.network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.net.HttpURLConnection;

public class NetworkRequestor {

    private String requestUrl;
    private String method;
    private URL url;
    private HttpURLConnection connection;
    private OutputStream os;
    private BufferedWriter bw;

    public NetworkRequestor(String requestUrl, String method) {
        this.requestUrl = requestUrl;
        this.method = method;
    }

    public void connect() throws Exception {
        url = new URL(requestUrl);
        connection = (HttpURLConnection) url.openConnection();
        connection.setDoOutput(true);
        connection.setRequestMethod(method);
        connection.setConnectTimeout(100000);
        connection.connect();
    }

    public String getOutputStream() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line+"\n");
        }
        br.close();
        return sb.toString();
    }
}
