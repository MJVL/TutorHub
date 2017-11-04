import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame{

    ImWindow m = new ImWindow();
    SignUpWindow u = new SignUpWindow();
    LandingWindow l = new LandingWindow();
    LogInWindow x = new LogInWindow();
    SubjectWindow s = new SubjectWindow();

    public MainWindow() {
        setLayout(new CardLayout());
        add(l.MainPanel);
        l.Visible = true;
        if (l.Visible) {
            l.btnLogin.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    remove(l.MainPanel);
                    add(x.MainPanel);
                    validate();
                    pack();
                    setVisible(true);
                }
            });
        }
        l.btnSignup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                remove(l.MainPanel);
                add(u.MainPanel);
                validate();
                pack();
                setVisible(true);
            }
        });
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }


}
