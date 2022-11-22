public class Monk extends Unit{

    private boolean magic;

    public Monk() {
        super(12, 7, new int[]{-4,-4}, 30, 5, "Stand");
        magic = true;
    }
    

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "МОНАХ:  " + super.toString() + ", Магия, " + state + "\n";
    }
}
