package Week04;
import java.util.List;

public interface OrderData {
    void addOrder(Order order);
    List<Order> getOrdersByDate(String date);
    double getTotalAmountByCustomer(String customerName);
}