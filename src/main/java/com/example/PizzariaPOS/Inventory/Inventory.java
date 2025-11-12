//public class Inventory {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    // This links the stock to a specific menu item
//    @OneToOne
//    @JoinColumn(name = "menu_item_id", referencedColumnName = "id")
//    private MenuItem menuItem;
//
//    private int quantity;
//
//    // Constructors
//    public Inventory() {}
//
//    public Inventory(MenuItem menuItem, int quantity) {
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
