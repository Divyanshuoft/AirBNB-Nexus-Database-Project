public class ListingRating {
    private int lrid;
    private int rater;
    private int listing;
    private int rating;
    private String body;
    private String date;

    public ListingRating(int lrid, int rater, int listing, int rating, String body, String date) {
        this.lrid = lrid;
        this.rater = rater;
        this.listing = listing;
        this.rating = rating;
        this.body = body;
        this.date = date;
    }

    // Setters
    public void setLrid(int lrid) {
        this.lrid = lrid;
    }

    public void setRater(int rater) {
        this.rater = rater;
    }

    public void setListing(int listing) {
        this.listing = listing;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setDate(String date) {
        this.date = date;
    }

    // Getters
    public int getLrid() {
        return lrid;
    }

    public int getRater() {
        return rater;
    }

    public int getListing() {
        return listing;
    }

    public int getRating() {
        return rating;
    }

    public String getBody() {
        return body;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "ListingRating [body=" + body + ", date=" + date + ", lrid=" + lrid + ", listing=" + listing
                + ", rater=" + rater + ", rating=" + rating + "]";
    }
}
