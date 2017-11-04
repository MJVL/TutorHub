import java.util.ArrayList;

public class Student {
    private Credentials c;
    private ArrayList<Subject> arrsub = new ArrayList<Subject>();

    public Student() {
        c = new Credentials();
    }

    public Credentials getC() {
        return c;
    }

    public ArrayList<Subject> getArrsub() {
        return arrsub;
    }

    public void setArrsub(ArrayList<Subject> arrsub) {
        this.arrsub = arrsub;
    }

    public void setC(Credentials c) {
        this.c = c;
    }

    public String toString()
    {
        String out = "";
        out = arrsub.get(0).toString();
        for (int i = 1; i < arrsub.size();i++) {
            out += "," + arrsub.get(i).toString();
        }
        return out;
    }
}