package ua.nure.nlebed.utils;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonUtils {

    private static final String ANDROID = "ANDROID";

    public static JSONObject createUserJson(GoogleSignInAccount account) throws JSONException {
        String wlan0 = DeviceInfoUtils.getMACAddress();
        String ipAddress = DeviceInfoUtils.getIPAddress();
        JSONObject userJson = new JSONObject();
        String email = account.getEmail();
        int indexOf = email.indexOf('.');
        userJson.put("email", email);
        try {
            userJson.put("name", email.substring(0, indexOf));
            userJson.put("lastName", email.substring(indexOf + 1, email.indexOf('@')));
        } catch (Exception e) {
            userJson.put("name", account.getGivenName());
            userJson.put("lastName", account.getFamilyName());
        }
        userJson.put("macAddress", wlan0);
        userJson.put("ipAddress", ipAddress);
        userJson.put("device", ANDROID);
        userJson.put("photoUrl", account.getPhotoUrl());
        return userJson;
    }

}
