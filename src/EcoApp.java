import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

/**
 * @author 30214370 Marek Cudak
 * Ecoapp  "Eco App v1"
 */

public class EcoApp {
    private JTextField WeeklyActOfEco;
    private JButton buttonHowImDoing;
    private JComboBox BottleBox;
    private JComboBox CupBox;
    private JComboBox BagBox;
    private JComboBox BinBox;
    private JComboBox SandwichBox;
    private JLabel LabelImageBottle;
    private JLabel LabelImageCoffee;
    private JLabel LabelImageBag;
    private JLabel LabelImageBinBag;
    private JLabel LabelImageSandwich;
    private JPanel Main1;
    private JPanel second;
    private JPanel mainTabPanel;
    private JTextArea weeklyActsOfEcoTextArea;
    private JTextArea reusableWaterBottleTextArea;
    private JTextArea reusableCoffeeCupTextArea;
    private JTextArea reusableShoppingBagsTextArea;
    private JTextArea reusableBinBagTextArea;
    private JTextArea reusableSandwichBagsTextArea;
    private JTextArea howManyTimesATextArea;
    private JTextArea soFarThisWeek;
    private JButton awesome;
    private JButton NotEco;
    private JButton Average;
    private JButton Great;
    private JButton InAYear;
    private JTextArea KeepGoing;
    private JTextArea ResultYear;
    private JButton SaveButton;
    private JTextArea EcoTips;

    public static void main(String[] args) {

        //create new JFrame
        JFrame frame = new JFrame("Eco App v1");
        //set the JFrame to contain the GUI
        frame.setContentPane(new EcoApp().mainTabPanel);
        //set exit on close, pack components and make frame visible
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //add all components
        frame.pack();
        //everything setup so make it visible
        //frame.setVisible(true);no idea why no works
        //set default frame size
        frame.setSize(700,800);
        //set initial location in middle of screen
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x =(int)((dimension.getWidth()-frame.getWidth())/2);
        int y =(int)((dimension.getHeight()-frame.getHeight())/2);
        frame.setLocation(x,y);
        //stop user resizing window
        frame.setResizable(false);
        // everything setup so make it visible
        frame.setVisible(true);
    }

