package SoftWare;
/*
 * @index: 03
 * 表示管理员用户
 * 属性：
 * 1.username：用户名（默认）
 * 2.password：密码（默认）
 * 方法：
 * 1.login()：登录系统
 */
public class Admin {
    private String username = "admin";
    private String password = "admin123";

    // 默认构造方法
    public Admin() {}

    // 带参数的构造方法
    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getter 和 Setter 方法
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // 登录方法
    public boolean login(String inputUsername, String inputPassword) {
        return this.username.equals(inputUsername) && this.password.equals(inputPassword);
    }
}

