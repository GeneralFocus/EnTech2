package com.capriquota.model;


import com.capriquota.Miscellenous.Utility;
import com.capriquota.Miscellenous.doModel;

import java.sql.Connection;
import java.sql.DriverManager;
import android.util.*;
import java.sql.*;
import java.util.logging.Logger;


/**
 * Created by Ace Corps on 09/06/2019.
 */

public class Authentication implements doModel{


    private static final String driver      = DB_DRIVER;
    private static final String DB_USERNAME = Utility.getEnv("default_DBU");
    private static final String DB_PASSWORD = Utility.getEnv("default_DBP");

    protected static Connection conn = null;

    public Authentication(){
        super();
        this.connect();
    }

    private boolean connect() {

        if(is_connected())
            return true;

        try {
            Class.forName("com.mysql.jdbc.Driver");

            try{
                this.conn = DriverManager.getConnection(driver,DB_USERNAME,DB_PASSWORD);

                if(is_connected())
                    return true;

            } catch (SQLException ex) {
                Log.d(Utility.LOGGER , ex.getStackTrace().toString());
            }

        } catch (ClassNotFoundException ex) {
            Log.d(Utility.LOGGER , ex.getStackTrace().toString());
        }

        return false;
    }

    @Override
    public void close() {

        if(is_connected())
            this.conn = null;
    }

    @Override
    public boolean is_connected() {
        if(this.conn != null)
            return true;

        return false;
    }

    @Override
    public boolean registerUser() {
        return false;
    }

    @Override
    public boolean loginUser() {
        return false;
    }
}
