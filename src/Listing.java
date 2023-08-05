public class Listing {
    private int lid;
    private int hid;
    private String type;
    private double price;
    private double latitude;
    private double longitude;
    private String address;
    private String postal;
    private String city;
    private String country;

    public Listing(int lid, int hid, String type, double price, double latitude, double longitude, String address,
            String postal, String city, String country) {
        this.lid = lid;
        this.hid = hid;
        this.type = type;
        this.price = price;
        this.latitude = latitude;
        this.longitude = longitude;
        this.address = address;
        this.postal = postal;
        this.city = city;
        this.country = country;
    }

    // Getters
    public int getLid() {
        return lid;
    }

    public int getHid() {
        return hid;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getAddress() {
        return address;
    }

    public String getPostal() {
        return postal;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    // Setters
    public void setLid(int lid) {
        this.lid = lid;
    }

    public void setHid(int hid) {
        this.hid = hid;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPostal(String postal) {
        this.postal = postal;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Listing [" +
                "lid=" + lid +
                ", hid=" + hid +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", address='" + address + '\'' +
                ", postal='" + postal + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ']';
    }
}
