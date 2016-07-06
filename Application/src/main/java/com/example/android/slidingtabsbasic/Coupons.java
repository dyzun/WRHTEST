package com.example.android.slidingtabsbasic;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Mike on 7/5/2016.
 */
public class Coupons {
    String category;
    boolean saved =false;
    boolean featured =false;
    String name;
    public ArrayList<String> deals=new ArrayList<String>();
    int pin;
    String voc = "WRH"+Integer.toString(pin);
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
}
