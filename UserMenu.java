package SoftWare;
/*
 * @index: 11
 * 用户菜单界面
 * 方法：
 * 1.display()：显示用户菜单界面
 */
import java.util.List;
import java.util.Scanner;

public class UserMenu {
    private static final AdminService adminService = new AdminServiceImpl();
    private static final UserService userService = new UserServiceImpl();

    public static void displayMenu(Scanner scanner) {
        while (true) {
            System.out.println("用户菜单");
            System.out.println("1. 浏览空闲家教订单");
            System.out.println("2. 申请接单");
            System.out.println("3. 返回主菜单");
            System.out.print("请选择操作: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // 消费掉换行符

            switch (choice) {
                case 1:
                    browseOrders();
                    break;
                case 2:
                    applyOrder(scanner);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("无效的选择，请重新选择");
            }
        }
    }

    private static void browseOrders() {
        List<Order> orders = adminService.browseOrders();
        if (orders.isEmpty()) {
            System.out.println("当前没有空闲的家教订单。");
        } else {
            for (Order order : orders) {
                System.out.println(order);
            }
        }
    }

    private static void applyOrder(Scanner scanner) {
        System.out.print("请输入订单编号: ");
        int orderId = scanner.nextInt();
        scanner.nextLine();

        List<Order> orders = adminService.browseOrders();
        boolean orderFound = false;
        for (Order order : orders) {
            if (order.getOrderId() == orderId) {
                orderFound = true;
                if ("已出".equals(order.getStatus())) {
                    System.out.println("该订单已出");
                } else {
                    adminService.updateOrder(orderId);
                    System.out.println("恭喜您接单成功");
                    System.out.println("请您联系微信 gaoh916 进行详细交流");
                }
                break;
            }
        }

        if (!orderFound) {
            System.out.println("您输入的订单不存在");
        }
    }
}
