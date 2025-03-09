import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class CurrencyConverter extends JFrame {
 private JTextField amountTextField;
 private JComboBox<String> fromCurrencyComboBox, toCurrencyComboBox;
 private JLabel resultLabel;
 private static final double USD_TO_EUR_RATE = 0.85;
 private static final double USD_TO_GBP_RATE = 0.73;
 public CurrencyConverter() {
 setTitle("Currency Converter");
 setSize(300, 200);
 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 initComponents();
 }
private void initComponents() {
 JPanel panel = new JPanel();
 getContentPane().add(panel);
 panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
 amountTextField = new JTextField(10);
 panel.add(new JLabel("Amount:"));
 panel.add(amountTextField);
 fromCurrencyComboBox = new JComboBox<>(new String[]{"USD", "EUR", 
"GBP"});
 panel.add(new JLabel("From Currency:"));
 panel.add(fromCurrencyComboBox);
 toCurrencyComboBox = new JComboBox<>(new String[]{"USD", "EUR", 
"GBP"});
 panel.add(new JLabel("To Currency:"));
 panel.add(toCurrencyComboBox);
 JButton convertButton = new JButton("Convert");
 panel.add(convertButton);
resultLabel = new JLabel("Result:");
 panel.add(resultLabel);
 convertButton.addActionListener(new ActionListener() {
 @Override
 public void actionPerformed(ActionEvent e) {
 convertCurrency();
 }
 });
 }
 private void convertCurrency() {
 try {
 double amount = Double.parseDouble(amountTextField.getText());
 String fromCurrency = (String) fromCurrencyComboBox.getSelectedItem();
 String toCurrency = (String) toCurrencyComboBox.getSelectedItem();
 double result = convert(amount, fromCurrency, toCurrency);} catch (NumberFormatException ex) {
 resultLabel.setText("Invalid input. Please enter a valid number.");
 }
 }
 private double convert(double amount, String fromCurrency, String toCurrency) {
 double rate;
 switch (fromCurrency) {
 case "USD":
 switch (toCurrency) {
 case "EUR":
 rate = USD_TO_EUR_RATE;
 break;
 case "GBP":
 rate = USD_TO_GBP_RATE;
 break;
 default:
 rate = 1.0;
 break;
 }
 break;case "EUR":
 rate = 1 / USD_TO_EUR_RATE;
 break;
 case "GBP":
 rate = 1 / USD_TO_GBP_RATE;
 break;
 default:
 rate = 1.0;
 break;
 }
 return amount * rate;
 }
 public static void main(String[] args) {
 SwingUtilities.invokeLater(new Runnable() {
 @Override
 public void run() {
 new CurrencyConverter().setVisible(true);
 }
 });
 }
}


