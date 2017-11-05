import com.sun.codemodel.internal.JOp;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.awt.event.*;

public class MainWindow extends JFrame {

    ImWindow m = new ImWindow();
    SignUpWindow u = new SignUpWindow();
    LandingWindow l = new LandingWindow();
    StudentLandingWindow sl = new StudentLandingWindow();
    LogInWindow x = new LogInWindow();
    MesageWindow msg = new MesageWindow();
    Boolean FirstL = true;
    Boolean FirstUser = true;
    Boolean FirstCreate = true;
    Boolean FirstS = true;
    Boolean FirstFail = true;
    SubjectWindow s = new SubjectWindow();
    Boolean Tutor = false;
    Boolean Student = false;
    Boolean Studentactive = false;
    Tutor UserT = null;
    Student UserS = null;
    javax.swing.Timer timer;
    String Username = null;
    String UPass = null;
    String TempUsername, TempPassword, TempEmail;

    public MainWindow() {
        setLayout(new CardLayout());
        add(l.MainPanel);
        l.Visible = true;
        x.Visible = false;
        u.Visible = false;
        timer = new javax.swing.Timer(50, new MoveListener());
        timer.start();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
        u.btnSignup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (new File("src/assets/data/" + u.txtUsername.getText() + ".txt").exists()) {
                    JOptionPane.showMessageDialog(null,"Username is taken.");
                    u.txtPassword.setText("");
                    u.txtEmail.setText("");
                    u.txtUsername.setText("");
                }
                else {
                    u.Visible = false;
                    m.Visible = true;
                    remove(u.MainPanel);
                    add(m.MainPanel);
                    validate();
                    pack();
                    setVisible(true);
                    FirstL = false;
                    JOptionPane.showMessageDialog(null,"Account created successfully.");
                }
            }
        });
    }

    public void Update() {
        if (l.Visible) {
            l.btnLogin.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (FirstL) {
                        l.Visible = false;
                        x.Visible = true;
                        remove(l.MainPanel);
                        add(x.MainPanel);
                        validate();
                        pack();
                        setVisible(true);
                        FirstL = false;
                    }
                }
            });
            l.btnSignup.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (FirstCreate) {
                        l.Visible = false;
                        u.Visible = true;
                        remove(l.MainPanel);
                        add(u.MainPanel);
                        validate();
                        pack();
                        setVisible(true);
                    }
                }
            });
        }
        if (u.Visible) {
        }
        if (x.Visible) {
            x.btnLogin.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (FirstUser) {
                        try {
                            Scanner Freader = new Scanner(new File("src/assets/data/logins.txt"));
                            while (Freader.hasNextLine()) {
                                String[] SplitArr = Freader.nextLine().split(",");
                                if (SplitArr[0].equals(x.txtUsername.getText()) && SplitArr[1].equals(x.txtPassword.getText()) || SplitArr[2].equals(x.txtUsername.getText()) && SplitArr[1].equals(x.txtPassword.getText())) {
                                    UPass = x.txtPassword.getText();
                                    Username = SplitArr[0];
                                    x.txtUsername.setText("Login Successful");
                                    x.txtPassword.setText("Login Successful");
                                    FirstUser = false;
                                    if (SplitArr[2].equals("t")) {
                                        Tutor = true;
                                        break;
                                    } else {
                                        Student = true;
                                        break;
                                    }
                                }
                            }
                            if (!Tutor && !Student) {
                                x.txtUsername.setText("Login Failed");
                                x.txtPassword.setText("Login Failed");
                            }
                        } catch (IOException e1) {
                            System.err.println("File Error");
                        }
                    }
                }
            });
        }
        if (Student) {
            UserS = new Student("src/assets/data/"+Username+".txt");
            sl.Visible = true;
            x.Visible = false;
            remove(x.MainPanel);
            add(sl.MainPanel);
            validate();
            pack();
            setVisible(true);
            sl.btnActiveRequests.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                }
            });
            sl.btnGetHelp.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                }
            });
        }
        if(Studentactive){
            msg.Visible = true;
            sl.Visible = false;
            remove(sl.MainPanel);
            add(msg.MainPanel);
            validate();
            pack();
            setVisible(true);

        }
        //if (Tutor) {
      //      JOptionPane.showMessageDialog(null,UserT.toString());
       //     Tutor = false;
        //}
    }

    public void openmeetups(String path){
        ArrayList<String> arrin = new ArrayList<String>();
        ArrayList<Meetup> arrmeetings = new ArrayList<Meetup>();
        ArrayList<String> arrstudentnames = new ArrayList<String>();
        ArrayList<String> arrtutornames = new ArrayList<String>();
        Meetup temp = new Meetup();
        boolean detect = false;
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                arrin.add(line);
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(int i = 0;i<arrin.size();i++){
            String parts[] = arrin.get(i).split(",");
            temp.setType(parts[0]);
            temp.setLocation(parts[1]);
            for(int x = 2;x<parts.length;x++){
                if(parts[x].equals("+")){
                    detect = true;
                }
                else if(detect==false){
                    arrstudentnames.add(parts[x]);
                }
                else{
                    arrtutornames.add(parts[x]);
                }
            }
            temp.setArrstudents(arrstudentnames);
            temp.setArrtutors(arrtutornames);
            arrmeetings.add(temp);
        }
    }

    public void savestudent(String path, Student s){
        try(PrintWriter out = new PrintWriter(path)  ){
            out.println(s.toString());
            out.close();
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
    }

    public void savetutor(String path, Tutor t){
        try(PrintWriter out = new PrintWriter(new File(path))){
            out.println(t.toString());
            out.close();
        }catch(FileNotFoundException e1){
            e1.printStackTrace();
        }
    }

    public void savemeetings(String paths, ArrayList<Meetup> arrmeetings){
        try(PrintWriter out = new PrintWriter(new File(paths))){
            for(int i = 0;i<arrmeetings.size();i++){
                out.println(arrmeetings.get(i).toString());
            }
            out.close();
        } catch (FileNotFoundException e1){
            e1.printStackTrace();
        }
    }

    private class MoveListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            Update();
        }


    }
}
