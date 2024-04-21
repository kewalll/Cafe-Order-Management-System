package cafeordermanagementsystem;


import java.awt.Color;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class HomePage extends JFrame {

    public HomePage() {
        initComponents();
        customizeUI();
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Set JFrame to fullscreen
    }
    
    private void customizeUI() {
        getContentPane().setBackground(new Color(154, 200, 205)); // Setting background color
        
        jLabel1.setForeground(new Color(30, 3, 36)); // Changing text color
        jLabel1.setFont(new Font("Arial", Font.BOLD, 60)); // Changing font
        
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

        jLabel1 = new JLabel();
        jButton1 = new JButton();
        jButton2 = new JButton();
        jButton3 = new JButton();
        jButton4 = new JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("The Café");

        jLabel1.setText("The Cafe");

        jButton1.setText("Admin");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        jButton2.setText("Manager");
        jButton2.addActionListener(this::jButton2ActionPerformed);

        jButton3.setText("Kitchen");
        jButton3.addActionListener(this::jButton3ActionPerformed);

        jButton4.setText("Exit");
        jButton4.addActionListener(this::jButton4ActionPerformed);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(500, 500,500)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                .addGap(100, 100, 100)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(381, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(625, 625, 625)
                .addComponent(jLabel1)
                .addContainerGap(600, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jLabel1)
                .addGap(100, 100, 100)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(150, Short.MAX_VALUE))
        );

        pack();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        LoginAdmin adm = new LoginAdmin();
        adm.setVisible(true);
        this.setVisible(false);
    }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        LoginManager man = new LoginManager();
        man.setVisible(true);
        this.setVisible(false);
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        LoginKitchen kit = new LoginKitchen();
        kit.setVisible(true);
        this.setVisible(false);
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
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new HomePage().setVisible(true);
        });
    }

    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JButton jButton4;
    private JLabel jLabel1;
}
