import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class WelcomeFrame{

    private float totalPrice = 0;
    private float downPay = 0;
    private float rateVal = 0;
    private int periodVal = 0;
    private JTextField[] a = new JTextField[5];
    private byte count = 0;

    public WelcomeFrame(){
        JFrame frame = new JFrame();
        frame.setSize(700, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTabbedPane jTab = new JTabbedPane();

        jTab.add("Calculate Monthly Payment", firstTab());
        jTab.add("Early Payment Calculations", secondTab());

        frame.add(jTab);
        frame.setVisible(true);
    }

    private JPanel firstTab(){
        JPanel panelBuy = this.customPanel1("Buying Price: $", "Enter Buying Price Here");
        a[0].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                a[0].setText("");
            }
        });

        JPanel panelDownPay = this.customPanel1("Down Payment: $", "Enter Down Payment Here");
        a[1].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                a[1].setText("");
            }
        });

        JPanel panelInt = this.customPanel1("Interest Rate in Percent:", "Enter Interest Rate in Percent Here");
        a[2].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                a[2].setText("");
            }
        });
        JLabel percent = new JLabel("%");
        panelInt.add(percent);

        JPanel panelPer = this.customPanel1("Period in Years:", "Enter Period in Years Here");
        a[3].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                a[3].setText("");
            }
        });
        JLabel years = new JLabel("Years");
        panelPer.add(years);

        JPanel panelResult1 = new JPanel();
        panelResult1.setLayout(new GridLayout(2,1));
        JLabel result1 = new JLabel("Monthly Payments: $");
        result1.setVisible(false);
        JButton calc = new JButton("Calculate");
        calc.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                totalPrice = Float.parseFloat(a[0].getText());
                downPay = Float.parseFloat(a[1].getText());
                rateVal = Float.parseFloat(a[2].getText());
                periodVal = Integer.parseInt(a[3].getText());

                Calculate calcPayment = new Calculate();
                String val = calcPayment.calMonthlyPayment(totalPrice, downPay, rateVal, periodVal);
                result1.setText("Monthly Payments: " + val);
                result1.setVisible(true);
            }
        });
        panelResult1.add(calc);
        panelResult1.add(result1);

        //Set Panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6,1));
        panel.add(new JLabel("Calculates Monthly Payment."));
        panel.add(panelBuy);
        panel.add(panelDownPay);
        panel.add(panelInt);
        panel.add(panelPer);
        panel.add(panelResult1);
        return panel;
    }

    private JPanel secondTab(){
        JPanel periodPanel = this.customPanel1("Period in Years:", "Enter Period in Years Here You Wish to Payoff the Loan by");
        a[4].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                a[4].setText("");
            }
        });
        JLabel yearsLabel = new JLabel("Years");
        periodPanel.add(yearsLabel);

        JPanel panelResult = new JPanel();
        panelResult.setLayout(new GridLayout(2,1));
        JLabel result = new JLabel("Monthly Payments: $" + " Compared to $");

        result.setVisible(false);
        JButton calc = new JButton("Calculate");
        calc.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Calculate calcPayment = new Calculate();
                String val = calcPayment.calMonthlyPayment(totalPrice, downPay, rateVal, Integer.parseInt(a[4].getText()));
                result.setText("Monthly Payments: " + val);
                result.setVisible(true);
            }
        });
        panelResult.add(calc);
        panelResult.add(result);

        //Set Panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3,1));
        panel.add(new JLabel("Calculates Monthly Payment Based on Desired Payment Period."));
        panel.add(periodPanel);
        panel.add(panelResult);
        return panel;
    }

    private JPanel customPanel1(String labelText, String fieldText){
        JPanel panel = new JPanel();
        JLabel label = new JLabel(labelText);
        a[count] = new JTextField(fieldText);
        panel.add(label);
        panel.add(a[count]);
        count++;
        return panel;
    }
}
