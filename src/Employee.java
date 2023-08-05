public class Employee {
    private int uid;
    private String name;
    private String address;
    private String dob;
    private String occupation;
    private String sin;
    private String payment_info;

    public Employee(int uid, String name, String address, String dob, String occupation, String sin,
            String payment_info) {
        this.uid = uid;
        this.name = name;
        this.address = address;
        this.dob = dob;
        this.occupation = occupation;
        this.sin = sin;
        this.payment_info = payment_info;
    }

    // Getters
    public int getUid() {
        return uid;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getDob() {
        return dob;
    }

    public String getOccupation() {
        return occupation;
    }

    public String getSin() {
        return sin;
    }

    public String getPayment_info() {
        return payment_info;
    }

    // Setters
    public void setUid(int uid) {
        this.uid = uid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public void setSin(String sin) {
        this.sin = sin;
    }

    public void setPayment_info(String payment_info) {
        this.payment_info = payment_info;
    }

    @Override
    public String toString() {
        return "Employee [uid=" + uid + ", name=" + name + ", address=" + address + ", dob=" + dob + ", occupation="
                + occupation + ", sin=" + sin + ", payment_info=" + payment_info + "]";
    }
}
