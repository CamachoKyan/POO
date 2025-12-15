import javax.swing.*;
import java.awt.event.*;

public class P2 extends JFrame {
    private JButton btn1;
    private JButton btn3;
    private JPanel P2Frame;

    private JFrame Parent;
    public P2(JFrame P){
        setTitle("P2");
        setContentPane(P2Frame);
        setVisible(true);
        setLocationRelativeTo(null);
        setSize(350,250);

        Parent = P;

        JFrame self = this;

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("CHAOS");

                dispose();

                Parent.setVisible(true);

            }
        });

        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Parent instanceof P1){
                    dispose();
                    Parent.setVisible(true);
                }else{
                    P1 p1 = new P1(self);
                    setVisible(false);
                    p1.setVisible(true);
                    try {
                        Parent.dispose();
                    } catch (Exception ex) {
                        System.out.println("No tiene papa");
                    }

                }
            }
        });

        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Parent instanceof P3){
                    dispose();
                    Parent.setVisible(true);
                }else{
                    P3 p3 = new P3(self);
                    setVisible(false);
                    p3.setVisible(true);
                    try {
                        Parent.dispose();
                    } catch (Exception ex) {
                        System.out.println("No tiene papa");
                    }

                }
            }
        });
    }
}