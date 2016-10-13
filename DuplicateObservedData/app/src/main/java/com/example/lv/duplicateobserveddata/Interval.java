package com.example.lv.duplicateobserveddata;

import java.util.Observable;

class Interval extends Observable {

    private int end = 0;
    private int start = 0;
    private int length = 0;

    int getStart() {
        return start;
    }
    int getEnd() {
        return end;
    }

    int getLength() {
        return length;
    }

    void setLength(int length) {
        this.length = length;
        calculateEnd();
        setChanged();
        notifyObservers();
    }

    void setStart(int start) {
        this.start = start;
        calculateLength();
        setChanged();
        notifyObservers();
    }
    void setEnd(int end) {
        this.end = end;
        calculateLength();
        setChanged();
        notifyObservers();
    }

    private void calculateLength() {
        length = end - start;
    }

    private void calculateEnd() {
        end = start + length;
    }

}
