package cafeordermanagementsystem;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;

public class Cust_info extends javax.swing.JFrame {

    public Cust_info() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        displayData();
        setLocationRelativeTo(null); // Center the frame
    }

    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabelID = new javax.swing.JLabel();
        jLabelName = new javax.swing.JLabel();
        jLabelEmail = new javax.swing.JLabel();
        jLabelPhone = new javax.swing.JLabel();
        jLabelDOB = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(154, 200, 205));

        jLabel1.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 60));
        jLabel1.setForeground(new Color(30, 3, 36));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Customer Information");

        jToggleButton1.setText("Back");
        jToggleButton1.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 20)); // Set font size and style
        jToggleButton1.setBackground(new Color(221, 87, 70)); // Set background color
        jToggleButton1.setForeground(Color.WHITE); // Set text color
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        
        jLabelID.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 20));
        jLabelName.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 20));
        jLabelEmail.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 20));
        jLabelPhone.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 20));
        jLabelDOB.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelPhone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelDOB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jToggleButton1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelID, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelName, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelDOB, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 136, Short.MAX_VALUE)
                .addComponent(jToggleButton1)
                .addContainerGap())
        );

        pack();
    }

    private void displayData() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/project_java";
            String un = "root";
            String pas = "kewal2105";
            Connection conn = DriverManager.getConnection(url, un, pas);
            System.out.println("Connection Established");
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String sql = "select cust_id, name, email, phone_no, date_of_birth from customer order by cust_id desc limit 1;";
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                int id = rs.getInt("cust_id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String phone = rs.getString("phone_no");
                String dob = rs.getString("date_of_birth");

                jLabelID.setText("Customer ID: " + id);
                jLabelName.setText("Name: " + name);
                jLabelEmail.setText("Email: " + email);
                jLabelPhone.setText("Phone: " + phone);
                jLabelDOB.setText("Date of Birth: " + dob);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        Manager mn = new Manager();
        mn.setVisible(true);
        this.setVisible(false);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cust_info().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelID;
    private javax.swing.JLabel jLabelName;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelPhone;
    private javax.swing.JLabel jLabelDOB;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration
}
