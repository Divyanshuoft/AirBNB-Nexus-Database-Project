public class Booking {
    private int bid;
    private int lid;
    private int rid;
    private String book_date;
    private String start;
    private String end;
    private double cost;
    private String ccInfo;
    private boolean is_cancelled;

    public Booking(int bid, int lid, int rid, String book_date, String start, String end, double cost, String ccInfo,
            boolean is_cancelled) {
        this.bid = bid;
        this.lid = lid;
        this.rid = rid;
        this.book_date = book_date;
        this.start = start;
        this.end = end;
        this.cost = cost;
        this.ccInfo = ccInfo;
        this.is_cancelled = is_cancelled;
    }

    // Getters
    public int getBid() {
        return bid;
    }

    public int getLid() {
        return lid;
    }

    public int getRid() {
        return rid;
    }

    public String getBook_date() {
        return book_date;
    }

    public String getStart() {
        return start;
    }

    public String getEnd() {
        return end;
    }

    public double getCost() {
        return cost;
    }

    public String getCcInfo() {
        return ccInfo;
    }

    public boolean isIs_cancelled() {
        return is_cancelled;
    }

    // Setters
    public void setBid(int bid) {
        this.bid = bid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public void setBook_date(String book_date) {
        this.book_date = book_date;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setCcInfo(String ccInfo) {
        this.ccInfo = ccInfo;
    }

    public void setIs_cancelled(boolean is_cancelled) {
        this.is_cancelled = is_cancelled;
    }

    @Override
    public String toString() {
        return "Booking [bid=" + bid + ", book_date=" + book_date + ", ccInfo=" + ccInfo + ", cost=" + cost
                + ", end=" + end + ", is_cancelled=" + is_cancelled + ", lid=" + lid + ", rid=" + rid + ", start="
                + start + "]";
    }
}
