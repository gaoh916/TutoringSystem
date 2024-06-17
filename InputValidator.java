package SoftWare;
/*
 * @index: 12
 * 验证用户输入的工具类
 * 方法：
 * 1.validateUsername(String username)：验证用户名是否合法
 * 2.validatePassword(String password)：验证密码是否合法
 * validateOrderId(int orderId)：验证订单号是否合法
 */
public class InputValidator {

    public static boolean validateUsername(String username) {
        // 用户名不能为空，并且长度在3到20个字符之间
        return username != null && username.length() >= 3 && username.length() <= 20;
    }

    public static boolean validatePassword(String password) {
        // 密码不能为空，并且长度在6到20个字符之间
        return password != null && password.length() >= 6 && password.length() <= 20;
    }

    public static boolean validateOrderId(int orderId) {
        // 订单编号应为正整数
        return orderId > 0;
    }
}

