package cafeordermanagementsystem;


import java.awt.Color;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.*;
import java.sql.*;
import javax.swing.*;
public class LoginManager extends JFrame {

    private Connection conn;
    private Statement stmt;
    private ResultSet rs;

    public LoginManager() {
        initComponents();
        customizeUI();
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Set JFrame to fullscreen
    }

    private void customizeUI() {
        getContentPane().setBackground(new Color(154, 200, 205)); // Setting background color

        jLabel1.setForeground(new Color(30, 3, 36)); // Changing text color
        jLabel1.setFont(new Font("Arial", Font.BOLD, 60)); // Changing font
        
        jLabel2.setForeground(new Color(30, 3, 36)); // Changing text color
        jLabel2.setFont(new Font("Arial", Font.BOLD, 20)); // Changing font
        
        jLabel3.setForeground(new Color(30, 3, 36)); // Changing text color
        jLabel3.setFont(new Font("Arial", Font.BOLD, 20)); // Changing font
        
        jButton1.setBackground(new Color(17, 70, 163)); // Changing button background color
        jButton1.setForeground(Color.WHITE); // Changing button text color
        jButton1.setFont(new Font("Arial", Font.BOLD, 24)); // Changing font

        jButton2.setBackground(new Color(17, 70, 163)); // Changing button background color
        jButton2.setForeground(Color.WHITE); // Changing button text color
        jButton2.setFont(new Font("Arial", Font.BOLD, 24)); // Changing font

        jButton3.setBackground(new Color(17, 70, 163)); // Changing button background color
        jButton3.setForeground(Color.WHITE); // Changing button text color
        jButton3.setFont(new Font("Arial", Font.BOLD, 24)); // Changing font

        jButton4.setBackground(new Color(221, 87, 70)); // Changing button background color
        jButton4.setForeground(Color.WHITE); // Changing button text color
        jButton4.setFont(new Font("Arial", Font.BOLD, 24)); // Changing font
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
    jLabel1 = new javax.swing.JLabel();
    jTextField1 = new javax.swing.JTextField();
    jLabel2 = new javax.swing.JLabel(); // Initialize jLabel2
    jLabel3 = new javax.swing.JLabel();
    jPasswordField1 = new javax.swing.JPasswordField();
    jButton4 = new javax.swing.JButton();
    jButton2 = new javax.swing.JButton();
    jButton1 = new javax.swing.JButton();
    jButton3 = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    jLabel1.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
    jLabel1.setText("Manager Login");
    jLabel3.setText("Password");

    jLabel2.setText("Username");


    jButton4.setText("Exit");
    jButton4.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton4ActionPerformed(evt);
        }
    });

    jButton2.setText("Reset");
    jButton2.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton2ActionPerformed(evt);
        }
    });

    jButton1.setText("Submit");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton1ActionPerformed(evt);
        }
    });

    jButton3.setText("Back");
    jButton3.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton3ActionPerformed(evt);
        }
    });

    // Use GroupLayout to arrange components
    GroupLayout layout = new GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
    .addGroup(layout.createSequentialGroup()
        .addGap(550, 550, 550)
        .addComponent(jLabel1)
        .addContainerGap(147, Short.MAX_VALUE))
    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jButton3)
                .addGap(29, 29, 29)
                .addComponent(jButton4))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE) // Use PREFERRED_SIZE constant
                    .addComponent(jButton2))
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextField1)
                        .addComponent(jPasswordField1, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)))))
        .addGap(600, 600, 600))
);

    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addGap(100, 100, 100)
            .addComponent(jLabel1)
            .addGap(50, 50, 50)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel2))
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel3)
                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(35, 35, 35)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jButton2)
                .addComponent(jButton1))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jButton4)
                .addComponent(jButton3))
            .addGap(300, 300, 300))
    );

    pack();
}


    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver"); //Loading driver into memory
            String url = "jdbc:mysql://localhost:3306/project_java";
            String un = "root";
            String pas = "kewal2105";
            conn = DriverManager.getConnection(url,un,pas);
            stmt=conn.createStatement();
            String user1 = jTextField1.getText();
            String pass1 = new String(jPasswordField1.getPassword());
            String query = "select * from login where username ='"+user1+"';";
            String role = "manager";

            rs = stmt.executeQuery(query);

            if (rs.next()) {
                // If there are results, compare the password
                if (pass1.equals(rs.getString(2)) & role.equals(rs.getString(3))) {
                    Manager mn = new Manager();
                    mn.setVisible(true);
                    this.setVisible(false);
                }
                else {
                    JOptionPane.showMessageDialog(rootPane, "Login Unsuccessful!!");
                }
            }
            else {
                JOptionPane.showMessageDialog(rootPane, "User doesn't exist!!");
            }

        }
        catch(HeadlessException | ClassNotFoundException | SQLException e){
            System.out.println(e);
        }
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        jTextField1.setText("");
        jPasswordField1.setText("");
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        HomePage hm = new HomePage();
        hm.setVisible(true);
        this.setVisible(false);
    }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginKitchen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new LoginKitchen().setVisible(true);
        });
    }

    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JButton jButton4;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JPasswordField jPasswordField1;
    private JTextField jTextField1;
}
