import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import java.awt.BorderLayout;

import java.awt.GridLayout;
import java.awt.event.*;
import java.text.DecimalFormat;

public class BondYieldGUI extends JPanel implements ActionListener {
    private final JTextField couponP;
    private final JTextField yearsP;
    private final JTextField faceValP;
    private final JTextField rateP;
    private final JTextField couponYTM;
    private final JTextField yearsYTM;
    private final JTextField faceValYTM;
    private final JTextField priceYTM;

    public BondYieldGUI() {
        super(new GridLayout());

        //create tabbed panes for two possible inputs

        JTabbedPane tabbedPane = new JTabbedPane();

        //create panel and various text fields associated with inputs

        JComponent panel1 = new JPanel();
        tabbedPane.addTab("Calculate Price", panel1);

        panel1.add(new JLabel("Coupon: "));
        couponP = new JTextField(5);
        panel1.add(couponP);

        panel1.add(new JLabel("Years: "));
        yearsP = new JTextField(5);
        panel1.add(yearsP);

        panel1.add(new JLabel("Face Value: "));
        faceValP = new JTextField(5);
        panel1.add(faceValP);

        panel1.add(new JLabel("Rate: "));
        rateP = new JTextField(5);
        panel1.add(rateP);
        
        //add calculate button with listener
        JButton calculatePrice = new JButton("Calculate");
        panel1.add(calculatePrice);
        calculatePrice.setActionCommand("Calculate Price");
        calculatePrice.addActionListener(this);

       

        //second panel for YTM calculation
        JComponent panel2 = new JPanel();
        tabbedPane.addTab("Calculate Yield to Maturity", panel2);

        panel2.add(new JLabel("Coupon: "));
        couponYTM = new JTextField(5);
        panel2.add(couponYTM);

        panel2.add(new JLabel("Years: "));
        yearsYTM = new JTextField(5);
        panel2.add(yearsYTM);

        panel2.add(new JLabel("Face Value: "));
        faceValYTM = new JTextField(5);
        panel2.add(faceValYTM);

        panel2.add(new JLabel("Price: "));
        priceYTM = new JTextField(5);
        panel2.add(priceYTM);

        JButton calculateYTM = new JButton("Calculate");
        panel2.add(calculateYTM);
        calculateYTM.setActionCommand("Calculate YTM");
        calculateYTM.addActionListener(this);

        // Add the tabbed pane to this panel.
        add(tabbedPane);

  
    }

 

    /**
     * Create the GUI and show it. For thread safety,
     * this method should be invoked from
     * the event dispatch thread.
     */
    private static void createAndShowGUI() {
        // Create and set up the window.
        JFrame frame = new JFrame("Bond Evaluation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add content to the window.
        frame.add(new BondYieldGUI(), BorderLayout.CENTER);

        // Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // Schedule a job for the event dispatch thread:
        // creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // Turn off metal's use of bold fonts
                UIManager.put("swing.boldMetal", Boolean.FALSE);
                createAndShowGUI();
            }
        });
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        DecimalFormat dc = new DecimalFormat("#.#######");
        
       
        String command = e.getActionCommand();
        
      
        if(command.equals("Calculate Price")){
            try{
                Double coupon = Double.parseDouble(couponP.getText());
                Integer years = Integer.parseInt(yearsP.getText());
                Double face = Double.parseDouble(faceValP.getText());
                Double rate = Double.parseDouble(rateP.getText());

                
                
                double priceCalc = BondYieldCalc.CalcPrice(coupon, years, face, rate);
                String result = dc.format(priceCalc);
                JOptionPane.showMessageDialog(null, "The calculated price is : " + result, "YTM Result", JOptionPane.INFORMATION_MESSAGE);
                

            }
            catch(NumberFormatException err){
                //open box with error to try again;
                System.out.println(err);
                JOptionPane.showMessageDialog(null, "Incorrect input format. Please try again.", "ERROR", JOptionPane.ERROR_MESSAGE);

            }
            


        }
        //we are calculating the ytm button
        else{
            try{
                Double coupon = Double.parseDouble(couponYTM.getText());
                Integer years = Integer.parseInt(yearsYTM.getText());
                Double face = Double.parseDouble(faceValYTM.getText());
                Double price = Double.parseDouble(priceYTM.getText());

                
                
                double ytmCalc = BondYieldCalc.bondYTM(coupon, years, face, price);
                String result = dc.format(ytmCalc);
                
                JOptionPane.showMessageDialog(null, "The calculated YTM is : " + result, "YTM Result", JOptionPane.INFORMATION_MESSAGE);
                

            }
            catch(NumberFormatException err){
                //open box with error to try again;
                System.out.println(err);
                JOptionPane.showMessageDialog(null, "Incorrect input format. Please try again.", "ERROR", JOptionPane.ERROR_MESSAGE);

            }
            


        }
        
    }


}

