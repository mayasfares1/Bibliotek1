package Entitet;

public class Udlåns
{
    private int UdlånsId;
    private int BogId;
    private int LånerId;

    public Udlåns(int udlånsId, int bogId, int lånerId) {

        UdlånsId = udlånsId;
        BogId = bogId;
        LånerId = lånerId;
    }

    public Udlåns(int bogId, int lånerId) {

        BogId = bogId;
        LånerId = lånerId;
    }


    public int getUdlånsId() {
        return UdlånsId;
    }

    public void setUdlånsId(int udlånsId) {
        UdlånsId = udlånsId;
    }

    public int getBogId() {
        return BogId;
    }

    public void setBogId(int bogId) {
        BogId = bogId;
    }

    public int getLånerId() {
        return LånerId;
    }

    public void setLånerId(int lånerId) {
        LånerId = lånerId;
    }

    @Override
    public String toString() {
        return "Udlåns{" +
                "UdlånsId=" + UdlånsId +
                ", BogId=" + BogId +
                ", LånerId=" + LånerId +
                '}';
    }
}
