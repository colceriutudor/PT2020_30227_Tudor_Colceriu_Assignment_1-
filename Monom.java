public class Monom {
    private double coeficient;
    private int putere;

    public Monom(double coeficient,int putere){
        this.coeficient = coeficient;
        this.putere = putere;
    }
    @Override
    public String toString() {
        if(coeficient == 0) return "";
        if(putere == 0) if (coeficient > 0) return "+" + coeficient;
        else return "" + coeficient;
        else if(putere==1){
            if(coeficient == 1) return "+x";
            else if(coeficient == -1) return "-x";
            else if(coeficient > 0) return "+" + coeficient + "x";
            else if (coeficient < 0) return coeficient + "x";
            return coeficient + "";
        }
        else {
            if(coeficient == 1) return "+x" + "^" + putere;
            else if(coeficient == -1) return "-x" + "^" + putere;
            else if(coeficient > 0) return "+" + coeficient + "x" + "^" + putere;
            else if (coeficient < 0) return coeficient + "x" + "^" + putere;
            return coeficient + "";
        }
    }

    public double getCoeficient() {
        return coeficient;
    }
    public int getPutere() { return putere;  }
    public void setCoeficient(double coeficient) {
        this.coeficient = coeficient;
    }
    public void setPutere(int putere) {
        this.putere = putere;
    }

    public String semn(boolean fsign){
        if(coeficient < 0) return "-";
        else if(fsign) return "+ ";
        else return "";
    }
    public Monom addMonom(Monom m){
        if(this.putere != m.putere){
            System.out.println("Monoamele nu sunt de acelasi grad");
            return null;
        }else return new Monom(this.coeficient + m.getCoeficient(), this.getPutere());
    }
    public Monom subMonom(Monom m){
        if(this.putere != m.putere){
            System.out.println("Monoamele nu sunt de acelasi grad");
            return null;
        }else return new Monom(this.coeficient - m.getCoeficient(), this.getPutere());
    }
}
