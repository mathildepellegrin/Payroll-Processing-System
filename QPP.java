public class QPP extends Deductions{
    public double calculateTax(double salary){
        return Math.min(salary*0.108, 7700.40);
    }
}
