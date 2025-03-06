public class QPIP extends Deductions{
    public double calculateTax(double salary){
        return Math.min(salary*0.00494, 484.12);
    }
}
