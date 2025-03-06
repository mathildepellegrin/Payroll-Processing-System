public class EI extends Deductions{
    public double calculateTax(double salary){
        return Math.min(salary*0.0164, 1077.48);
    }
}
