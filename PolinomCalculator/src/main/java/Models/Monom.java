package Models;

public class Monom {
    private int power;
    private int coeficent;
    private int denominator;

    public Monom(int power, int coeficent, int denominator) {
        this.power = power;
        this.coeficent = coeficent;
        this.denominator = denominator;
    }

    public Monom(int power, int coeficent){
        this.power = power;
        this.coeficent = coeficent;
        this.denominator = 1;
    }

    public Monom() {
        this.power = 0;
        this.coeficent = 0;
        this.denominator = 1;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getCoeficent() {
        return coeficent;
    }

    public void setCoeficent(int coeficent) {
        this.coeficent = coeficent;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public void add(Monom ext){
        if(this.power == ext.getPower())
            this.coeficent += ext.getCoeficent();
        else
            System.out.println("Monom.add() -> mismatched powers" + this.getPower() + " " + this.coeficent + " " + ext.getPower() + " " + ext.getCoeficent());

    }
    public void diff(Monom ext){
        if(this.power == ext.getPower()){
            this.coeficent -= ext.getCoeficent();
        }
    }

    public Monom mul(Monom ext){
        Monom result = new Monom();
        result.setCoeficent(this.coeficent * ext.getCoeficent());
        result.setPower(this.power + ext.getPower());
        return result;
    }

    public Monom div(Monom ext){
        Monom result = new Monom();
        result.setCoeficent(this.coeficent / ext.getCoeficent());
        result.setPower(this.power - ext.getPower());
        return result;
    }

    public void deriv() {
        if (this.coeficent != 0) {
            this.coeficent *= this.power;
            this.power--;
        }
    }
    public void integrate(){
        if (this.coeficent != 0) {
            this.denominator = this.power + 1;
            this.power++;
        }
    }

    private void simplyfy(){
        int a = coeficent;
        int b = denominator;
        if(denominator == 1 || a < 0 || b < 0)
            return;
        if (a%b == 0) {
            a = a/b;
            b = 1;
        }else {
            int ca = a;
            int cb = b;
            while (a != b)
                if (a > b)
                    a = a - b;
                else
                    b = b - a;
            a = ca / a;
            b = cb / b;

        }
        coeficent = a ;
        denominator = b;
    }

    public String toString(){
        String result = new String("");
        if (coeficent == 0)
            return result;
        simplyfy();
        if (this.denominator == 1)
            result = result + this.coeficent;
        else{
            result = result + "(" + this.coeficent + "/" + this.denominator + ")";
        }
        if (power > 1)
            result = result + "X^" + this.power;
        if (power == 1)
            result = result + "X";
        return result;
    }

    public Monom inv() {
        Monom result = new Monom(power, -coeficent);
        return result;
    }

}
