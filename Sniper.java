public class Sniper extends Unit {

    private int shoots;

    public Sniper() {
        super(12, 10, new int[] { 8, 10 }, 15, 8, "Stand");
        shoots = 32;
    }

    @Override
    public String getInfo() {
        return "СНАЙПЕР:  " + super.getInfo() + ", Выстрелы: " + shoots + ", " + state + "\n";
    }

}
