public class Crossbowman extends Unit{

    private int shoots;

    public Crossbowman() {
        super(6, 3, new int[]{2,3}, 10, 4, "Stand");
        shoots = 16;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "АРБАЛЕТЧИК:  " + super.toString() + ", Выстрелы: " + shoots + ", " + state + "\n";
    }
    
}