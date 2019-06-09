package com.capriquota.controllers;

import com.capriquota.model.Authentication;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ace Corps on 09/06/2019.
 */

public class registerUser extends Authentication{


    private List<> store = new ArrayList<>();

    public registerUser(ArrayList <> data){
        this.store = data;
        new Authentication().registerUser(data);
    }

}