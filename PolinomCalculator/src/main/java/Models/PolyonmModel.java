package Models;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PolyonmModel {
    private Polynom polynomA;
    private Polynom polynomB;
    private final String regexL1 = "(-?\\b\\d+)[xX]\\^(-?\\d+\\b)";
    private final String regexL3 = "[xX]\\^(-?\\d+\\b)";
    private final String regexL2 = "(-?\\b\\d+)[xX]";
    private final String mainRegex = "([+-]?[^-+]+)";

    public PolyonmModel(Polynom polynomA, Polynom polynomB) {
        this.polynomA = polynomA;
        this.polynomB = polynomB;
    }

    public PolyonmModel() {
        polynomA = new Polynom();
        polynomB = new Polynom();
    }

    public Polynom getPolynomA() {
        return polynomA;
    }

    public void setPolynomA(Polynom polynomA) {
        this.polynomA = polynomA;
    }

    public Polynom getPolynomB() {
        return polynomB;
    }

    public void setPolynomB(Polynom polynomB) {
        this.polynomB = polynomB;
    }

    public Polynom constructPolynom(String inputa){
        Polynom result = new Polynom();
        Pattern patternMain = Pattern.compile(mainRegex);
        Matcher matcherMain = patternMain.matcher(inputa);

        while(matcherMain.find()){
            //System.out.println(matA.group(1));
            Monom monom;
            Pattern patt = Pattern.compile(regexL1);
            Matcher mat = patt.matcher(matcherMain.group(1));
            if (mat.find()) {
                ///forma principala cu putere gen -4x^3
                int coef = Integer.valueOf(mat.group(1));
                int pow = Integer.valueOf(mat.group(2));
                monom = new Monom(pow, coef);
            } else{

                Pattern pattt = Pattern.compile(regexL3);
                Matcher matt = pattt.matcher(matcherMain.group(1));
                if (matt.find()) {
                    int pow = Integer.valueOf(matt.group(1));
                    monom = new Monom(pow,1);
                }else{
                    /// forma fara putere gen -4x
                    Pattern p = Pattern.compile(regexL2);
                    Matcher m = p.matcher(matcherMain.group(1));
                    if (m.find()) {
                        int coef = Integer.parseInt(m.group(1));
                        monom = new Monom(1, coef);
                    }else{
                        int coef = Integer.valueOf(matcherMain.group(1));
                        monom = new Monom(0, coef);
                    }
                }
            }
            result.addMonom(monom);
        }
        result.format();
        result.sortAsc();
        return result;
    }

    public void add(){
        polynomA.add(polynomB);
        polynomA.sortDesc();
    }

    public void diff(){
        polynomA.diff(polynomB);
        polynomA.sortDesc();
    }

    public Polynom mul(){
        Polynom rez = polynomA.mul(polynomB);
        rez.sortDesc();
        return rez;

    }

    public void deriv(){
        polynomA.deriv();
        polynomA.sortDesc();
    }

    public void integrate(){
        polynomA.integrate();
        polynomA.sortDesc();
    }



}
