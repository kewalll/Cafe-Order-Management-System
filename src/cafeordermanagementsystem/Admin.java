package cafeordermanagementsystem;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Admin extends JFrame {
    private JButton btnAddItem;
    private JButton btnEditItem;
    private JButton btnDeleteItem;
    private JButton btnAddEmployee;
    private JButton btnDeleteEmployee;
    private JButton btnViewBills;
    private JButton btnHomePage;    
    private JButton btnViewMenu;

    private JTable billsTable;
    private JScrollPane billsScrollPane;

    private Connection conn;
    private DefaultTableModel billsTableModel;

    public Admin() {
        initializeFrame();
        initializeButtons();
        connectToDatabase();
    }

    private void initializeFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Admin Page");
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Set to full screen
        getContentPane().setBackground(new Color(154, 200, 205)); // Set background color
        JLabel adminLabel = new JLabel("Admin");
    adminLabel.setFont(new Font("Arial", Font.BOLD, 70)); // Set font size and style
    adminLabel.setHorizontalAlignment(SwingConstants.CENTER); // Center align the text
//    adminLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0)); // Add some padding
    add(adminLabel, BorderLayout.NORTH);
        setLayout(new GridLayout(4, 1, 20, 20)); // Add padding/margin
    }

    private void initializeButtons() {
        // Set background color for buttons
        Color btnBackgroundColor = new Color(17, 70, 163);
        Font buttonFont = new Font("Arial", Font.PLAIN, 24);
        // Initialize buttons
    btnAddItem = new JButton("Add Item");
    btnAddItem.setBackground(btnBackgroundColor);
    btnAddItem.setForeground(Color.WHITE);
    btnAddItem.setFont(buttonFont);
    btnAddItem.setSize(200, 50);

    btnEditItem = new JButton("Edit Item Price");
    btnEditItem.setBackground(btnBackgroundColor);
    btnEditItem.setForeground(Color.WHITE);
    btnEditItem.setFont(buttonFont);
    btnEditItem.setSize(200, 50);

    btnDeleteItem = new JButton("Delete Item");
    btnDeleteItem.setBackground(btnBackgroundColor);
    btnDeleteItem.setForeground(Color.WHITE);
    btnDeleteItem.setFont(buttonFont);
    btnDeleteItem.setSize(200, 50);

    btnAddEmployee = new JButton("Add Employee");
    btnAddEmployee.setBackground(btnBackgroundColor);
    btnAddEmployee.setForeground(Color.WHITE);
    btnAddEmployee.setFont(buttonFont);
    btnAddEmployee.setSize(200, 50);

    btnDeleteEmployee = new JButton("Delete Employee");
    btnDeleteEmployee.setBackground(btnBackgroundColor);
    btnDeleteEmployee.setForeground(Color.WHITE);
    btnDeleteEmployee.setFont(buttonFont);
    btnDeleteEmployee.setSize(200, 50);

    btnViewBills = new JButton("View Bills");
    btnViewBills.setBackground(btnBackgroundColor);
    btnViewBills.setForeground(Color.WHITE);
    btnViewBills.setFont(buttonFont);
    btnViewBills.setSize(200, 50);

    btnHomePage = new JButton("Home Page");
    btnHomePage.setBackground(new Color(221, 87, 70));
    btnHomePage.setForeground(Color.WHITE);
    btnHomePage.setFont(buttonFont);
    btnHomePage.setSize(200, 50);

    btnViewMenu = new JButton("View Menu");
    btnViewMenu.setBackground(btnBackgroundColor);
    btnViewMenu.setForeground(Color.WHITE);
    btnViewMenu.setFont(buttonFont);
    btnViewMenu.setSize(200, 50);
        // Add action listeners
        btnAddItem.addActionListener(e -> addItem());
        btnEditItem.addActionListener(e -> editItem());
        btnDeleteItem.addActionListener(e -> deleteItem());
        btnAddEmployee.addActionListener(e -> addEmployee());
        btnDeleteEmployee.addActionListener(e -> deleteEmployee());
        btnViewBills.addActionListener(e -> viewBills());
        btnHomePage.addActionListener(e -> backToHomePage());
        btnViewMenu.addActionListener(e -> viewMenu());
        // Create panel for buttons
        JPanel buttonPanel = new JPanel(new GridLayout(1, 3, 50, 50)); // 3 buttons in one row
        buttonPanel.setBackground(new Color(154, 200, 205));
        buttonPanel.add(btnAddItem);
        buttonPanel.add(btnEditItem);
        buttonPanel.add(btnDeleteItem);

        // Add buttons panel to the frame
        add(buttonPanel);

        // Create panel for employee-related buttons
        JPanel employeeButtonPanel = new JPanel(new GridLayout(1, 3, 50, 50)); // 2 buttons in one row
        employeeButtonPanel.setBackground(new Color(154, 200, 205));
        employeeButtonPanel.add(btnAddEmployee);
        employeeButtonPanel.add(btnDeleteEmployee);

        // Add employee buttons panel to the frame
        add(employeeButtonPanel);
    
    employeeButtonPanel.add(btnViewMenu);
        // Create panel for view bills and home page buttons
        JPanel otherButtonPanel = new JPanel(new GridLayout(1, 2, 50, 50)); // 2 buttons in one row
        otherButtonPanel.setBackground(new Color(154, 200, 205));
        otherButtonPanel.add(btnViewBills);
        otherButtonPanel.add(btnHomePage);

        // Add view bills and home page buttons panel to the frame
        add(otherButtonPanel);
        
    }

    private void connectToDatabase() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/project_java";
            String un = "root";
            String pas = "kewal2105";
            conn = DriverManager.getConnection(url, un, pas);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    private void viewMenu(){
        menu men = new menu();
        men.setVisible(true);
    }
    private void editItem() {
        JTextField itemNameField = new JTextField();
        JTextField priceField = new JTextField();

        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Item Name:"));
        panel.add(itemNameField);
        panel.add(new JLabel("Price:"));
        panel.add(priceField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Edit Item Price",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            String itemName = itemNameField.getText();
            double price = Double.parseDouble(priceField.getText());

            try {
                // Execute SQL insert query to add the new item
                String query = "UPDATE Items SET price = ? WHERE item_name = ?";
                PreparedStatement pstmt = conn.prepareStatement(query);
                pstmt.setDouble(1, price);
                pstmt.setString(2, itemName);
                pstmt.executeUpdate();

                // Refresh the items table to display the newly added item

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void addItem() {
        JTextField itemNameField = new JTextField();
        JTextField priceField = new JTextField();

        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Item Name:"));
        panel.add(itemNameField);
        panel.add(new JLabel("Price:"));
        panel.add(priceField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Add New Item",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            String itemName = itemNameField.getText();
            double price = Double.parseDouble(priceField.getText());

            try {
                // Execute SQL insert query to add the new item
                String query = "INSERT INTO Items (item_name, price, cafe_id) VALUES (?, ?, 1)";
                PreparedStatement pstmt = conn.prepareStatement(query);
                pstmt.setString(1, itemName);
                pstmt.setDouble(2, price);
                pstmt.executeUpdate();

                // Refresh the items table to display the newly added item

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void deleteItem() {
        JTextField itemNameField = new JTextField();

        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Item Name:"));
        panel.add(itemNameField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Delete Item",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            String itemName = itemNameField.getText();

            try {
                // Execute SQL insert query to add the new item
                String deleteOrderItemsQuery = "DELETE FROM OrderItems WHERE item_id IN (SELECT item_id FROM Items WHERE item_name = ?)";
                PreparedStatement pstmtOrderItems = conn.prepareStatement(deleteOrderItemsQuery);
                pstmtOrderItems.setString(1, itemName);
                pstmtOrderItems.executeUpdate();

                // Then, delete the item from the Items table
                String deleteItemsQuery = "DELETE FROM Items WHERE item_name = ?";
                PreparedStatement pstmtItems = conn.prepareStatement(deleteItemsQuery);
                pstmtItems.setString(1, itemName);
                pstmtItems.executeUpdate();
                // Refresh the items table to display the newly added item

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void addEmployee() {
        JTextField nameField = new JTextField();
        JTextField phoneField = new JTextField();
        JTextField dobField = new JTextField();
        JTextField dojField = new JTextField();
        JTextField addressField = new JTextField();
        JTextField genderField = new JTextField(); // Use JComboBox for dropdown
        JTextField cafeIdField = new JTextField();

        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Phone:"));
        panel.add(phoneField);
        panel.add(new JLabel("Date of Birth:"));
        panel.add(dobField);
        panel.add(new JLabel("Date of Joining:"));
        panel.add(dojField);
        panel.add(new JLabel("Address:"));
        panel.add(addressField);
        panel.add(new JLabel("Gender:"));
        panel.add(genderField);
        panel.add(new JLabel("Cafe ID:"));
        panel.add(cafeIdField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Add New Employee",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            String name = nameField.getText();
            String phone = phoneField.getText();
            String dob = dobField.getText();
            String doj = dojField.getText();
            String address = addressField.getText();
            String gender = genderField.getText();
            int cafeId = Integer.parseInt(cafeIdField.getText());

            try {
                String query = "INSERT INTO Employee (name, phone_no, date_of_birth, date_of_joining, address, gender, cafe_id) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement pstmt = conn.prepareStatement(query);
                pstmt.setString(1, name);
                pstmt.setString(2, phone);
                pstmt.setString(3, dob);
                pstmt.setString(4, doj);
                pstmt.setString(5, address);
                pstmt.setString(6, gender);
                pstmt.setInt(7, cafeId);
                pstmt.executeUpdate();

                // Refresh the employee table or perform any other necessary actions

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void deleteEmployee() {
        JTextField empIdField = new JTextField();

        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Employee ID:"));
        panel.add(empIdField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Delete Employee",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            int empId = Integer.parseInt(empIdField.getText());

            try {
                // Delete the employee from the Employee table
                String deleteEmployeeQuery = "DELETE FROM Employee WHERE emp_id = ?";
                PreparedStatement pstmtEmployee = conn.prepareStatement(deleteEmployeeQuery);
                pstmtEmployee.setInt(1, empId);
                pstmtEmployee.executeUpdate();

                // Optionally, refresh the employee table or perform any other necessary actions

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void viewBills() {
        // Implement logic to view bills
        // Query the database to fetch all bills from the Bills table
        try {
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM Bills";
            ResultSet rs = stmt.executeQuery(query);

            // Create table model
            billsTableModel = new DefaultTableModel();
            billsTableModel.addColumn("Bill ID");
            billsTableModel.addColumn("Order ID");
            billsTableModel.addColumn("Total Amount");
            billsTableModel.addColumn("Tip Amount");

            // Populate table model
            while (rs.next()) {
                int billId = rs.getInt("bill_id");
                int orderId = rs.getInt("order_id");
                double totalAmt = rs.getDouble("total_amt");
                double tipAmt = rs.getDouble("tip_amt");
                billsTableModel.addRow(new Object[]{billId, orderId, totalAmt, tipAmt});
            }

            // Create table with the table model
            billsTable = new JTable(billsTableModel);

            // Add table to scroll pane
            billsScrollPane = new JScrollPane(billsTable);

            // Display table in a dialog
            JOptionPane.showMessageDialog(this, billsScrollPane, "Bills", JOptionPane.PLAIN_MESSAGE);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void backToHomePage() {
        HomePage hm = new HomePage();
        hm.setVisible(true);
        this.setVisible(false);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Admin frame = new Admin();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}