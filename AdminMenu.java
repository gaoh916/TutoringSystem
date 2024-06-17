package SoftWare;
/*
 * @index: 10
 * 管理员菜单界面
 * 方法：
 * 1.display()：显示管理员菜单界面
 */
import java.util.List;
import java.util.Scanner;

public class AdminMenu {
    private static final AdminService adminService = new AdminServiceImpl();

    public static void displayMenu(Scanner scanner) {
        while (true) {
            System.out.println("管理员菜单");
            System.out.println("1. 发布家教订单");
            System.out.println("2. 修改家教订单状态");
            System.out.println("3. 删除家教订单");
            System.out.println("4. 浏览空闲家教订单");
            System.out.println("5. 返回主菜单");
            System.out.print("请选择操作: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    createOrder(scanner);
                    break;
                case 2:
                    updateOrder(scanner);
                    break;
                case 3:
                    deleteOrder(scanner);
                    break;
                case 4:
                    browseOrders();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("无效的选择，请重新选择");
            }
        }
    }

    private static void createOrder(Scanner scanner) {
        System.out.print("请输入订单编号: ");
        int orderId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("请输入家教时间: ");
        String time = scanner.nextLine();
        System.out.print("请输入家教地址: ");
        String address = scanner.nextLine();
        System.out.print("请输入学生年级: ");
        String studentGrade = scanner.nextLine();
        System.out.print("请输入学生科目: ");
        String subject = scanner.nextLine();
        System.out.print("请输入对老师的要求: ");
        String requirements = scanner.nextLine();
        System.out.print("请输入给老师的报酬(课时费): ");
        String payment = scanner.nextLine();
        String status = "空闲";

        Order order = new Order(orderId, time, address, studentGrade, subject, requirements, payment, status);
        adminService.createOrder(order);
        System.out.println("订单发布成功");
    }

    private static void updateOrder(Scanner scanner) {
        System.out.print("请输入订单编号: ");
        int orderId = scanner.nextInt();
        scanner.nextLine();

        adminService.updateOrder(orderId);
        System.out.println("订单状态修改为“已出”");
    }

    private static void deleteOrder(Scanner scanner) {
        System.out.print("请输入订单编号: ");
        int orderId = scanner.nextInt();
        scanner.nextLine();

        adminService.deleteOrder(orderId);
        System.out.println("订单删除成功");
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
}
