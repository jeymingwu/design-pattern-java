package composite.company;

/**
 * 组合模式-公司架构实现
 *
 * 2020.12.19
 */
public class CompanyCompositeExampleClass {

    public static void main(String[] args) {
        Company company = new ConcreteCompany("北京总公司");
        company.add(new HRDepartment("总公司人力资源部"));
        company.add(new FinanceDepartment("总公司财务部"));

        Company shanghaiCompany = new ConcreteCompany("上海华东分公司");
        shanghaiCompany.add(new HRDepartment("华东分公司人力资源部"));
        shanghaiCompany.add(new FinanceDepartment("华东分公司财务部"));
        company.add(shanghaiCompany);

        Company nanjingCompany = new ConcreteCompany("南京办事处");
        nanjingCompany.add(new HRDepartment("南京办事处人力资源部"));
        nanjingCompany.add(new FinanceDepartment("南京办事处财务部"));
        company.add(nanjingCompany);

        Company hangzhouCompany = new ConcreteCompany("杭州办事处");
        hangzhouCompany.add(new HRDepartment("杭州办事处人力资源部"));
        hangzhouCompany.add(new FinanceDepartment("杭州办事处财务部"));
        company.add(hangzhouCompany);

        System.out.println("结构图");
        company.display(1);

        System.out.println("\n职责：");
        company.lineOfDuty();
    }
}
