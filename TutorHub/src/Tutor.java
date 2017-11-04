import java.util.ArrayList;

public class Tutor {
    private Credentials c;
    private ArrayList<Subject> arrsub = new ArrayList<Subject>();
    private int numrequested, numattended;

    public Tutor() {
        c = new Credentials();
        arrsub = new ArrayList<Subject>();
    }

    public Credentials getC() {
        return c;
    }

    public ArrayList<Subject> getArrsub() {
        return arrsub;
    }

    public void setC(Credentials c) {
        this.c = c;
    }

    public void setArrsub(ArrayList<Subject> arrsub) {
        this.arrsub = arrsub;
    }

    public int getNumrequested(){
        return numrequested;
    }

    public int getNumattended(){
        return numattended;
    }

    public void setNumrequested(int numrequested) {
        this.numrequested = numrequested;
    }

    public void setNumattended(int numattended) {
        this.numattended = numattended;
    }

    public double attendence(){
        return (numattended/numrequested*100);
    }

    public String toString()
    {
        String out = "";
        out = c.toString();
        for(int i = 0;i<arrsub.size();i++) {
            out += arrsub.get(i).toString();
        }
        return out;
    }
}