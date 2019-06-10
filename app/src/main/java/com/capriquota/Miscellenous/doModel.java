package com.capriquota.Miscellenous;

import java.util.HashMap;

/**
 * Created by Ace Corps on 09/06/2019.
 */

public interface doModel {
    String DB_DRIVER= "jdbc:mysql://remotemysql.com:3306/zWgb1AWxVG";

    void close();

    /**
     *this object connects databse to other
     * @return
     */
    boolean is_connected();

    boolean registerUser(HashMap data);
    boolean loginUser();


}
