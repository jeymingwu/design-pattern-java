package composite.company;

public class FinanceDepartment extends Company{

    public FinanceDepartment(String name) {
        super(name);
    }

    @Override
    public void add(Company company) {

    }

    @Override
    public void remove(Company company) {

    }

    @Override
    public void display(int depth) {
        for (int i = 0; i < depth; ++i) {
            System.out.print("-");
        }
        System.out.println(this.name);
    }

    @Override
    public void lineOfDuty() {
        System.out.println(name + " 负责财务收支管理");
    }
}
