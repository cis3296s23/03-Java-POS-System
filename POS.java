public class POS {
    public static void main(String[] args) {
        // create order
        Order order = new Order();
        
        // take payment from customer
        Payment payment = new Payment(order.getTotal());
        
        // create ticket for customer's order and send to kitchen printers
        Ticket ticket = new Ticket(order);
        ticket.sendToKitchen();
        
        // void a specific ticket
        ticket.voidTicket();
        
        // issue refund on an item
        Item itemToRefund = order.getItem(0);
        Refund refund = new Refund(itemToRefund.getPrice());
    }
}
