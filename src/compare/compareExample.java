package compare;

public class compareExample implements Comparable<compareExample> {

    private int size;
    private String brandName;

    public int getSize() {
        return size;
    }

    public String getBrandName() {
        return brandName;
    }

    @Override
    public int compareTo(compareExample o) {
        if(this.size < o.size){
            return -1;
        } else if (this.size > o.size) {
            return 1;
        }
        else {
            return 0;
        }
    }
}

