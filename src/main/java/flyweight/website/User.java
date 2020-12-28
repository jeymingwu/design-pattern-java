package flyweight.website;

/**
 * @author jeymingwu
 * @date 2020/12/28 21:35
 */
public class User {

    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
