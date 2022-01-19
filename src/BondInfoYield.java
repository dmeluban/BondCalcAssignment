public class BondInfoYield {

    private double coupon;
    private int years;
    private double face;
    private double price;

    public BondInfoYield(double coupon, int years,double face, double price){
        this.coupon = coupon;
        this.years = years;
        this.face = face;
        this.price = price;
    }

    public double getCoupon() {
        return coupon;
    }

    public void setCoupon(double coupon) {
        this.coupon = coupon;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public double getFace() {
        return face;
    }

    public void setFace(double face) {
        this.face = face;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "{" +
            " coupon='" + getCoupon() + "'" +
            ", years='" + getYears() + "'" +
            ", face='" + getFace() + "'" +
            ", price='" + getPrice() + "'" +
            "}";
    }

}