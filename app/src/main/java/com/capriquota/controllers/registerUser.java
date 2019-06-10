package com.capriquota.controllers;

import com.capriquota.model.Authentication;

import java.util.HashMap;

/**
 * Created by Ace Corps on 09/06/2019.
 */

public class registerUser extends Authentication{


    private HashMap<Integer , String> store = new HashMap<Integer, String>();

    public registerUser(HashMap data){
        this.store = data;
        new Authentication().registerUser(data);
    }

}