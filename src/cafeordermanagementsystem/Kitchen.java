package cafeordermanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Kitchen extends JFrame {
    private JPanel contentPane;
    private JButton btnOrderComplete;
    private JButton btnRefresh; // Button for refreshing pending orders
    private JButton btnHome; // Button to go back to home
    private Connection conn;
    private Statement stmt;
    private ResultSet rs;
    private List<String> pendingOrders; // List to store pending order details
    private List<JCheckBox> checkBoxesList; // List to store checkboxes

    public Kitchen() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Set JFrame to fullscreen
        contentPane = new JPanel();
        contentPane.setBackground(new Color(154, 200, 205)); // Set background color
        contentPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        panel.setBackground(new Color(154, 200, 205)); // Set background color
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        pendingOrders = new ArrayList<>(); // Initialize the list to store pending order details
        checkBoxesList = new ArrayList<>(); // Initialize the list to store checkboxes

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/project_java";
            String un = "root";
            String pas = "kewal2105";
            conn = DriverManager.getConnection(url, un, pas);
            conn.setAutoCommit(false);

            fetchPendingOrders(panel); // Initial fetch of pending orders

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        btnOrderComplete = new JButton("Order Complete");
        // Add action listener to the button
        // Add action listener to the button
btnOrderComplete.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        try {
            for (int i = 0; i < checkBoxesList.size(); i++) {
                if (checkBoxesList.get(i).isSelected()) {
                    String orderInfo = pendingOrders.get(i);
                    // Extract item ID from order details
                    int itemIdStartIndex = orderInfo.indexOf("Item ID:") + 9;
                    int itemIdEndIndex = orderInfo.indexOf(",", itemIdStartIndex);
                    
                    // Check if comma is found before extracting substring
                    if (itemIdEndIndex != -1) {
                        String itemIdStr = orderInfo.substring(itemIdStartIndex, itemIdEndIndex).trim();
                        int itemId = Integer.parseInt(itemIdStr);

                        // Update order status to "complete" in the database
                        String updateQuery = "UPDATE OrderItems SET status = 'complete' WHERE item_id = ? LIMIT 1";
                        PreparedStatement updateStmt = conn.prepareStatement(updateQuery);
                        updateStmt.setInt(1, itemId);
                        int rowsAffected = updateStmt.executeUpdate();
                        conn.commit();

                        // Remove order details and checkbox from the lists
                        pendingOrders.remove(i);
                        panel.remove(checkBoxesList.get(i));
                        checkBoxesList.remove(i);
                        // Decrement i as we removed an element
                        i--;
                    } else {
                        // Handle the case where comma is not found
                        System.out.println("Comma not found in order details: " + orderInfo);
                    }
                }
            }
            // Repaint the panel after removing checkboxes
            panel.revalidate();
            panel.repaint();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
});


        btnRefresh = new JButton("Refresh"); // Initialize the refresh button
        // Add action listener to the refresh button
        btnRefresh.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fetchPendingOrders(panel); // Fetch pending orders when the refresh button is clicked
            }
        });
        
        btnHome = new JButton("Home"); // Initialize the home button
        // Add action listener to the home button
        btnHome.addActionListener(this::jHomeButtonActionPerformed);

        // Create a panel to hold the buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(btnOrderComplete);
        buttonPanel.add(btnRefresh);
        buttonPanel.add(btnHome);
        buttonPanel.setBackground(new Color(154, 200, 205)); // Set background color
        contentPane.add(buttonPanel, BorderLayout.SOUTH); // Add the buttons panel to the content pane

        // Increase font size and button size
        Font buttonFont = new Font("Arial", Font.BOLD, 24);
        btnOrderComplete.setFont(buttonFont);
        btnOrderComplete.setBackground(new Color(17, 70, 163));
        btnOrderComplete.setForeground(Color.WHITE);
        btnRefresh.setFont(buttonFont);        
        btnRefresh.setBackground(new Color(17, 70, 163));
        btnRefresh.setForeground(Color.WHITE);
        btnHome.setFont(buttonFont);        
        btnHome.setBackground(new Color(221, 87, 70));
        btnHome.setForeground(Color.WHITE);
        btnOrderComplete.setPreferredSize(new Dimension(250, 100));
        btnRefresh.setPreferredSize(new Dimension(250, 100));
        btnHome.setPreferredSize(new Dimension(250, 100));
    }

    // Method to fetch pending orders and populate the panel
    private void fetchPendingOrders(JPanel panel) {
        try {
            // Clear existing data
            panel.removeAll();
            pendingOrders.clear();
            checkBoxesList.clear();

            stmt = conn.createStatement();
            String query = "SELECT order_id, item_id, qty, dish_name, status FROM OrderItems where status = 'pending';";
            rs = stmt.executeQuery(query);

            // Populate the list with pending order details and create checkboxes
            while (rs.next()) {
                String orderInfo = "Dish Name: " + rs.getString("dish_name") +
                                    ", Qty: " + rs.getInt("qty") + 
                                    ", Order ID: " + rs.getInt("order_id") +
                                    ", Item ID: " + rs.getInt("item_id") +
                                    ", Status: " + rs.getString("status");
                pendingOrders.add(orderInfo);
                JCheckBox checkBox = new JCheckBox(orderInfo);
                checkBox.setFont(new Font("Arial", Font.PLAIN, 35));
                checkBox.setForeground(new Color(15,16,53)); // Set text color
                checkBox.setOpaque(false); // Make checkbox transparent
                panel.add(checkBox);
                checkBoxesList.add(checkBox);
            }
            
            // Repaint the panel after adding checkboxes
            panel.revalidate();
            panel.repaint();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
private void jHomeButtonActionPerformed(java.awt.event.ActionEvent evt) {
        HomePage hm = new HomePage();
        hm.setVisible(true);
        this.setVisible(false);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Kitchen frame = new Kitchen();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
