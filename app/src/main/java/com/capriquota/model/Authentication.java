package com.capriquota.model;


import android.util.Log;

import com.capriquota.Miscellenous.Utility;
import com.capriquota.Miscellenous.doModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * Created by Ace Corps on 09/06/2019.
 */

public class Authentication implements doModel{


    private static final String driver      = doModel.DB_DRIVER;
    private static final String DB_USERNAME = Utility.getEnv("default_DBU");
    private static final String DB_PASSWORD = Utility.getEnv("default_DBP");
    private final List<String> store = new ArrayList<>();

    protected static Connection conn;

    public Authentication(){
         connect();
    }

    private boolean connect() {

        if( is_connected())
            return true;

        try {
            Class.forName("com.mysql.jdbc.Driver");

            try{
                 conn = DriverManager.getConnection( driver,  DB_USERNAME,  DB_PASSWORD);

                if( is_connected())
                    return true;

            } catch (SQLException ex) {
                Log.d(Utility.LOGGER , Log.getStackTraceString(ex));
            }

        } catch (ClassNotFoundException ex) {
            Log.d(Utility.LOGGER , Log.getStackTraceString(ex));
        }

        return false;
    }

    @Override
    public void close() {

        if( is_connected())
             conn = null;
    }

    @Override
    public boolean is_connected() {
        return  conn != null;
    }


    /***
     *
     * @method registerUser : registers user on database
     * @param data
     * @return false if registeration is unsuccessful
     *
     */
    @Override
    public boolean registerUser(HashMap data) {
        if(! is_connected())
            return false;
        
        boolean user_exist = false;
        
        try{
            // first check if user exists with same email address
            String query = "SELECT  Email from user";

            PreparedStatement statement =  conn.prepareStatement(query);
            ResultSet result = statement.executeQuery();

            while (result.next()){
                String getUsers = result.getString("Email").toString();

                 store.add(getUsers);

//                if(!store.contains() == )
            }

        }catch (Exception e){

        }


       /* Todo
       Todo Fix error
       for (int i: data.keySet()) {

        }*/

        return false;
    }

    @Override
    public boolean loginUser() {
        return false;
    }
}
