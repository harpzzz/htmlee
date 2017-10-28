package com.harpz.htmlee.model;

import com.harpz.htmleetim.annotations.Pick;

/**
 * Created by Neha Thakur on 10/28/2017.
 */

public class MUser {

    @Pick(value = "#test")
    String uName;


    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }
}
