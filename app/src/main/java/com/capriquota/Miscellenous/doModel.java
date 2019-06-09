package com.capriquota.Miscellenous;

/**
 * Created by Ace Corps on 09/06/2019.
 */

public interface doModel {
    static final String DB_DRIVER= "jdbc:mysql://remotemysql.com:3306/zWgb1AWxVG";

    public void close();

    /**
     *this object connects databse to other
     * @return
     */
    public boolean is_connected();

    public boolean registerUser();
    public boolean loginUser();


}
