import java.util.ArrayList;
import java.io.*;

public class Student {
    private ArrayList<Question> arrquestion = new ArrayList<Question>();
    private int numrequested, numattended;

    public Student() {
        arrquestion = new ArrayList<Question>();
        numrequested = 0;
        numattended = 0;
    }

    public Student(String path){
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
        numattended = Integer.valueOf(parts[0]);
        numrequested = Integer.valueOf(parts[1]);
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

    public String toString() {
        String out = "";
        out = numattended + "," + numrequested;
        for (int i = 0; i < arrquestion.size();i++) {
            out += "," + arrquestion.get(i).toString();
        }
        return out;
    }
}