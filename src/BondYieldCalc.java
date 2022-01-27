
import java.util.HashMap;



public class BondYieldCalc {

    private static HashMap<String, Double> mapperPrice = new HashMap<String, Double>();
    private static HashMap<String, Double> mapperYield = new HashMap<String, Double>();

    public static double CalcPrice(double coupon, int years, double face, double rate) {

        if(coupon == 0. ){
            return 0.;
        }
  

        BondInfoPrice newBond = new BondInfoPrice(coupon, years, face, rate);

        if (mapperPrice.get(newBond.toString()) == null) {
            double totalPrice = 0;
            for (int i = 1; i <= years; i++) {

                totalPrice += (coupon * face) / (Math.pow((1.0 + rate), i));
            }

            totalPrice += (face) / (Math.pow((1.0 + rate), years));

            mapperPrice.put(newBond.toString(), totalPrice);

            return mapperPrice.get(newBond.toString());
        } else {
            return mapperPrice.get(newBond.toString());
        }

    }

    public static double fYTM(double coupon, double price, double couponRate, double face, int years) {
        return (couponRate + face) * Math.pow(coupon, years + 1) - face * Math.pow(coupon, years) - (couponRate + price) * coupon + price;
    }

    public static double dfYTM(double coupon, double price, double couponRate, double face, int years) {
        return (years + 1) * (couponRate + face) * Math.pow(coupon, years) - years * face * Math.pow(coupon, years - 1) - (couponRate + price);
    }

    public static double bondYTM(double coupon, int years, double face, double price) {

        // Use newton's method to calculate the yield
        // Source used: http://www.moneychimp.com/articles/finworks/fmbondytm.htm

        // coupon(1 + r)^-1 + coupon(1 + r)^-2 + . . . + coupn(1 + r)^-years + face(1 +
        // r)^-Years = Price
        // TODO; SOLVE FOR r


    

        BondInfoYield newBondYield = new BondInfoYield(coupon, years, face, price);

        if(mapperYield.get(newBondYield.toString()) == null){
            double couponRate = coupon * face;

            double epsilon = .00001;
    
            for (int i = 0; i < 100; i++) {
                if (Math.abs(fYTM(coupon, price, couponRate, face, years)) < epsilon) {
                    break;
                }
                while (Math.abs(dfYTM(coupon, price, couponRate, face, years)) < epsilon) {
                    coupon += .1;
                }
                coupon = coupon
                        - (fYTM(coupon, price, couponRate, face, years) / dfYTM(coupon, price, couponRate, face, years));
            }
            if (Math.abs(fYTM(coupon, price, couponRate, face, years)) >= epsilon) {
                return -1; // error
            }
            mapperYield.put(newBondYield.toString(), (1/coupon) - 1);
            return (1 / coupon) - 1;
        }
        else{
            return mapperYield.get(newBondYield.toString());
        }
         

       
    }

  
}
