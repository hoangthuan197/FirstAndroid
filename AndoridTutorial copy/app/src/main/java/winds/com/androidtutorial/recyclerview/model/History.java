package winds.com.androidtutorial.recyclerview.model;

public class History {
    String title , icon;
    int point ;

    public History(String title, int point) {
        this.title = title;
        this.point = point;
    }

    public History(String title, String icon, int point) {
        this.title = title;
        this.icon = icon;
        this.point = point;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
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
