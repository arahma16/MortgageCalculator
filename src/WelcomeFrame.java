import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class WelcomeFrame extends JFrame{
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
        JPanel panelBuy = new JPanel();
        JLabel buyingPriceLabel = new JLabel("Buying Price: $");
        JTextField bArea = new JTextField("Enter Buying Price Here");
        bArea.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                bArea.setText("");
            }
        });
        panelBuy.add(buyingPriceLabel);
        panelBuy.add(bArea);


        JPanel panelDownPay = new JPanel();
        JLabel downPaymentLabel = new JLabel("Down Payment: $");
        JTextField dArea = new JTextField("Enter Down Payment Here");
        dArea.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dArea.setText("");
            }
        });
        panelDownPay.add(downPaymentLabel);
        panelDownPay.add(dArea);


        JPanel panelInt = new JPanel();
        JLabel interestRate = new JLabel("Interest Rate in Percent:");
        JTextField iArea = new JTextField("Enter Interest Rate in Percent Here");
        iArea.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                iArea.setText("");
            }
        });
        JLabel percent = new JLabel("%");
        panelInt.add(interestRate);
        panelInt.add(iArea);
        panelInt.add(percent);

        JPanel panelPer = new JPanel();
        JLabel period = new JLabel("Period in Years:");
        JTextField pArea = new JTextField("Enter Period in Years Here");
        pArea.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                pArea.setText("");
            }
        });
        JLabel years = new JLabel("Years");
        panelPer.add(period);
        panelPer.add(pArea);
        panelPer.add(years);

        JPanel panelResult1 = new JPanel();
        panelResult1.setLayout(new GridLayout(2,1));
        JLabel result1 = new JLabel("Monthly Payments: $");
        result1.setVisible(false);
        JButton calc = new JButton("Calculate");
        calc.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Calculate calcPayment = new Calculate();
                String val = calcPayment.calMonthlyPayment(Float.parseFloat(bArea.getText()), Float.parseFloat(dArea.getText()),
                        Float.parseFloat(iArea.getText()), Integer.parseInt(pArea.getText()));
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
        JPanel periodPanel = new JPanel();
        JLabel period = new JLabel("Period in Years:");
        JTextField periodArea = new JTextField("Enter Period in Years Here You Wish to Payoff the Loan by");
        periodArea.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                periodArea.setText("");
            }
        });
        JLabel yearsLabel = new JLabel("Years");
        periodPanel.add(period);
        periodPanel.add(periodArea);
        periodPanel.add(yearsLabel);

        JPanel panelResult = new JPanel();
        panelResult.setLayout(new GridLayout(2,1));
        JLabel result = new JLabel("Monthly Payments: $" + " Compared to $");
        result.setVisible(false);
        JButton calc = new JButton("Calculate");
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

}
