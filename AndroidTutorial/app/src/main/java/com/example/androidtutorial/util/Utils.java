package com.example.androidtutorial.util;

import android.content.Context;
import android.content.res.Resources;

import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class Utils {
    public static JSONObject fileToJson(int filename, Context context) {
        try {
            Resources res = context.getResources();
            InputStream in_s = res.openRawResource(filename);
            byte[] b = new byte[in_s.available()];
            in_s.read(b);
            String strData = new String(b);
            return new JSONObject(strData);
        } catch (Exception e) {
            return null;
        }

    }
}
