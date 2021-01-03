package visitor.person;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jeymingwu
 * @date 2021/1/3 23:24
 */
public class ObjectStructure {

    private List<Person> people = new ArrayList<>();

    public void attach(Person person) {
        people.add(person);
    }

    public void detach(Person person) {
        people.remove(person);
    }

    public void display(Action action) {
        for (Person person:people) {
            person.accept(action);
        }
    }
}
