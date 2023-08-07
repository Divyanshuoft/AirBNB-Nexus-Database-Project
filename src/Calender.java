public class Calender {
    private int cid;
    private String start;
    private String end;
    private int lid;

    public Calender(int cid, String start, String end, int lid) {
        this.cid = cid;
        this.start = start;
        this.end = end;
        this.lid = lid;
    }

    public int getCid() {
        return cid;
    }

    public String getStart() {
        return start;
    }

    public String getEnd() {
        return end;
    }

    public int getLid() {
        return lid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    @Override
    public String toString() {
        return "Calender [cid=" + cid + ", end=" + end + ", lid=" + lid + ", start=" + start + "]";
    }
}
