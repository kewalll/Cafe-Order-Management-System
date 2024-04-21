package cafeordermanagementsystem;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
import javax.swing.table.TableModel;
import java.sql.PreparedStatement;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.text.SimpleDateFormat;
import java.awt.Color;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class order_page extends javax.swing.JFrame {
    public int grandTotal=0;
    public int productPrice=0;
    public int productTotal=0;
    private javax.swing.JButton btnBack;

    public order_page() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        txtProductname.setEditable(false);
        txtprice.setEditable(false);
        txttotal.setEditable(false);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        getContentPane().setBackground(new Color(154, 200, 205));
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtProductname = new javax.swing.JTextField();
        txtprice = new javax.swing.JTextField();
        txttotal = new javax.swing.JTextField();
        spinnerquantity = new javax.swing.JSpinner();
        btnclear = new javax.swing.JButton();
        btnAddtocart = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        lblGrandtotal = new javax.swing.JLabel();
        btnGeneratebill = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtCustomerId = new javax.swing.JTextField();
        btnBack = new javax.swing.JButton();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1366, 768));

        jLabel1.setFont(new java.awt.Font("Segue UI", 1, 40)); 
        jLabel1.setText("Place Order");

        jTable1.setFont(new java.awt.Font("Segoe UI", 1, 15)); 
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item_id", "Name"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); 
        jButton1.setText("show Items");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segue UI", 1, 18)); 
        jLabel2.setText("Name");

        jLabel3.setFont(new java.awt.Font("Segue UI", 1, 18)); 
        jLabel3.setText("Price");

        jLabel4.setFont(new java.awt.Font("Segue UI", 1, 18)); 
        jLabel4.setText("Quantity");

        jLabel5.setFont(new java.awt.Font("Segue UI", 1, 18)); 
        jLabel5.setText("Total");

        txtProductname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProductnameActionPerformed(evt);
            }
        });

        spinnerquantity.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinnerquantityStateChanged(evt);
            }
        });

        btnclear.setFont(new java.awt.Font("Segoe UI", 1, 18)); 
        btnclear.setText("Clear");
        btnclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclearActionPerformed(evt);
            }
        });

        btnAddtocart.setFont(new java.awt.Font("Segoe UI", 1, 18)); 
        btnAddtocart.setText("Add to Cart ");
        btnAddtocart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddtocartActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name ", "Price", "Quantity", "Total"
            }
        ));
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(3).setHeaderValue("Total");
        }

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); 
        jLabel6.setText("Grand Total $:");

        lblGrandtotal.setFont(new java.awt.Font("Segoe UI", 1, 18)); 
        lblGrandtotal.setText("000 Rs");

        btnGeneratebill.setFont(new java.awt.Font("Segoe UI", 1, 18)); 
        btnGeneratebill.setText("Generate Bill");
        btnGeneratebill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGeneratebillActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segue UI", 1, 18)); 
        jLabel7.setText("Customer ID");

        txtCustomerId.setFont(new java.awt.Font("Segoe UI", 0, 18)); 
        btnBack.setBackground(new java.awt.Color(221, 87, 70)); // Set Background Color
        btnBack.setFont(new java.awt.Font("Segoe UI", 1, 18)); 
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addComponent(jButton1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 174, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(txtProductname, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spinnerquantity, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(btnclear))
                        .addGap(200, 200, 200)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAddtocart)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel3)
                                .addComponent(jLabel5)
                                .addComponent(txtprice)
                                .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addGap(18, 18, 18)
                            .addComponent(lblGrandtotal)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnGeneratebill))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(102, 102, 102))
            .addGroup(layout.createSequentialGroup()
                .addGap(179, 179, 179)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCustomerId, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBack)
                .addGap(308, 308, 308))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtProductname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtprice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spinnerquantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnclear)
                            .addComponent(btnAddtocart))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lblGrandtotal)
                    .addComponent(btnGeneratebill))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtCustomerId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBack)
                .addGap(94, 94, 94))
        );

        pack();
    }// </editor-fold>                        

    float totalprice;
    float grandtotal;
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/project_java";
            String un = "root";
            String pas = "kewal2105";
            Connection conn = DriverManager.getConnection(url,un,pas);
            System.out.println("Connection Established");
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String sql="select item_id,item_name from items";
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next()){
                String id=rs.getString("item_id");
                String name =rs.getString("item_name");
                String tbdata[]={id,name};
                DefaultTableModel tblmodel=(DefaultTableModel)jTable1.getModel();
                tblmodel.addRow(tbdata);
            }
        }catch(Exception e){
            System.out.println(e);
            
        }
    }                                        
    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // Implement your back button functionality here
        // For example, you can close the current frame and open the previous one
        // Or you can navigate to a different panel or frame in your application
        Manager mn =new Manager();
        mn.setVisible(true);
        this.dispose();
    }    
    private void btnclearActionPerformed(java.awt.event.ActionEvent evt) {                                         
        txtProductname.setText("");
        txtprice.setText("");
        txttotal.setText("");
    }                                        

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {                                     
        int row = jTable1.getSelectedRow();
        String tc = jTable1.getModel().getValueAt(row, 0).toString();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/project_java";
            String un = "root";
            String pas = "kewal2105";
            Connection conn = DriverManager.getConnection(url, un, pas);
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String query = "select item_name,price from items where item_id=" + tc + ";";
            PreparedStatement pst = conn.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                String name = rs.getString("item_name");
                String price = rs.getString("price");
                txtProductname.setText(name);
                txtprice.setText(price);
                spinnerquantity.setValue(1);
                txttotal.setText(price);
                float fprice = Float.parseFloat(price);
                float quantity = (Integer) spinnerquantity.getValue();
                if (quantity <= 1) {
                    spinnerquantity.setValue(1);
                    quantity = 1;
                }
                spinnerquantity.addChangeListener(new ChangeListener() {
                    @Override
                    public void stateChanged(ChangeEvent e) {
                        int quantity = (Integer) spinnerquantity.getValue();
                        float price = Float.parseFloat(txtprice.getText());
                        if (quantity > 1) {
                            totalprice = quantity * price;
                            txttotal.setText(String.valueOf(totalprice));
                        } else {
                            txttotal.setText(txtprice.getText());
                        }
                    }
                });
            }
        } catch (Exception e) {
            System.out.println(e);
        }       
    }                                    

    private void spinnerquantityStateChanged(javax.swing.event.ChangeEvent evt) {                                             
        spinnerquantity.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int quantity = (Integer) spinnerquantity.getValue();
                float price = Float.parseFloat(txtprice.getText());
                if (quantity > 1) {
                    float totalprice = quantity * price;
                    txttotal.setText(String.valueOf(totalprice));
                } else {
                    txttotal.setText(txtprice.getText());
                }
            }
        });
    }                                            

    private void btnAddtocartActionPerformed(java.awt.event.ActionEvent evt) {                                             
        String name=txtProductname.getText();
        String price=txtprice.getText();
        String quantity=String.valueOf(spinnerquantity.getValue());
        DefaultTableModel dtm=(DefaultTableModel) jTable2.getModel();
        dtm.addRow(new Object[]{name,price,quantity,totalprice});
        grandtotal=grandtotal+totalprice;
        lblGrandtotal.setText(String.valueOf(grandtotal));
    }                                            

    private void btnGeneratebillActionPerformed(java.awt.event.ActionEvent evt) {                                                
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/project_java";
            String un = "root";
            String pas = "kewal2105";
            Connection conn = DriverManager.getConnection(url, un, pas);
            conn.setAutoCommit(false);
    
            // Inserting into Orders table
            String insertOrderQuery = "INSERT INTO Orders (date_and_time, cust_id) VALUES (NOW(), ?)";
            PreparedStatement insertOrderStmt = conn.prepareStatement(insertOrderQuery, Statement.RETURN_GENERATED_KEYS);
            insertOrderStmt.setInt(1, Integer.parseInt(txtCustomerId.getText()));
            insertOrderStmt.executeUpdate();
            ResultSet generatedKeys = insertOrderStmt.getGeneratedKeys();
            int orderId = 0;
            if (generatedKeys.next()) {
                orderId = generatedKeys.getInt(1);
            }
    
            // Inserting into OrderItems table
            DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
            for (int i = 0; i < model.getRowCount(); i++) {
                String itemName = model.getValueAt(i, 0).toString();
                String price = model.getValueAt(i, 1).toString();
                String quantity = model.getValueAt(i, 2).toString();
                String insertOrderItemQuery = "INSERT INTO OrderItems (order_id, item_id, qty, dish_name, status) " +
                                              "VALUES (?, (SELECT item_id FROM Items WHERE item_name = ?), ?, NULL, 'Pending')";
                PreparedStatement insertOrderItemStmt = conn.prepareStatement(insertOrderItemQuery);
                insertOrderItemStmt.setInt(1, orderId);
                insertOrderItemStmt.setString(2, itemName);
                insertOrderItemStmt.setInt(3, Integer.parseInt(quantity));
                insertOrderItemStmt.executeUpdate();
            }
    
            // Calculating total bill amount
            float totalBillAmount = Float.parseFloat(lblGrandtotal.getText());
    
            // Inserting into Bills table
            String insertBillQuery = "INSERT INTO Bills (order_id, total_amt) VALUES (?, ?)";
            PreparedStatement insertBillStmt = conn.prepareStatement(insertBillQuery);
            insertBillStmt.setInt(1, orderId);
            insertBillStmt.setFloat(2, totalBillAmount);
            insertBillStmt.executeUpdate();
    
            conn.commit();
            conn.setAutoCommit(true);
            conn.close();
    
            // Resetting the order page for new order
            txtCustomerId.setText("");
            lblGrandtotal.setText("000 Rs");
            DefaultTableModel tableModel = (DefaultTableModel) jTable2.getModel();
            tableModel.setRowCount(0);
    
            // Informing the user about successful bill generation
            System.out.println("Bill generated successfully. New order placed.");
            JOptionPane.showMessageDialog(rootPane, "Order Placed Successfully!!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error generating bill: " + e.getMessage());
        }
    }
    

    private void txtProductnameActionPerformed(java.awt.event.ActionEvent evt) {                                               
        // TODO add your handling code here:
    }                                              

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 1.4) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(order_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(order_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(order_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(order_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new order_page().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnAddtocart;
    private javax.swing.JButton btnGeneratebill;
    private javax.swing.JButton btnclear;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel lblGrandtotal;
    private javax.swing.JSpinner spinnerquantity;
    private javax.swing.JTextField txtCustomerId;
    private javax.swing.JTextField txtProductname;
    private javax.swing.JTextField txtprice;
    private javax.swing.JTextField txttotal;
    // End of variables declaration                   
}
