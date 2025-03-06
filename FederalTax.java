public class FederalTax extends Deductions{
    public double calculateTax(double salary){
        if (salary>253414){
            return salary*0.33;
        }
        else if (salary>177882){
            return salary*0.29;
        }
        else if (salary>114750){
            return salary*0.26;
        }
        else if (salary>57375){
            return salary*0.205;
        }
        else if (salary>16129){
            return salary*0.15;
        }
        return 0;
    }
}
