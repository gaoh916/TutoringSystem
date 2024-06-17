package SoftWare;
/*
 * @index: 02
 * 表示普通用户（家教老师）
 * 属性：
 * 1.username：用户名
 * 2.password：密码
 * 3.name：姓名
 * 4.phone：电话
 * 5.school：学校
 * 6.grade：年级
 * 7.gender：性别
 * 8.advantages：优势
 * 9.teachingExperience：教学经验
 * 方法：
 * 1.register()：注册
 * 2.login()：登录
 */
public class User {
    private String username;
    private String password;
    private String name;
    private String phone;
    private String school;
    private String grade;
    private String gender;
    private String advantages;
    private String teachingExperience;

    // 默认构造方法
    public User() {}

    // 带参数的构造方法
    public User(String username, String password, String name, String phone, String school, String grade, String gender, String advantages, String teachingExperience) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.school = school;
        this.grade = grade;
        this.gender = gender;
        this.advantages = advantages;
        this.teachingExperience = teachingExperience;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAdvantages() {
        return advantages;
    }

    public void setAdvantages(String advantages) {
        this.advantages = advantages;
    }

    public String getTeachingExperience() {
        return teachingExperience;
    }

    public void setTeachingExperience(String teachingExperience) {
        this.teachingExperience = teachingExperience;
    }
}
