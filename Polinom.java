import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class CompPutereMonom implements Comparator<Monom> {
    public int compare(Monom m1, Monom m2) {
        return m2.getPutere() - m1.getPutere();
    }
}
public class Polinom{
    private List<Monom> termeni = new ArrayList<Monom>();

    public Polinom(){

    }
    public void addTermen(Monom x){
        if(x.getCoeficient() != 0){
            if(!calcPolinom(x)) this.termeni.add(x); //adaugam un nou termen polinomului final
            Collections.sort(termeni, new CompPutereMonom());
        }
    }

    @Override
    public String toString() {
        String display = new String();
        int count = 0;
        for (Monom m:termeni) {
                display += m.toString();
        }
        return display;
    }
    public boolean calcPolinom(Monom x){
        boolean state = false;
        for (Monom m:this.termeni) {
            if(m.getPutere() == x.getPutere()){
                m.setCoeficient(x.getCoeficient() + m.getCoeficient());
                state = true;
            }
        }
        return state;
    }
    public int grad(){ return this.termeni.get(0).getPutere();  }
    public void adunaPolinom(Polinom p){
        for (Monom m: p.termeni) {
            this.addTermen(m);
        }
    }
    public void scadePolinom(Polinom p){
        for (Monom m: p.termeni) {
            m.setCoeficient(-m.getCoeficient());
            this.addTermen(m);
        }
    }
    public void multPolinom(Polinom p){
        List<Monom> rez = new ArrayList<Monom>();
        for (Monom m1: this.termeni) {
            for (Monom m2: p.termeni) {
                rez.add(new Monom(m1.getCoeficient() * m2.getCoeficient(),m1.getPutere() + m2.getPutere()));
            }
        }
        this.termeni = rez;
        Collections.sort(termeni, new CompPutereMonom());
    }
    public ArrayList<Polinom> divPolinom(Polinom p){
        ArrayList<Polinom> rezultat = new ArrayList<>();
        Polinom cat = new Polinom();
        Polinom rest = this;
        Monom interm;
        if(this.grad() < p.grad()) //se imparte polinomul mai mare la cel mai mic
            p.divPolinom(this);
        else{
            interm =  new Monom(this.termeni.get(0).getCoeficient() / p.termeni.get(0).getCoeficient(), this.termeni.get(0).getPutere() - p.termeni.get(0).getPutere());
            cat.addTermen(interm);
            p.multPolinom(cat);
            rest.scadePolinom(p);
            if(rest.grad() < p.grad()) {
                rezultat.add(rest);
                rezultat.add(cat);
                return rezultat;
            }
            this.divPolinom(p);
        }
        return rezultat;
    }
    public void deriveaza(){
        for (Monom m: this.termeni) {
            m.setCoeficient(m.getCoeficient() * Math.abs(m.getPutere()));
            m.setPutere(m.getPutere() - 1);
        }
    }
    public void integrare(){
        for (Monom m: this.termeni) {
            int putereImpartire = Math.abs(m.getPutere()+1); //pentru a evita division by 0
            if(putereImpartire != 0){
                m.setCoeficient((m.getCoeficient()) / Math.abs(m.getPutere()+1));
            }
            m.setCoeficient((m.getCoeficient()));
            m.setPutere(m.getPutere() + 1);
        }
    }
}
