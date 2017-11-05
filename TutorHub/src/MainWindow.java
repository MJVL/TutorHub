import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
                    if (FirstL) {
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
        if (x.Visible) {
            x.btnLogin.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (FirstUser) {
                        try {
                            Scanner Freader = new Scanner(new File("src/assets/data/logins.txt"));
                            while (Freader.hasNextLine()) {
                                String[] SplitArr = Freader.nextLine().split(",");
                                if (SplitArr[0].equals(x.txtUsername.getText()) && SplitArr[1].equals(x.txtPassword.getText())) {
                                    UPass = x.txtPassword.getText();
                                    Username = x.txtUsername.getText();
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


    private class MoveListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            Update();
        }


    }
}
