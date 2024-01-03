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
    float num3;

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
                        if (checkStockPriceGreaterThanStopPrice(Float.parseFloat(stockTradingPrice.getText()), Float.parseFloat(stopOutPrice.getText())))
                        {
                            if (checkRiskPercentageWithAccBalance(Integer.parseInt(accountBalanceField.getText()), Float.parseFloat(stockTradingPrice.getText()), Float.parseFloat(stopOutPrice.getText())))
                            {
                                JOptionPane.showMessageDialog(null, "Everything is still working as expected", "Validation Result", JOptionPane.INFORMATION_MESSAGE);
                                float totalRiskAmount = calculateRisk(Integer.parseInt(accountBalanceField.getText()), Float.parseFloat((String) riskPercentageAmount.getSelectedItem()));
                                JOptionPane.showMessageDialog(null, "Your risk is " + totalRiskAmount, "Validation Result", JOptionPane.INFORMATION_MESSAGE);
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(null, "Please make sure that the account balance is at least 10x greater than the trading price of the stock.", "Validation Result", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "Please enter a stock price that is higher than your stop out price.", "Validation Result", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Invalid, please enter a number that is greater than 1,000.", "Validation Result", JOptionPane.ERROR_MESSAGE);
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
        return num > 1000;
    }

    private boolean checkStockPriceGreaterThanStopPrice(float num1, float num2)
    {
        return num1 > num2;
    }
    //Just testing this Function, change functionality later.
    private boolean checkRiskPercentageWithAccBalance(int num1, float num2, float num3)
    {
        return num1 > num2 * 10 && num2 > num3;
    }

    private float calculateRisk(int accBal, float riskAmount)
    {
        float result = (riskAmount / 100) * accBal;
        return result;
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



