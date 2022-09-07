package com.example.broadcastreceiver;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;

public class NetworkUtil {
    public static boolean checkNetworkState(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager == null)
            return false;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Network nw = connectivityManager.getActiveNetwork();
            NetworkCapabilities activeNetworkInfo = connectivityManager.getNetworkCapabilities(nw);
            if (activeNetworkInfo!=null && activeNetworkInfo.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) &&
                    activeNetworkInfo.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                return true;
            } else
                return false;

        } else {
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            if (networkInfo != null)
                return networkInfo.isConnected();
            else
                return false;
        }
    }
}
