package CinemaRoomManager;

public class PriceSetting {

    private int normalPrice;
    private int frontRowPrice;
    private int backRowPrice;
    private int smallRoomLimit;

    public PriceSetting()
    {

    }

    public PriceSetting(int normalPrice, int frontRowPrice, int backRowPrice, int smallRoomLimit)
    {
        this.normalPrice = normalPrice;
        this.frontRowPrice = frontRowPrice;
        this.backRowPrice = backRowPrice;
        this.smallRoomLimit = smallRoomLimit;
    }

    public int getNormalPrice() {
        return normalPrice;
    }

    public void setNormalPrice(int normalPrice) {
        this.normalPrice = normalPrice;
    }

    public int getFrontRowPrice() {
        return frontRowPrice;
    }

    public void setFrontRowPrice(int frontRowPrice) {
        this.frontRowPrice = frontRowPrice;
    }

    public int getBackRowPrice() {
        return backRowPrice;
    }

    public void setBackRowPrice(int backRowPrice) {
        this.backRowPrice = backRowPrice;
    }

    public int getSmallRoomLimit() {
        return smallRoomLimit;
    }

    public void setSmallRoomLimit(int smallRoomLimit) {
        this.smallRoomLimit = smallRoomLimit;
    }
}
