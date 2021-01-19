import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class WelcomeFrame{
    private final JTextField[] fields = new JTextField[5];              //Keeps track of the JTextField(User Inputs)
    private byte count = 0;                                             //Counts # of JTextField
    private final JButton[] buttons = new JButton[2];                   //Keeps track of the JButton(Calculate Button)
    private byte count1 = 0;                                            //Counts # of JButton

    public WelcomeFrame(){
        JFrame frame = new JFrame();
        frame.setSize(700, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTabbedPane jTab = new JTabbedPane();

        jTab.add("Calculate Monthly Payment", firstTab());          //Calls firstTab Function
        jTab.add("Early Payment Calculations", secondTab());        //Calls secondTab Function

        frame.add(jTab);
        frame.setVisible(true);
    }

    private JPanel firstTab(){
        JPanel panelBuy = this.customPanel1("Buying Price: $", "Enter Buying Price Here");      //Creates CustomPanels
        JPanel panelDownPay = this.customPanel1("Down Payment: $", "Enter Down Payment Here");
        JPanel panelInt = this.customPanel1("Interest Rate in Percent:", "Enter Interest Rate in Percent Here");
        JLabel percent = new JLabel("%");
        panelInt.add(percent);
        JPanel panelPer = this.customPanel1("Period in Years:", "Enter Period in Years Here");
        JLabel years = new JLabel("Years");
        panelPer.add(years);

        JPanel result = customPanel2(false);                                                               //Creates CustomPanel2

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6,1));
        panel.add(new JLabel("Calculates Monthly Payment."));
        panel.add(panelBuy);
        panel.add(panelDownPay);
        panel.add(panelInt);
        panel.add(panelPer);
        panel.add(result);
        return panel;
    }

    private JPanel secondTab(){
        JPanel periodPanel = this.customPanel1("Period in Years:", "Enter Period in Years Here You Wish to Payoff the Loan by");
        JLabel yearsLabel = new JLabel("Years");
        periodPanel.add(yearsLabel);

        JPanel result = customPanel2(true);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3,1));
        panel.add(new JLabel("Calculates Monthly Payment Based on Desired Payment Period."));
        panel.add(periodPanel);
        panel.add(result);
        return panel;
    }

    private JPanel customPanel1(String labelText, String fieldText){
        JPanel panel = new JPanel();
        JLabel label = new JLabel(labelText);
        int i = count;
        fields[i] = new JTextField(fieldText);
        fields[i].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                fields[i].setText("");
            }
        });
        panel.add(label);
        panel.add(fields[i]);
        count++;
        return panel;
    }

    private JPanel customPanel2(boolean flag){
        JPanel panelResult = new JPanel();
        panelResult.setLayout(new GridLayout(2,1));
        JLabel result1 = new JLabel();
        result1.setVisible(false);
        int i = count1;
        buttons[i] = new JButton("Calculate");
        buttons[i].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Calculate calcPayment;

                if(flag){
                    calcPayment = new Calculate(Float.parseFloat(fields[0].getText()),
                                                Float.parseFloat(fields[1].getText()),
                                                Float.parseFloat(fields[2].getText()),
                                                Integer.parseInt(fields[4].getText()));
                }
                else{
                    calcPayment = new Calculate(Float.parseFloat(fields[0].getText()),
                                                Float.parseFloat(fields[1].getText()),
                                                Float.parseFloat(fields[2].getText()),
                                                Integer.parseInt(fields[3].getText()));
                }

                String val = calcPayment.calMonthlyPayment();
                result1.setText("Monthly Payments: " + val);
                result1.setVisible(true);
            }
        });
        panelResult.add(buttons[i]);
        panelResult.add(result1);
        count1++;

        return panelResult;
    }
}