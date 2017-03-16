/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.deskind.mnemocardsfx.data;

import java.util.Date;

/**
 *
 * @author AUTO
 */
public class Signal {
    //yyyy-mm-dd
    private String date;
    //the value is 1 if win and 0 if lose
    private int isWin;

    public String getDate() {
        return date;
    }

    public int getIsWin() {
        return isWin;
    }
    
    

    public int isIsWin() {
        return isWin;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setIsWin(int isWin) {
        this.isWin = isWin;
    }
    
    
}
