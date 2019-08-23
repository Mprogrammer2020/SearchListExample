package com.netsetdemoproject.api.pojo;

/**
 * Created by SQ-OGBE PC on 15/10/2017.
 * Sample model, just to hold the position of the items
 * it would be used to demonstrate how to track the state of the checked view using the model
 */

public class Model {
    /**
     * the position of the item in the list
     */
    private int position;
    private String name;

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getNAme() {
        return name;
    }

    public void setNAme(String name) {
        this.name = name;
    }

    private boolean isChecked;

    public boolean getChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
}
