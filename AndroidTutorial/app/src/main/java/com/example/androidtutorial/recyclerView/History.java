package com.example.androidtutorial.recyclerView;

public class History {
    String title, icon;
    int point;

    public History(String z, String title, int point) {
        this.title = title;
        this.point = point;
        this.icon = icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getIcon() {
        return icon;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }


}
