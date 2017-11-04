import java.util.ArrayList;

public class tutor {
    private Credentials c;
    private ArrayList<Subject> arrsub = new ArrayList<Subject>();

    tutor()
    {
        c = new Credentials();
        arrsub = new ArrayList<Subject>();
    }

    public Credentials getC() {
        return c;
    }

    public ArrayList<Subject> getArrsub() {
        return arrsub;
    }

    public void setC(Credentials c)
    {
        this.c = c;
    }

    public void setArrsub(ArrayList<Subject> arrsub)
    {
        this.arrsub = arrsub;
    }
}
