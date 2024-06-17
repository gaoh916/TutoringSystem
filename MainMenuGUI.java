package SoftWare;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MainMenuGUI extends JFrame {
    private static final AdminService adminService = new AdminServiceImpl();
    private static final UserService userService = new UserServiceImpl();

    public MainMenuGUI() {
        setTitle("家教订单管理系统");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(5, 1));

        JButton adminLoginButton = new JButton("管理员登录");
        JButton userLoginButton = new JButton("用户登录");
        JButton userRegisterButton = new JButton("用户注册");
        JButton exitButton = new JButton("退出系统");

        mainPanel.add(new JLabel("欢迎使用家教订单管理系统", SwingConstants.CENTER));
        mainPanel.add(adminLoginButton);
        mainPanel.add(userLoginButton);
        mainPanel.add(userRegisterButton);
        mainPanel.add(exitButton);

        add(mainPanel, BorderLayout.CENTER);

        adminLoginButton.addActionListener(e -> handleAdminLogin());
        userLoginButton.addActionListener(e -> handleUserLogin());
        userRegisterButton.addActionListener(e -> handleUserRegistration());
        exitButton.addActionListener(e -> System.exit(0));
    }

    private void handleAdminLogin() {
        JPanel panel = new JPanel(new GridLayout(3, 2));
        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();

        panel.add(new JLabel("管理员用户名:"));
        panel.add(usernameField);
        panel.add(new JLabel("管理员密码:"));
        panel.add(passwordField);

        int result = JOptionPane.showConfirmDialog(this, panel, "管理员登录", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            if (adminService.loginAdmin(username, password)) {
                JOptionPane.showMessageDialog(this, "管理员登录成功");
                adminMenu();
            } else {
                JOptionPane.showMessageDialog(this, "管理员用户名或密码错误");
            }
        }
    }

    private void adminMenu() {
        JFrame adminFrame = new JFrame("管理员菜单");
        adminFrame.setSize(400, 300);
        adminFrame.setLayout(new GridLayout(6, 1));
        adminFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        adminFrame.setLocationRelativeTo(null);

        JButton createOrderButton = new JButton("发布家教订单");
        JButton updateOrderButton = new JButton("修改家教订单状态");
        JButton deleteOrderButton = new JButton("删除家教订单");
        JButton browseOrdersButton = new JButton("浏览空闲家教订单");
        JButton backButton = new JButton("返回主菜单");

        adminFrame.add(new JLabel("管理员菜单", SwingConstants.CENTER));
        adminFrame.add(createOrderButton);
        adminFrame.add(updateOrderButton);
        adminFrame.add(deleteOrderButton);
        adminFrame.add(browseOrdersButton);
        adminFrame.add(backButton);

        createOrderButton.addActionListener(e -> createOrder());
        updateOrderButton.addActionListener(e -> updateOrder());
        deleteOrderButton.addActionListener(e -> deleteOrder());
        browseOrdersButton.addActionListener(e -> browseOrders());
        backButton.addActionListener(e -> adminFrame.dispose());

        adminFrame.setVisible(true);
    }

    private void createOrder() {
        JPanel panel = new JPanel(new GridLayout(8, 2));
        JTextField orderIdField = new JTextField();
        JTextField timeField = new JTextField();
        JTextField addressField = new JTextField();
        JTextField studentGradeField = new JTextField();
        JTextField subjectField = new JTextField();
        JTextField requirementsField = new JTextField();
        JTextField paymentField = new JTextField();

        panel.add(new JLabel("订单编号:"));
        panel.add(orderIdField);
        panel.add(new JLabel("家教时间:"));
        panel.add(timeField);
        panel.add(new JLabel("家教地址:"));
        panel.add(addressField);
        panel.add(new JLabel("学生年级:"));
        panel.add(studentGradeField);
        panel.add(new JLabel("学生科目:"));
        panel.add(subjectField);
        panel.add(new JLabel("对老师的要求:"));
        panel.add(requirementsField);
        panel.add(new JLabel("课时费:"));
        panel.add(paymentField);

        int result = JOptionPane.showConfirmDialog(this, panel, "发布家教订单", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            int orderId = Integer.parseInt(orderIdField.getText());
            String time = timeField.getText();
            String address = addressField.getText();
            String studentGrade = studentGradeField.getText();
            String subject = subjectField.getText();
            String requirements = requirementsField.getText();
            String payment = paymentField.getText();
            String status = "空闲";

            Order order = new Order(orderId, time, address, studentGrade, subject, requirements, payment, status);
            adminService.createOrder(order);
            JOptionPane.showMessageDialog(this, "订单发布成功");
        }
    }

    private void updateOrder() {
        String orderIdStr = JOptionPane.showInputDialog(this, "请输入订单编号:");
        if (orderIdStr != null) {
            int orderId = Integer.parseInt(orderIdStr);
            adminService.updateOrder(orderId);
            JOptionPane.showMessageDialog(this, "订单状态修改为“已出”");
        }
    }

    private void deleteOrder() {
        String orderIdStr = JOptionPane.showInputDialog(this, "请输入订单编号:");
        if (orderIdStr != null) {
            int orderId = Integer.parseInt(orderIdStr);
            adminService.deleteOrder(orderId);
            JOptionPane.showMessageDialog(this, "订单删除成功");
        }
    }

    private void browseOrders() {
        List<Order> orders = adminService.browseOrders();
        StringBuilder ordersStr = new StringBuilder();
        for (Order order : orders) {
            ordersStr.append(order.toString()).append("\n");
        }
        JOptionPane.showMessageDialog(this, ordersStr.toString(), "浏览空闲家教订单", JOptionPane.INFORMATION_MESSAGE);
    }

    private void handleUserLogin() {
        JPanel panel = new JPanel(new GridLayout(3, 2));
        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();

        panel.add(new JLabel("用户名:"));
        panel.add(usernameField);
        panel.add(new JLabel("密码:"));
        panel.add(passwordField);

        int result = JOptionPane.showConfirmDialog(this, panel, "用户登录", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            if (userService.loginUser(username, password)) {
                JOptionPane.showMessageDialog(this, "用户登录成功");
                userMenu();
            } else {
                JOptionPane.showMessageDialog(this, "用户名或密码错误");
            }
        }
    }

    private void handleUserRegistration() {
        JPanel panel = new JPanel(new GridLayout(10, 2));
        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        JTextField nameField = new JTextField();
        JTextField phoneField = new JTextField();
        JTextField schoolField = new JTextField();
        JTextField gradeField = new JTextField();
        JTextField genderField = new JTextField();
        JTextField advantagesField = new JTextField();
        JTextField teachingExperienceField = new JTextField();

        panel.add(new JLabel("用户名:"));
        panel.add(usernameField);
        panel.add(new JLabel("密码:"));
        panel.add(passwordField);
        panel.add(new JLabel("姓名:"));
        panel.add(nameField);
        panel.add(new JLabel("电话:"));
        panel.add(phoneField);
        panel.add(new JLabel("学校:"));
        panel.add(schoolField);
        panel.add(new JLabel("年级:"));
        panel.add(gradeField);
        panel.add(new JLabel("性别:"));
        panel.add(genderField);
        panel.add(new JLabel("个人优势:"));
        panel.add(advantagesField);
        panel.add(new JLabel("教学经验:"));
        panel.add(teachingExperienceField);

        int result = JOptionPane.showConfirmDialog(this, panel, "用户注册", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            String name = nameField.getText();
            String phone = phoneField.getText();
            String school = schoolField.getText();
            String grade = gradeField.getText();
            String gender = genderField.getText();
            String advantages = advantagesField.getText();
            String teachingExperience = teachingExperienceField.getText();

            User user = new User(username, password, name, phone, school, grade, gender, advantages, teachingExperience);
            userService.registerUser(user);
            JOptionPane.showMessageDialog(this, "用户注册成功");
        }
    }

    private void userMenu() {
        JFrame userFrame = new JFrame("用户菜单");
        userFrame.setSize(400, 300);
        userFrame.setLayout(new GridLayout(4, 1));
        userFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        userFrame.setLocationRelativeTo(null);

        JButton browseOrdersButton = new JButton("浏览空闲家教订单");
        JButton applyOrderButton = new JButton("申请接单");
        JButton backButton = new JButton("返回主菜单");

        userFrame.add(new JLabel("用户菜单", SwingConstants.CENTER));
        userFrame.add(browseOrdersButton);
        userFrame.add(applyOrderButton);
        userFrame.add(backButton);

        browseOrdersButton.addActionListener(e -> browseOrders());
        applyOrderButton.addActionListener(e -> applyOrder());
        backButton.addActionListener(e -> userFrame.dispose());

        userFrame.setVisible(true);
    }

    private void applyOrder() {
        String orderIdStr = JOptionPane.showInputDialog(this, "请输入订单编号:");
        if (orderIdStr != null) {
            int orderId = Integer.parseInt(orderIdStr);
            List<Order> orders = adminService.browseOrders();
            boolean orderFound = false;
            for (Order order : orders) {
                if (order.getOrderId() == orderId) {
                    orderFound = true;
                    if ("已出".equals(order.getStatus())) {
                        JOptionPane.showMessageDialog(this, "该订单已出");
                    } else {
                        adminService.updateOrder(orderId);
                        JOptionPane.showMessageDialog(this, "恭喜您接单成功\n请您联系微信 gaoh916 进行详细交流");
                    }
                    break;
                }
            }
            if (!orderFound) {
                JOptionPane.showMessageDialog(this, "您输入的订单不存在");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainMenuGUI mainMenu = new MainMenuGUI();
            mainMenu.setVisible(true);
        });
    }
}
