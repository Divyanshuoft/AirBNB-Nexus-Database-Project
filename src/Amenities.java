public class Amenities {
    private int aid;
    private String name;
    private double price;

    public Amenities(int aid, String name, double price) {
        this.aid = aid;
        this.name = name;
        this.price = price;
    }

    // Getters
    public int getAid() {
        return aid;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    // Setters
    public void setAid(int aid) {
        this.aid = aid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Amenities [aid=" + aid + ", name=" + name + ", price=" + price + "]";
    }
}
