package com.capriquota.Miscellenous;

/**
 * Created by Ace Corps on 09/06/2019.
 */

public interface doUtility {
    static final String LOCALHOST = "127.0.0.1";
    static final String IPCHECKURL = "http://myexternalip.com/raw";

    public boolean checkInternet();
    public String getRawIpAddr();
    public String getRealIpAddr();

}
