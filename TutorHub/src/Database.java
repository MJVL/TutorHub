import javax.swing.*;
import java.util.ArrayList;
import java. io.*;

public class Database {

    //you will have to add the 'filename.txt'

    public String getpath(){
        File arrfile[] = new File("C:\\Users").listFiles();
        String path = "";
        String name = "";
        for(int i = 0;i<arrfile.length;i++){
            name = JOptionPane.showInputDialog("Are you this user? "+arrfile[i].getName());
            if (name.equals("yes")){
                path = "C:\\Users\\"+arrfile[i].getName()+"\\OneDrive\\";
                break;
            }
        }
        return path;
    }
}
