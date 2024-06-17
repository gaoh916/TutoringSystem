package SoftWare;
/*
 * @index: 08
 * 实现管理员服务接口
 * 方法：
 * 1.loginAdmin(String username, String password)：登录管理员
 * 2.createOrder(Order order)：创建订单
 * 3.updateOrder(int orderId)：更新订单
 * 4.deleteOrder(int orderId)：删除订单
 * 5.browseOrders()：浏览订单
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminServiceImpl implements AdminService {

    @Override
    public boolean loginAdmin(String username, String password) {
        return "admin".equals(username) && "admin123".equals(password);
    }

    @Override
    public void createOrder(Order order) {
        String sql = "INSERT INTO order1 (orderId, time, address, studentGrade, subject, requirements, payment, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, order.getOrderId());
            statement.setString(2, order.getTime());
            statement.setString(3, order.getAddress());
            statement.setString(4, order.getStudentGrade());
            statement.setString(5, order.getSubject());
            statement.setString(6, order.getRequirements());
            statement.setString(7, order.getPayment());
            statement.setString(8, order.getStatus());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateOrder(int orderId) {
        String sql = "UPDATE order1 SET status = '已出' WHERE orderId = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, orderId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteOrder(int orderId) {
        String sql = "DELETE FROM order1 WHERE orderId = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, orderId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Order> browseOrders() {
        String sql = "SELECT * FROM order1 WHERE status = '空闲' ORDER BY orderId";
        List<Order> orders = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Order order = new Order();
                order.setOrderId(resultSet.getInt("orderId"));
                order.setTime(resultSet.getString("time"));
                order.setAddress(resultSet.getString("address"));
                order.setStudentGrade(resultSet.getString("studentGrade"));
                order.setSubject(resultSet.getString("subject"));
                order.setRequirements(resultSet.getString("requirements"));
                order.setPayment(resultSet.getString("payment"));
                order.setStatus(resultSet.getString("status"));
                orders.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }
}
