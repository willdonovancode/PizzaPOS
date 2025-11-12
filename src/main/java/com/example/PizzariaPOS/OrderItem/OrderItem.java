//public class OrderItem {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    // The order this item belongs to
//    @ManyToOne
//    @JoinColumn(name = "order_id")
//    @JsonIgnore // Prevents infinite loops when serializing to JSON
//    private Order order;
//
//    // The menu item this refers to
//    @ManyToOne
//    @JoinColumn(name = "menu_item_id")
//    private MenuItem menuItem;
//
//    private int quantity;
//
//    // You might also store the price-at-time-of-purchase here
//    // private double price;
//
//    // Constructors
//    public OrderItem() {}
//
//    public OrderItem(Order order, MenuItem menuItem, int quantity) {
//        this.order = order;
//        this.menuItem = menuItem;
//        this.quantity = quantity;
//    }
//
//    // Getters and Setters
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Order getOrder() {
//        return order;
//    }
//
//    public void setOrder(Order order) {
//        this.order = order;
//    }
//
//    public MenuItem getMenuItem() {
//        return menuItem;
//    }
//
//    public void setMenuItem(MenuItem menuItem) {
//        this.menuItem = menuItem;
//    }
//
//    public int getQuantity() {
//        return quantity;
//    }
//
//    public void setQuantity(int quantity) {
//        this.quantity = quantity;
//    }
//}
