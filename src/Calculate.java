import java.text.NumberFormat;

public class Calculate {
    public Calculate(){
    }

    public String calMonthlyPayment(float totalCost, float downPayment, float annualRate, int periodYears){
        final byte MONTHS_PER_YEAR = 12;
        final byte PERCENT_TOTAL = 100;

        float principle = totalCost-downPayment;

        float r = (annualRate/PERCENT_TOTAL)/MONTHS_PER_YEAR;                                //Monthly Rate
        int n = periodYears*MONTHS_PER_YEAR;                                                 //Number of Payments

        double mortgage = principle*((r*Math.pow(1+r,n))/(Math.pow(1+r,n)-1));

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        return mortgageFormatted;
    }

    private String calEarlyMonthlyPayment() {
        String mortgageVal = "";
        return mortgageVal;
    }
}
