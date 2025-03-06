public class ProvincialIncomeTax extends Deductions{
    public double  calculateTax(double salary){
        if (salary>129590){
            return salary*0.2575;
        }
        else if (salary>106495){
            return salary*0.24;
        }
        else if (salary>53225){
            return salary*0.19;
        }
        else if (salary>18571){
            return salary*0.14;
        }
        return 0;
    }
}
