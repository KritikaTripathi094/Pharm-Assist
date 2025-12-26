package Model;

/**
 *
 * @author rojal
 */
public class Product {
     private int id;
     private String name;
     private double price;
     private String image;
     private String category;
     private String description;  // Added description field
     private int stock;           // Added stock field

    // Default constructor
    public Product() {}

    // Constructor with id, name, price, and image
    public Product(int id, String name, double price, String image) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.image = image;
    }

    // Getters and setters for all fields, including the new ones
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {  // Getter for description
        return description;
    }

    public void setDescription(String description) {  // Setter for description
        this.description = description;
    }

    public int getStock() {  // Getter for stock
        return stock;
    }

    public void setStock(int stock) {  // Setter for stock
        this.stock = stock;
    }
}
