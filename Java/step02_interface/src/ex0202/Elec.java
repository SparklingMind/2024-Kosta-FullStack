package ex0202;

public class Elec {
    String code;
    int cost;

    Elec() {

    }

    Elec(String code, int cost) {
        this.code = code;
        this.cost = cost;
    }

    public String getCode() {

        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String toString() {
        return "code : " + this.code + " ";
    }

}