    public EcoApp() {

        LabelImageBottle.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                ImageIcon icon = new ImageIcon(getClass().getResource("/images/WaterBottle.jpg"));
                Image scaledImage = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                LabelImageBottle.setIcon(new ImageIcon(scaledImage));
            }
        });
        LabelImageCoffee.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                ImageIcon icon = new ImageIcon(getClass().getResource("/images/CoffeeCup.jpg"));
                Image scaledImage = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                LabelImageCoffee.setIcon(new ImageIcon(scaledImage));
            }
        });
        LabelImageBag.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                ImageIcon icon = new ImageIcon(getClass().getResource("/images/Bag.jpg"));
                Image scaledImage = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                LabelImageBag.setIcon(new ImageIcon(scaledImage));
            }
        });
        LabelImageBinBag.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                ImageIcon icon = new ImageIcon(getClass().getResource("/images/bin2.jpg"));
                Image scaledImage = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                LabelImageBinBag.setIcon(new ImageIcon(scaledImage));
            }
        });
        LabelImageSandwich.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                ImageIcon icon = new ImageIcon(getClass().getResource("/images/902665832_M1.jpg"));
                Image scaledImage = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                LabelImageSandwich.setIcon(new ImageIcon(scaledImage));
            }
        });

        buttonHowImDoing.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // hide first panel
                Main1.setVisible(false);
                // show second panel
                second.setVisible(true);
                //calculate average price in a year
                int cup = BottleBox.getSelectedIndex();
                double cupTotal = cup * 0.80 * 365;
                int coffee = CupBox.getSelectedIndex();
                double coffeeTotal = coffee * 0.30 * 365;
                int bag = BagBox.getSelectedIndex();
                double bagTotal = bag * 0.20 * 365;
                int bin = BinBox.getSelectedIndex();
                double binTotal = bin * 0.25 * 365;
                int sandwich = SandwichBox.getSelectedIndex();
                double sandwichTotal = sandwich * 0.15 * 365;
                double total = cupTotal + coffeeTotal + bagTotal + binTotal + sandwichTotal;
                // Format total to 2 decimal places
                String formattedTotal = String.format("%.2f", total);

                // Find the category based on the total
                if (total > 3000) {
                    awesome.setBackground(Color.GREEN);
                } else if (total > 1500) {
                    Great.setBackground(Color.BLUE);
                } else if (total > 600) {
                    Average.setBackground(Color.YELLOW);
                } else {
                    NotEco.setBackground(Color.RED);
                }

            }
        });
        InAYear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Calculate average price in a year
                int cup = BottleBox.getSelectedIndex();
                double cupTotal = cup * 0.80 * 365;
                int coffee = CupBox.getSelectedIndex();
                double coffeeTotal = coffee * 0.30 * 365;
                int bag = BagBox.getSelectedIndex();
                double bagTotal = bag * 0.20 * 365;
                int bin = BinBox.getSelectedIndex();
                double binTotal = bin * 0.25 * 365;
                int sandwich = SandwichBox.getSelectedIndex();
                double sandwichTotal = sandwich * 0.15 * 365;
                double total = cupTotal + coffeeTotal + bagTotal + binTotal + sandwichTotal;

                // Assume default prices for non-eco-friendly options
                double nonEcoCupPrice = 1.50;
                double nonEcoCoffeePrice = 0.50;
                double nonEcoBagPrice = 0.30;
                double nonEcoBinPrice = 0.40;
                double nonEcoSandwichPrice = 0.25;

                double nonEcoCupTotal = cup * nonEcoCupPrice * 365;
                double nonEcoCoffeeTotal = coffee * nonEcoCoffeePrice * 365;
                double nonEcoBagTotal = bag * nonEcoBagPrice * 365;
                double nonEcoBinTotal = bin * nonEcoBinPrice * 365;
                double nonEcoSandwichTotal = sandwich * nonEcoSandwichPrice * 365;
                double nonEcoTotal = nonEcoCupTotal + nonEcoCoffeeTotal + nonEcoBagTotal + nonEcoBinTotal + nonEcoSandwichTotal;

                // Calculate savings
                double savings = nonEcoTotal - total;


                // Highlight correct button
                if (total > 3000) {
                    awesome.setBackground(Color.GREEN);
                } else if (total > 1500) {
                    Great.setBackground(Color.BLUE);
                } else if (total > 800) {
                    Average.setBackground(Color.YELLOW);
                } else {
                    NotEco.setBackground(Color.RED);
                }

                // Format totals to 2 decimal places
                String formattedCupTotal = String.format("%.2f", cupTotal);
                String formattedCoffeeTotal = String.format("%.2f", coffeeTotal);
                String formattedBagTotal = String.format("%.2f", bagTotal);
                String formattedBinTotal = String.format("%.2f", binTotal);
                String formattedSandwichTotal = String.format("%.2f", sandwichTotal);
                String formattedTotal = String.format("%.2f", total);
                String formattedSavings = String.format("%.2f", savings);

                    // Display total and savings in the ResultYear text area
                ResultYear.setText("Feedback for user:\n\n" +
                        "If you use a reusable water bottle " + cup + " times a week, you save £" + formattedCupTotal + " a year.\n" +
                        "If you use a reusable coffee cup " + coffee + " times a week, you save £" + formattedCoffeeTotal + " a year.\n" +
                        "If you use reusable shopping bags " + bag + " times a week, you save £" + formattedBagTotal + " a year.\n" +
                        "If you use a reusable bin bag " + bin + " times a week, you save £" + formattedBinTotal + " a year.\n" +
                        "If you use reusable sandwich bags " + sandwich + " times a week, you save £" + formattedSandwichTotal + " a year.\n\n" +
                        "Total yearly cost: £" + formattedTotal + "\n\n" +
                        "You save in a year: £" + formattedSavings + " by using reusable options!");


            }
        });
        SaveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Retrieve inputs
                int cup = BottleBox.getSelectedIndex();
                double cupTotal = cup * 0.80 * 365;
                int coffee = CupBox.getSelectedIndex();
                double coffeeTotal = coffee * 0.30 * 365;
                int bag = BagBox.getSelectedIndex();
                double bagTotal = bag * 0.20 * 365;
                int bin = BinBox.getSelectedIndex();
                double binTotal = bin * 0.25 * 365;
                int sandwich = SandwichBox.getSelectedIndex();
                double sandwichTotal = sandwich * 0.15 * 365;
                double total = cupTotal + coffeeTotal + bagTotal + binTotal + sandwichTotal;
                double savings = 5000 - total; // Assume 5000 is the cost without reusable items

                // Format to 2 decimal places as money
                String formattedCupTotal = String.format("%.2f", cupTotal);
                String formattedCoffeeTotal = String.format("%.2f", coffeeTotal);
                String formattedBagTotal = String.format("%.2f", bagTotal);
                String formattedBinTotal = String.format("%.2f", binTotal);
                String formattedSandwichTotal = String.format("%.2f", sandwichTotal);
                String formattedTotal = String.format("%.2f", total);
                String formattedSavings = String.format("%.2f", savings);
                // Build the string to save
                String dataToSave = "Eco App Data:\n\n" +
                        "Reusable Water Bottle Usage: " + cup + " times a week, Yearly Savings: £" + formattedCupTotal + "\n" +
                        "Reusable Coffee Cup Usage: " + coffee + " times a week, Yearly Savings: £" + formattedCoffeeTotal + "\n" +
                        "Reusable Shopping Bags Usage: " + bag + " times a week, Yearly Savings: £" + formattedBagTotal + "\n" +
                        "Reusable Bin Bag Usage: " + bin + " times a week, Yearly Savings: £" + formattedBinTotal + "\n" +
                        "Reusable Sandwich Bags Usage: " + sandwich + " times a week, Yearly Savings: £" + formattedSandwichTotal + "\n\n" +
                        "Total Yearly Cost: £" + formattedTotal + "\n" +
                        "Total Yearly Savings by Using Reusable Options: £" + formattedSavings + "\n";
                //save in the txt file
                try {
                    java.io.FileWriter writer = new java.io.FileWriter("EcoAppData.txt");
                    writer.write(dataToSave);
                    writer.close();
                    JOptionPane.showMessageDialog(null, "Data saved successfully to EcoAppData.txt");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error saving data: " + ex.getMessage());
                }

            }
        });
        EcoTips.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                //  eco tips
                EcoTips.setText("Eco Tips:\n\n" +
                        "- Use reusable water bottles to reduce plastic waste.\n" +
                        "- Carry your reusable coffee cup for takeaways.\n" +
                        "- Say no to single-use plastic bags; opt for reusable shopping bags.\n" +
                        "- Compostable bin bags are eco-friendly alternatives to regular bin bags.\n" +
                        "- Use silicone or cloth sandwich bags instead of disposable ones.\n" +
                        "- Always recycle whenever possible and reduce your waste footprint.");


            }
        });
    }}


