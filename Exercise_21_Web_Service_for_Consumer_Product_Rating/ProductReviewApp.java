// ProductReviewApp.java (Web Service Consumer)
package edu.cahcet.reviewclient;

// Importing the necessary web service proxy classes
import edu.cahcet.webserviceclient.SamsungReviews;
import edu.cahcet.webserviceclient.SamsungReviews_Service;

// This class defines the main GUI application that serves as a client to consume a web service.
// It uses Java Swing for GUI components and interacts with a SOAP-based web service for retrieving product reviews.
public class ProductReviewApp extends javax.swing.JFrame {

    // Declaring a reference variable for the web service proxy object
    SamsungReviews proxy;

    // Constructor to initialize the GUI and set up the web service proxy
    public ProductReviewApp() {
        initComponents(); // Auto-generated method to initialize GUI components

        // Instantiating the web service proxy using the service class and retrieving the service port
        proxy = new SamsungReviews_Service().getSamsungReviewsPort();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code"> 
    // Method responsible for laying out all Swing components in the JFrame.
    // Includes labels, text fields, text area, scroll pane, and a submit button.
    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        productname = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        finalreviews = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        btnsubmit = new javax.swing.JButton();

        // Setting default close operation for the JFrame
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        // Label for the application title
        jLabel1.setText("Product Review Application");

        // Label to prompt the user to enter a product name
        jLabel2.setText("Enter the Name of the Product");

        // Event listener to handle actions in the product name input field (currently unused)
        productname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productnameActionPerformed(evt);
            }
        });

        // Configuring the text area for displaying the reviews
        finalreviews.setColumns(20);
        finalreviews.setRows(5);
        jScrollPane1.setViewportView(finalreviews);

        // Label for the reviews section
        jLabel3.setText("Reviews");

        // Configuring the submit button and its event handler
        btnsubmit.setText("Submit");
        btnsubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsubmitActionPerformed(evt);
            }
        });

        // Layout setup using GroupLayout for aligning components
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(productname, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(46, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnsubmit)
                .addGap(144, 144, 144))
        );

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(productname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(btnsubmit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        // Finalizing layout configuration
        pack();
    } // </editor-fold> 

    // Event handler for the Submit button
    // This method sends the product name to the web service and processes the response.
    private void btnsubmitActionPerformed(java.awt.event.ActionEvent evt) {
        // Retrieving user input from the text field
        String input = productname.getText();

        // Invoking the web service method to get product reviews
        String output = proxy.mobilereviews(input);

        // Splitting the reviews using a comma delimiter
        String temp[] = output.split(",");

        // Formatting the reviews into a readable string for display
        String finaloutput = "Product Reviews\n\n";
        for (int i = 0; i < temp.length; i++) {
            finaloutput += temp[i] + "\n";
        }

        // Displaying the final formatted reviews in the text area
        finalreviews.setText(finaloutput);
    }

    // Event handler stub for the product name field (currently no specific behavior is defined)
    private void productnameActionPerformed(java.awt.event.ActionEvent evt) {
        // This method can be extended to implement real-time suggestions or validations
    }

    // Main method to launch the GUI application
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProductReviewApp().setVisible(true); // Making the frame visible
            }
        });
    }

    // Declaration of Swing components used in the application
    private javax.swing.JButton btnsubmit;
    private javax.swing.JTextArea finalreviews;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField productname;
    // End of variables declaration
}
