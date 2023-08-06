public class ListingAmentities {
    private int lid;
    private int aid;

    public ListingAmentities(int lid, int aid) {
        this.lid = lid;
        this.aid = aid;
    }

    // Getters
    public int getLid() {
        return lid;
    }

    public int getAid() {
        return aid;
    }

    @Override
    public String toString() {
        return "ListingAmentities [aid=" + aid + ", lid=" + lid + "]";
    }
}