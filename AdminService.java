package SoftWare;
/*
 * @index: 07
 * 定义管理员服务接口
 * 方法：
 * 1.loginAdmin(String username, String password)：登录管理员
 * 2.createOrder(Order order)：创建订单
 * 3.updateOrder(int orderId)：更新订单
 * 4.deleteOrder(int orderId)：删除订单
 * 5.browseOrders()：浏览订单
 */
import java.util.List;

public interface AdminService {
    boolean loginAdmin(String username, String password);
    void createOrder(Order order);
    void updateOrder(int orderId);
    void deleteOrder(int orderId);
    List<Order> browseOrders();
}

