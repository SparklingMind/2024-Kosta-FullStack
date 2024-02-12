package ex0202;

public class Audio extends Elec implements ElecFunction {
    int volume;

    Audio() {

    }

    Audio(int volumn) {
        this.volume = volumn;
    }

    Audio(String code, int cost, int volumn) {
        super(code, cost);
        this.volume = volumn;
    }

    @Override
    public void display() {

    }

    @Override
    public void start() {
        System.out.println(this.code + "의 Audio를 " + this.volume + " 으로 듣는다. ");
    }

    @Override
    public void stop() {

    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(super.toString());
        builder.append("volume = " + this.volume);
        return builder.toString();
    }

}
