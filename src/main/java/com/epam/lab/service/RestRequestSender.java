package com.epam.lab.service;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class RestRequestSender {
    private static final Logger LOGGER = Logger.getLogger(RestRequestSender.class);
    Number number = null;
    NumberFormat format = NumberFormat.getInstance(Locale.FRANCE);

    public double sendRequestAndGetResult(String requestUrl) {
        URL url = null;
        try {
            url = new URL(requestUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        HttpURLConnection request = null;
        try {
            request = (HttpURLConnection) url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            request.connect();
        } catch (IOException e) {
            e.printStackTrace();
        }

        JsonParser jp = new JsonParser();
        JsonElement root = null;

        try {
            root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        JsonObject rootobj = root.getAsJsonObject();

        try {
            number = format.parse(rootobj.get("result").getAsString());
        } catch (ParseException e) {
            LOGGER.error(e);
        }

        return number.doubleValue();
    }
}
