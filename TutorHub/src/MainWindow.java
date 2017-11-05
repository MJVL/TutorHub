import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;

public class MainWindow extends JFrame {

    ImWindow m = new ImWindow();
    SignUpWindow u = new SignUpWindow();
    LandingWindow l = new LandingWindow();
    LogInWindow x = new LogInWindow();
    Boolean FirstL = true;
    SubjectWindow s = new SubjectWindow();
    Boolean Tutor = false;
    Tutor UserT;
    Student UserS;
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
                    l.Visible = false;
                    u.Visible = true;
                    remove(l.MainPanel);
                    add(u.MainPanel);
                    validate();
                    pack();
                    setVisible(true);
                }
            });
        }
        if (x.Visible) {
            x.btnLogin.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) { ;
                    Tutor = true;
                }
            });
        }
        if (Tutor) {
            UserT = new Tutor();
            UserT.setC(new Credentials(x.txtUsername.getText(),x.txtPassword.getText()));
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
