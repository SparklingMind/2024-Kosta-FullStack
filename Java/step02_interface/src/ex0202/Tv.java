package ex0202;

public class Tv extends Elec implements ElecFunction {
    int channel;

    Tv() {

    }

    public Tv(int channel) {
        this.channel = channel;
    }

    public Tv(String code, int cost, int channel) {
        super(code, cost);
        this.channel = channel;
    }

    @Override
    public void display() {

    }

    @Override
    public void start() {
        System.out.println(this.code + "제품 Tv를 " + this.channel + " 을 본다.");
    }

    @Override
    public void stop() {

    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(super.toString());
        builder.append("channel = " + this.channel);
        return builder.toString();
    }

}
