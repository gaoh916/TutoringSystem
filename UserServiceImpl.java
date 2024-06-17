package SoftWare;
/*
 * @index: 06
 * 实现用户服务接口
 * 方法：
 * 1.registerUser(User user)：注册用户
 * 2.loginUser(String username, String password)：登录用户
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserServiceImpl implements UserService {

    @Override
    public void registerUser(User user) {
        String sql = "INSERT INTO user1 (username, password, name, phone, school, grade, gender, advantages, teachingExperience) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getName());
            statement.setString(4, user.getPhone());
            statement.setString(5, user.getSchool());
            statement.setString(6, user.getGrade());
            statement.setString(7, user.getGender());
            statement.setString(8, user.getAdvantages());
            statement.setString(9, user.getTeachingExperience());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean loginUser(String username, String password) {
        String sql = "SELECT * FROM user1 WHERE username = ? AND password = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
