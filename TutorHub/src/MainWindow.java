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
    LogInWindow x = new LogInWindow();
    Boolean FirstL = true;
    Boolean FirstUser = true;
    Boolean FirstS = true;
    Boolean FirstFail = true;
    SubjectWindow s = new SubjectWindow();
    Boolean Tutor = false;
    Boolean Student = false;
    Tutor UserT = null;
    Student UserS = null;
    javax.swing.Timer timer;

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
                    FirstFail = true;
                    if (FirstUser) {
                        try {
                            Scanner Freader = new Scanner(new File("src/assets/data/logins.txt"));
                            while (Freader.hasNextLine()) {
                                String[] SplitArr = Freader.nextLine().split(",");
                                if (SplitArr[0].equals(x.txtUsername.getText()) && SplitArr[1].equals(x.txtPassword.getText())) {
                                    JOptionPane.showMessageDialog(null,"Login Successful");
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
                        } catch (IOException e1) {
                            System.err.println("File Error");
                        }
                    }
                }
            });
        }
        if (FirstFail && x.Visible) {
            x.txtUsername.setText("");
            x.txtPassword.setText("");
            JOptionPane.showMessageDialog(null,"Login Failed");
            FirstFail = false;
        }
        if (Tutor) {
            JOptionPane.showMessageDialog(null,UserT.toString());
            Tutor = false;
        }
    }


    private class MoveListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            Update();
        }


    }
}
