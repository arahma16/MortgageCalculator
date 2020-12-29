import javax.swing.*;
import java.awt.*;

public class WelcomeFrame extends JFrame{
    public WelcomeFrame(){
        JFrame frame = new JFrame();
        frame.setSize(500, 600);

        JTabbedPane jTab = new JTabbedPane();

        JPanel panelBuy = new JPanel();
        JLabel buyingPriceLabel = new JLabel("Buying Price: $");
        JTextField bArea = new JTextField("Enter Buying Price Here");
        panelBuy.add(buyingPriceLabel);
        panelBuy.add(bArea);

        JPanel panelDown = new JPanel();
        JLabel downPaymentLabel = new JLabel("Down Payment: $");
        JTextField dArea = new JTextField("Enter Down Payment Here");
        panelDown.add(downPaymentLabel);
        panelDown.add(dArea);

        JPanel panelInt = new JPanel();
        JLabel interestRate = new JLabel("Interest Rate in Percent:");
        JTextField iArea = new JTextField("Enter Interest Rate in Percent Here");
        JLabel percent = new JLabel("%");
        panelInt.add(interestRate);
        panelInt.add(iArea);
        panelInt.add(percent);

        JPanel panelPer = new JPanel();
        JLabel period = new JLabel("Period in Years:");
        JTextField pArea = new JTextField("Enter Period in Years Here");
        JLabel years = new JLabel("Years");
        panelPer.add(period);
        panelPer.add(pArea);
        panelPer.add(years);

        JPanel panelResult1 = new JPanel();
        panelResult1.setLayout(new GridLayout(2,1));
        JButton calc = new JButton("Calculate");
        JLabel result1 = new JLabel("Monthly Payments: $");
        panelResult1.add(calc);
        panelResult1.add(result1);

        //First Page
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5,1));
        panel.add(panelBuy);
        panel.add(panelDown);
        panel.add(panelInt);
        panel.add(panelPer);
        panel.add(panelResult1);

        //Second Page
        JPanel panel2 = new JPanel();
        /*panel2.setLayout(new GridLayout(5,1));
        panel2.add(panelBuy);
        panel2.add(panelDown);
        panel2.add(panelInt);
        panel2.add(panelPer);
        panel2.add(panelResult1);*/

        jTab.add("Calculate Monthly Payment", panel);
        jTab.add("Early Payment Calculations", panel2);

        frame.add(jTab);
        frame.setVisible(true);
    }
}
