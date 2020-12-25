package decorator.person;

public class Finery extends Person{

    private Person component;

    public void decorate(Person component) {
        this.component = component;
    }

    @Override
    public void show() {
        if (this.component != null) {
            component.show();
        }
    }
}
