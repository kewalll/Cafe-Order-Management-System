package cafeordermanagementsystem;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SignUp extends JFrame implements ActionListener {

    private JLabel jLabel1, jLabel2, jLabel3, jLabel5, jLabel6, jLabel10;
    private JTextField txtname, txtEmail, txtPhone, txtDOB, txtid;
    private JButton jButton1, jButton2, jButton3;

    public SignUp() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(154, 200, 205));
        
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(154, 200, 205));
        add(panel);

        jLabel1 = new JLabel("SignUp");
        jLabel1.setFont(new Font("Segoe UI Black", Font.BOLD, 60));
        jLabel1.setForeground(new Color(30, 3, 36));
        jLabel1.setBounds(650, 50, 400, 100);
        panel.add(jLabel1);

        jLabel2 = new JLabel("Name");
        jLabel2.setFont(new Font("Segoe UI", Font.BOLD, 20));
        jLabel2.setBounds(500, 200, 150, 30);
        panel.add(jLabel2);

        txtname = new JTextField();
        txtname.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        txtname.setBounds(650, 200, 300, 35);
        panel.add(txtname);

        jLabel3 = new JLabel("Email");
        jLabel3.setFont(new Font("Segoe UI", Font.BOLD, 20));
        jLabel3.setBounds(500, 250, 150, 30);
        panel.add(jLabel3);

        txtEmail = new JTextField();
        txtEmail.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        txtEmail.setBounds(650, 250, 300, 35);
        panel.add(txtEmail);

        jLabel5 = new JLabel("Phone No");
        jLabel5.setFont(new Font("Segoe UI", Font.BOLD, 20));
        jLabel5.setBounds(500, 300, 150, 30);
        panel.add(jLabel5);

        txtPhone = new JTextField();
        txtPhone.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        txtPhone.setBounds(650, 300, 300, 35);
        panel.add(txtPhone);

        jLabel6 = new JLabel("Date of Birth");
        jLabel6.setFont(new Font("Segoe UI", Font.BOLD, 20));
        jLabel6.setBounds(500, 350, 150, 30);
        panel.add(jLabel6);

        txtDOB = new JTextField();
        txtDOB.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        txtDOB.setBounds(650, 350, 300, 35);
        panel.add(txtDOB);

        jLabel10 = new JLabel("Cafe ID");
        jLabel10.setFont(new Font("Segoe UI", Font.BOLD, 20));
        jLabel10.setBounds(500, 400, 150, 30);
        panel.add(jLabel10);

        txtid = new JTextField();
        txtid.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        txtid.setBounds(650, 400, 300, 35);
        panel.add(txtid);

        jButton1 = new JButton("Reset");
        jButton1.setFont(new Font("Segoe UI", Font.BOLD, 18));
        jButton1.setBounds(500, 550, 100, 30);
        jButton1.setBackground(new Color(17, 70, 163)); // Changing button background color
        jButton1.setForeground(Color.WHITE);
        jButton1.addActionListener(this);
        panel.add(jButton1);

        jButton2 = new JButton("Create Account");
        jButton2.setFont(new Font("Segoe UI", Font.BOLD, 18));
        jButton2.setBounds(650, 550, 200, 30);
        jButton2.setBackground(new Color(17, 70, 163)); // Changing button background color
        jButton2.setForeground(Color.WHITE);
        jButton2.addActionListener(this);
        panel.add(jButton2);

        jButton3 = new JButton("Back");
        jButton3.setFont(new Font("Segoe UI", Font.BOLD, 18));
        jButton3.setBounds(900, 550, 100, 30);
        jButton3.setBackground(new Color(221, 87, 70)); // Changing button background color
        jButton3.setForeground(Color.WHITE);
        jButton3.addActionListener(this);
        panel.add(jButton3);

        pack();
        setLocationRelativeTo(null);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jButton1) {
            txtname.setText("");
            txtEmail.setText("");
            txtPhone.setText("");
            txtDOB.setText("");
            txtid.setText("");
        } else if (e.getSource() == jButton2) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                String url = "jdbc:mysql://localhost:3306/project_java";
                String un = "root";
                String pas = "kewal2105";
                Connection conn = DriverManager.getConnection(url, un, pas);
                System.out.println("Connection Established");
                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                String username = txtname.getText();
                String usermail = txtEmail.getText();
                String userphone = txtPhone.getText();
                String userdob = txtDOB.getText();
                int usercafe_id = Integer.parseInt(txtid.getText());
                String insertuser = "insert into customer(name,email,phone_no,Date_Of_Birth,cafe_id) values('" + username + "','" + usermail + "','" + userphone + "','" + userdob + "','" + usercafe_id + "')";
                stmt.executeUpdate(insertuser);
                System.out.println("Values inserted successfully");
                Cust_info ci=new Cust_info();
                ci.setVisible(true);
                this.setVisible(false);
            } catch (Exception ex) {
                System.out.print(ex);
            }
        } else if (e.getSource() == jButton3) {
            Manager mn = new Manager();
            mn.setVisible(true);
            this.setVisible(false);
        }
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(() -> {
            new SignUp().setVisible(true);
        });
    }
}
