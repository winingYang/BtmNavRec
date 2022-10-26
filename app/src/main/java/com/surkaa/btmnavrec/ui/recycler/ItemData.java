package com.surkaa.btmnavrec.ui.recycler;

import android.content.ClipData;
import android.content.Intent;

public class ItemData {
    private final int idContact;
    private final String name;
    private final String description;
    private final String time;
    private final int idNotification;

    public ItemData(int idContact, String name, String description, String time, int idNotification) {
        this.idContact = idContact;
        this.name = name;
        this.description = description;
        this.time = time;
        this.idNotification = idNotification;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getIdContact() {
        return idContact;
    }

    public String getTime() {
        return time;
    }

    public int getIdNotification() {
        return idNotification;
    }
}
