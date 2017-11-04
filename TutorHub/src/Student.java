import java.util.ArrayList;
import java.io.*;

public class Student {

    private Credentials c;
    private ArrayList<Subject> arrsub = new ArrayList<Subject>();
    private int numrequested, numattended;

    public Student() {
        c = new Credentials();
    }

    public Student(String path){
        String arrin[] = new String[100];
        int i=0;
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                arrin[i] = line;
                i++;
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

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

    public int getNumrequested(){
        return numrequested;
    }

    public int getNumattended(){
        return numattended;
    }

    public void setNumattended(int numattended) {
        this.numattended = numattended;
    }

    public void setNumrequested(int numrequested) {
        this.numrequested = numrequested;
    }

    public double attendencerate(){
        return (numattended/numrequested*100);
    }

    public String toString()
    {
        String out = "";
        out = c.toString() + "," + numattended + "," + numrequested;
        for (int i = 0; i < arrsub.size();i++) {
            out += "," + arrsub.get(i).toString();
        }
        return out;
    }
}