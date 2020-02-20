package com.pixelhubllc.recyclermaterial;

public class Sport {

    private final int imageResource;
    private final String title;
    private final String info;

    public Sport(String title, String info, int imageResource) {
        this.title = title;
        this.info = info;
        this.imageResource = imageResource;
    }

    public String getTitle() {
        return title;
    }

    public String getInfo() {
        return info;
    }

    public int getImageResource() {
        return imageResource;
    }
}
