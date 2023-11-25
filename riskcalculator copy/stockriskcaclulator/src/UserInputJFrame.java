import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


public class UserInputJFrame extends JFrame {

    private JTextField accountBalanceField;
    private JTextField stockTradingPrice;
    private JTextField stopOutPrice;
    private JButton validateButton;
    private JButton calculateButton;

    public UserInputJFrame()
    {
        setTitle("Risk Calculator");
        setSize(300, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        accountBalanceField = new JTextField("Enter Account Balance", 15);
        stockTradingPrice = new JTextField("Enter Share Price", 15);
        stopOutPrice = new JTextField("Enter Stop Loss Price", 15);
        validateButton = new JButton("Validate");
        calculateButton = new JButton("Calculate");


        validateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (lengthCheckValidate(stockTradingPrice.getText()))
                {
                    JOptionPane.showMessageDialog(null, "Valid input!",
                            "Validation Result", JOptionPane.INFORMATION_MESSAGE);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,
                            "Invalid input! Input must have at least 6 characters.",
                            "Validation Result", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

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


        add(accountBalanceField);
        add(validateButton);
        add(stockTradingPrice);
        add(stopOutPrice);
        add(calculateButton);
        setSize(400, 300);

        setLocationRelativeTo(null);
        setVisible(true);
        

    }

    private boolean lengthCheckValidate(String input)
    {
        return input.length() >= 6;
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
