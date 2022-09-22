package Entitet;

public class Bog
{
    private int BogId;
    private String forfatter;
    private String title;
    private int udgivelseår;

    public Bog(int bogId, String forfatter, String title, int udgivelseår) {

        BogId = bogId;
        this.forfatter = forfatter;
        this.title = title;
        this.udgivelseår = udgivelseår;
    }

    public Bog(String forfatter, String title, int udgivelseår) {
        this.forfatter = forfatter;
        this.title = title;
        this.udgivelseår = udgivelseår;
    }

    public int getBogId() {
        return BogId;
    }

    public void setBogId(int bogId) {
        BogId = bogId;
    }

    public String getForfatter() {
        return forfatter;
    }

    public void setForfatter(String forfatter) {
        this.forfatter = forfatter;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getUdgivelseår() {
        return udgivelseår;
    }

    public void setUdgivelseår(int udgivelseår) {
        this.udgivelseår = udgivelseår;
    }

    @Override
    public String toString() {
        return "Bog{" +
                "BogId=" + BogId +
                ", forfatter='" + forfatter + '\'' +
                ", title='" + title + '\'' +
                ", udgivelseår=" + udgivelseår +
                '}';
    }
}