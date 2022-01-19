public class BondInfoPrice {

    private double coupon;
    private int years;
    private double face;
    private double rate;

    public BondInfoPrice(double coupon, int years,double face, double rate){
        this.coupon = coupon;
        this.years = years;
        this.face = face;
        this.rate = rate;
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

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }


    @Override
    public String toString() {
        return "{" +
            " coupon='" + getCoupon() + "'" +
            ", years='" + getYears() + "'" +
            ", face='" + getFace() + "'" +
            ", rate='" + getRate() + "'" +
            "}";
    }

}