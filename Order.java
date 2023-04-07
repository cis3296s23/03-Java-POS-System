import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private String customerName;
    private List<String> items = new ArrayList<>();
    private LocalDateTime orderTime;
    private double totalPrice;
    private String paymentMethod;

    public Order(String customerName, List<String> items, double totalPrice, String paymentMethod) {
        this.customerName = customerName;
        this.items = items;
        this.totalPrice = totalPrice;
        this.paymentMethod = paymentMethod;
        this.orderTime = LocalDateTime.now();
    }
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }
}
