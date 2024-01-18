import java.util.Arrays;

public class TaxCalculator {
    int[] taxBoundaries = {12570, 50270, 125140};
    double[] taxBrackets = {0, 0.2, 0.4, 0.45};
    double salary;
    double taxDue;

    public TaxCalculator(double wage){
        salary = wage;
        taxDue  = taxDue();

    }

    public void updateSalary(int wage){
        salary = wage;
        taxDue = taxDue();

    }

    public double taxDue(){
        double tempSalary = salary;
        double toPay = 0;
        for (int i = taxBoundaries.length; i > 0; i--){
            if (tempSalary > taxBoundaries[i-1]){
                toPay = toPay + (tempSalary-taxBoundaries[i-1])*taxBrackets[i];
                tempSalary = taxBoundaries[i-1];
            }
        }
        taxDue = toPay;
        return toPay;
    }





    public static void main(String[] args){
        TaxCalculator calculate = new TaxCalculator(43731);
        System.out.println(calculate.taxDue);
        calculate.updateSalary(50000);
        System.out.println(calculate.taxDue);






    }


}
