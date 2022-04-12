package Models;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class Polynom {

    private ArrayList<Monom> polynom;
    private int maxPow;

    public Polynom(ArrayList<Monom> polynom) {
        this.polynom = polynom;
    }

    public Polynom() {
        polynom = new ArrayList<Monom>();
        maxPow = 0;
    }

    public void sortAsc() {
        polynom.sort(new Comparator<Monom>() {
            public int compare(Monom o1, Monom o2) {
                if(o1.getPower() < o2.getPower())
                    return -1;
                if (o1.getPower() > o2.getPower()){
                    return 1;
                }
                return 0;
            }
        });
    }

    public void sortDesc() {
        polynom.sort(new Comparator<Monom>() {
            public int compare(Monom o1, Monom o2) {
                if(o1.getPower() < o2.getPower())
                    return 1;
                if (o1.getPower() > o2.getPower()){
                    return -1;
                }
                return 0;
            }
        });
    }

    public String toString(){
        String result = new String("");
        int ok = 1;
        for (Monom token: polynom) {
            if (ok == 0)
                if (token.getCoeficent() > 0)
                    result = result + " +";
                if(token.getCoeficent() < 0)
                    result += " ";
             result = result + token.toString();
             ok = 0;
        }
        return result;
    }

    public void addMonom(Monom x){
        polynom.add(x);
        if (x.getPower() > maxPow)
            maxPow = x.getPower();
    }

    public void add(Polynom ext){

        Iterator<Monom> iteratorA = polynom.iterator();
        Iterator<Monom> iteratorB = ext.polynom.iterator();

        while(iteratorA.hasNext() && iteratorB.hasNext()) {
            iteratorA.next().add(iteratorB.next());
        }
        while(iteratorB.hasNext()){
            this.addMonom(iteratorB.next());
        }
    }

    public void diff(Polynom ext){

        Iterator<Monom> iteratorA = polynom.iterator();
        Iterator<Monom> iteratorB = ext.polynom.iterator();

        while(iteratorA.hasNext() && iteratorB.hasNext()) {
            iteratorA.next().diff(iteratorB.next());
        }
        while(iteratorB.hasNext()){
            this.addMonom(iteratorB.next().inv());
        }
    }

    public Polynom mul(Polynom ext){

        Polynom result = new Polynom();

        for (Monom tokenA: polynom) {
            for (Monom tokenB: ext.polynom) {
                Monom X = tokenA.mul(tokenB);
                result.addMonom(X);
            }
        }
        return result;
    }

    public Polynom div(Polynom ext){
        return null;
    }

    public void deriv(){
        int ok = 0;
        for(Monom index: polynom){
            index.deriv();
            if (index.getPower() == -1)
                ok = 1;
        }
        if (ok == 1)
            polynom.remove(0);

    }
    public void integrate(){
        for(Monom index: polynom){
            index.integrate();
        }
    }

    public void format(){
        ArrayList<Monom> bucket = new ArrayList<Monom>();;
        int index = 0;
        this.sortAsc();
        for(Monom token: polynom){
                while(index < token.getPower()) {
                    Monom q = new Monom(index, 0);
                    bucket.add(q);
                    index++;
                }
                index++;
        }
        this.polynom.addAll(bucket);
        this.sortAsc();
        for(Monom token: polynom){
            System.out.println(token.toString());
        }
    }
}
