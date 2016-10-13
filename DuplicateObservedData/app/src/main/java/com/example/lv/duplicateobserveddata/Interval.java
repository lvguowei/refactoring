package com.example.lv.duplicateobserveddata;

import java.util.Observable;

public class Interval extends Observable {

    private int end = 0;

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
        setChanged();
        notifyObservers();
    }

}
