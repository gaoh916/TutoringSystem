package SoftWare;
/*
 * @index: 04
 * 表示家教订单
 * 属性：
 * 1.orderId：订单号
 * 2.time：时间
 * 3.address：地址
 * 4.studentGrade：学生年级
 * 5.subject：科目
 * 6.requirements：要求
 * 7.payment：报酬
 * 8.status：状态
 * 方法：
 * 1.createOrder()：创建订单
 * 2.updateOrder()：更新订单
 * 3.deleteOrder()：删除订单
 * 4.browseOrders()：浏览订单
 */
public class Order {
    private int orderId;
    private String time;
    private String address;
    private String studentGrade;
    private String subject;
    private String requirements;
    private String payment;
    private String status;

    public Order() {}

    public Order(int orderId, String time, String address, String studentGrade, String subject, String requirements, String payment, String status) {
        this.orderId = orderId;
        this.time = time;
        this.address = address;
        this.studentGrade = studentGrade;
        this.subject = subject;
        this.requirements = requirements;
        this.payment = payment;
        this.status = status;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStudentGrade() {
        return studentGrade;
    }

    public void setStudentGrade(String studentGrade) {
        this.studentGrade = studentGrade;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "订单编号=" + orderId + '\n' +
                ", 家教时间='" + time + '\'' + '\n' +
                ", 家教地址='" + address + '\'' + '\n' +
                ", 学生年级='" + studentGrade + '\'' + '\n' +
                ", 学生科目='" + subject + '\'' + '\n' +
                ", 对老师的要求='" + requirements + '\'' + '\n' +
                ", 课时费='" + payment + '\'' + '\n' +
                ", 订单状态='" + status + '\'' + '\n' +
                '}';
    }
}

