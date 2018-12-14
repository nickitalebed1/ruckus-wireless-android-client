package ua.nure.nlebed.utils;

import java.net.NetworkInterface;
import java.util.Collections;
import java.util.List;

public class MacAddressUtils {

    public static String getMACAddress(String interfaceName) {
        try {
            List<NetworkInterface> interfaces = Collections.list(NetworkInterface.getNetworkInterfaces());
            for (NetworkInterface aInterface : interfaces) {
                if (interfaceName != null) {
                    if (!aInterface.getName().equalsIgnoreCase(interfaceName)) continue;
                }
                byte[] mac = aInterface.getHardwareAddress();
                if (mac == null) return "";
                StringBuilder buf = new StringBuilder();
                for (byte aMac : mac) buf.append(String.format("%02X:", aMac));
                if (buf.length() > 0) buf.deleteCharAt(buf.length() - 1);
                return buf.toString();
            }
        } catch (Exception ignored) {

        }
        return "";
    }
}
