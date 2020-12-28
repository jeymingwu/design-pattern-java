package chainofresponsibility.company;

/**
 * @author jeymingwu
 * @date 2020/12/28 17:26
 */
public class CommonManager extends Manager{

    public CommonManager(String name) {
        super(name);
    }

    @Override
    public void requestApplication(Request request) {
        if (request.getType().equals("请假") && request.getNumber() <= 2) {
            System.out.println(this.getClass().getName() + " 处理请求：" + request);
        } else if (this.superior != null) {
            this.superior.requestApplication(request);
        } else {
            System.out.println(this.getClass().getName() + " 无法处理请求：" + request);
        }
    }
}
