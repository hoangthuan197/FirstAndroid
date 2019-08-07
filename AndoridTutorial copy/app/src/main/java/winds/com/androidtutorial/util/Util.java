package winds.com.androidtutorial.util;

import android.content.Context;
import android.content.res.Resources;

import org.json.JSONObject;

import java.io.InputStream;

import winds.com.androidtutorial.R;

public class Util {


    public static JSONObject fileToJson(int fileName, Context context) {
        try {
            Resources res = context.getResources();
            InputStream in_s = res.openRawResource(fileName);
            byte[] b = new byte[in_s.available()];
            in_s.read(b);
            String strData = new String(b);
            return new JSONObject(strData);
        } catch (Exception e) {
            return null;
        }

    }


}
