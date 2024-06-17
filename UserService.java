package SoftWare;
/*
 * @index: 05
 * 定义用户服务的接口
 * 方法：
 * 1.registerUser(User user)：注册用户
 * 2.loginUser(String username, String password)：登录用户
 */
public interface UserService {
    void registerUser(User user);
    boolean loginUser(String username, String password);
}
