package chainofresponsibility.company;

/**
 * @author jeymingwu
 * @date 2020/12/28 17:22
 */
public abstract class Manager {

    protected String name;

    protected Manager superior; // 上级

    public Manager(String name) {
        this.name = name;
    }

    public void setSuperior(Manager superior) {
        this.superior = superior;
    }

    public abstract void requestApplication(Request request);
}
