package com.capriquota.model;


import android.util.Log;

import com.capriquota.Miscellenous.Utility;
import com.capriquota.Miscellenous.doModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 * Created by Ace Corps on 09/06/2019.
 */

public class Authentication implements doModel{


    private static final String driver      = doModel.DB_DRIVER;
    private static final String DB_USERNAME = Utility.getEnv("default_DBU");
    private static final String DB_PASSWORD = Utility.getEnv("default_DBP");

    protected static Connection conn;

    public Authentication(){
        this.connect();
    }

    private boolean connect() {

        if(this.is_connected())
            return true;

        try {
            Class.forName("com.mysql.jdbc.Driver");

            try{
                Authentication.conn = DriverManager.getConnection(Authentication.driver, Authentication.DB_USERNAME, Authentication.DB_PASSWORD);

                if(this.is_connected())
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

        if(this.is_connected())
            Authentication.conn = null;
    }

    @Override
    public boolean is_connected() {
        return Authentication.conn != null;

    }

    @Override
    public boolean registerUser(ArrayList <> data) {

        Log.d(Utility.LOGGER , "here");

        return false;
    }

    @Override
    public boolean loginUser() {
        return false;
    }
}
