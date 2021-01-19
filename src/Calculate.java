import java.text.NumberFormat;

public class Calculate {
    private float totalCost = 0;
    private float downPayment = 0;
    private float annualRate = 0;
    private int periodYears = 0;

    public Calculate(float totalCost, float downPayment, float annualRate, int periodYears){
        setTotalCost(totalCost);
        setDownPayment(downPayment);
        setAnnualRate(annualRate);
        setPeriodYears(periodYears);
    }

    public String calMonthlyPayment(){
        final byte MONTHS_PER_YEAR = 12;
        final byte PERCENT_TOTAL = 100;

        System.out.println(totalCost);
        System.out.println(downPayment);
        System.out.println(annualRate);
        System.out.println(periodYears);

        float principle = totalCost-downPayment;
        float r = (annualRate/PERCENT_TOTAL)/MONTHS_PER_YEAR;                                //Monthly Rate
        int n = periodYears*MONTHS_PER_YEAR;                                                 //Number of Payments

        double mortgage = principle*((r*Math.pow(1+r,n))/(Math.pow(1+r,n)-1));
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        return mortgageFormatted;
    }

    private void setTotalCost(float totalCost) {
        this.totalCost = totalCost;
    }

    private void setDownPayment(float downPayment) {
        this.downPayment = downPayment;
    }

    private void setPeriodYears(int periodYears) {
        this.periodYears = periodYears;
    }

    private void setAnnualRate(float annualRate) {
        this.annualRate = annualRate;
    }
}
