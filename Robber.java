public class Robber extends Unit {

    public Robber() {
        super(8, 3, new int[] { 2, 4 }, 10, 6, "Stand");
    }

    @Override
    public String getInfo() {
        return "РАЗБОЙНИК:  " + super.getInfo() + ", " + state + "\n";
    }
}
