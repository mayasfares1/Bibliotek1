package Entitet;

public class Postnr
{
    private int PostNrId;
    private int postNr;
    private String by;

    public Postnr(int postNrId, int postNr, String by) {

        this.PostNrId = postNrId;
        this.postNr = postNr;
        this.by = by;
    }

    public Postnr(int postNr, String by) {
        this.postNr = postNr;
        this.by = by;
    }

    public int getPostNrId() {
        return PostNrId;
    }

    public void setPostNrId(int postNrId) {
        PostNrId = postNrId;
    }

    public int getPostNr() {
        return postNr;
    }

    public void setPostNr(int postNr) {
        this.postNr = postNr;
    }

    public String getBy() {
        return by;
    }

    public void setBy(String by) {
        this.by = by;
    }

    @Override
    public String toString() {
        return "Postnr{" +
                "PostNrId=" + PostNrId +
                ", postNr=" + postNr +
                ", by='" + by + '\'' +
                '}';
    }
}
