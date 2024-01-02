import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class UserInputJFrame extends JFrame {
    JPanel panel;
    private JTextField accountBalanceField;
    private JLabel accountBalanceLabel;
    private JTextField stockTradingPrice;
    private JLabel stockTradingPriceLabel;
    private JTextField stopOutPrice;
    private JLabel stopOutPriceLabel;
    private JComboBox riskPercentageAmount;
    private JLabel riskPercentageAmountLabel;
    private JButton calculateButton;

    public UserInputJFrame()
    {
        setTitle("Risk Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(null);


        accountBalanceField = new JTextField( 15);
        accountBalanceField.setBounds(345, 30, 125, 20);

        accountBalanceLabel = new JLabel("Please enter your account balance");
        accountBalanceLabel.setBounds(65, 30, 200, 20);

        stockTradingPrice = new JTextField( 15);
        stockTradingPrice.setBounds(395, 70, 75, 20);

        stockTradingPriceLabel = new JLabel("Please enter the current trading price");
        stockTradingPriceLabel.setBounds(65, 70, 250, 20);

        stopOutPrice = new JTextField(15);
        stopOutPrice.setBounds(395, 110, 75, 20);

        stopOutPriceLabel = new JLabel("Please enter your stop price");
        stopOutPriceLabel.setBounds(65, 110, 200, 20);

        String[] riskOptions = {"0.5", "1.0", "1.5", "2.0", "2.5", "3.0", "3.5"};
        riskPercentageAmount = new JComboBox(riskOptions);
        riskPercentageAmount.setBounds(420, 150, 50, 35);

        riskPercentageAmountLabel = new JLabel("Please select what % of your account you would like to risk");
        riskPercentageAmountLabel.setBounds(20, 160, 340, 20);

        calculateButton = new JButton("Calculate");
        calculateButton.setBounds(180,300,150, 50);



        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int accountBalance = Integer.parseInt(accountBalanceField.getText());

                    if (checkAccountBalance(Integer.parseInt(accountBalanceField.getText())))
                    {
                        JOptionPane.showMessageDialog(null, "Thank you for your account balance!", "Validation Result", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Invalid, please enter a number that is greater than 0.", "Validation Result", JOptionPane.ERROR_MESSAGE);
                    }
                }
                catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid Input. Please enter a number", "Validation Result", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        setSize(500, 450);
        add(panel);

        panel.add(accountBalanceField);
        panel.add(accountBalanceLabel);
        panel.add(stockTradingPrice);
        panel.add(stockTradingPriceLabel);
        panel.add(stopOutPrice);
        panel.add(stopOutPriceLabel);
        panel.add(riskPercentageAmount);
        panel.add(riskPercentageAmountLabel);
        panel.add(calculateButton);




        setVisible(true);
        

    }

    private boolean checkAccountBalance(int num)
    {
        return num > 0;
    }


    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new UserInputJFrame();
            }
        });

    }

}



