package decorator.person;

public class TShirts extends Finery{

    @Override
    public void show() {
        System.out.println("大 T 恤");
        super.show();
    }
}
