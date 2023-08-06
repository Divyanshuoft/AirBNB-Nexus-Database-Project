public class UserRating {

    private int urid;
    private int rater;
    private int ratee;
    private int rating;
    private String body;
    private String date;

    public UserRating(int urid, int rater, int ratee, int rating, String body, String date) {
        this.urid = urid;
        this.rater = rater;
        this.ratee = ratee;
        this.rating = rating;
        this.body = body;
        this.date = date;
    }

    // Setters
    public void setUrid(int urid) {
        this.urid = urid;
    }

    public void setRater(int rater) {
        this.rater = rater;
    }

    public void setRatee(int ratee) {
        this.ratee = ratee;
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
    public int getUrid() {
        return urid;
    }

    public int getRater() {
        return rater;
    }

    public int getRatee() {
        return ratee;
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
        return "UserRating [body=" + body + ", date=" + date + ", rater=" + rater + ", ratee=" + ratee + ", rating="
                + rating + ", urid=" + urid + "]";
    }

}
