package com.example.android.slidingtabsbasic;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Mike on 7/5/2016.
 */
public class Coupons {
    String category;
    boolean saved;
    boolean featured =false;
    boolean redeemed =false;
    String name;
    public ArrayList<String> deals=new ArrayList<String>();//todo add detailed details for redeem screen
    int pin;
    String voc;
    Date expire;


    public Coupons(String name){
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isSaved() {
        return saved;
    }

    public void setSaved(boolean saved) {
        this.saved = saved;
    }

    public boolean isFeatured() {
        return featured;
    }

    public void setFeatured(boolean featured) {
        this.featured = featured;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public void setVoc(String pinStr){     this.voc = "WRH"+pinStr;
    }

    public String getVoc() {
        return voc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getExpire() { return expire; }

    public void setExpire(Date expire){
        this.expire = expire;
    }
    public boolean isRedeemed(){return redeemed;}
    public void setRedeemed(boolean redeemed){ this.redeemed = redeemed;}
}
