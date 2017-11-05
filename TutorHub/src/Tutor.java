import java.util.ArrayList;
import java.io.*;

public class Tutor {
    private ArrayList<Subject> arrsub = new ArrayList<Subject>();
    private int numrequested, numattended, hours;

    public Tutor() {
        arrsub = new ArrayList<Subject>();
        hours = 0;
        numrequested = 0;
        numattended = 0;
    }

    public Tutor(String path){
        String arrin = "";
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                arrin = line;
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String parts[] = arrin.split(",");
        hours = Integer.valueOf(parts[0]);
        numattended = Integer.valueOf(parts[1]);
        numrequested = Integer.valueOf(parts[2]);
        for(int x = 3;x<parts.length;x++){
            arrsub.add(new Subject(parts[x]));
        }
    }

<<<<<<< HEAD

=======
>>>>>>> a747f882aabab9ffcce80ec440c4019108de5c48
    public ArrayList<Subject> getArrsub() {
        return arrsub;
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
<<<<<<< HEAD
=======
        out = hours + "," + numattended + "," + numrequested;
>>>>>>> a747f882aabab9ffcce80ec440c4019108de5c48
        for(int i = 0;i<arrsub.size();i++) {
            out += "," + arrsub.get(i).toString();
        }
        return out;
    }
}