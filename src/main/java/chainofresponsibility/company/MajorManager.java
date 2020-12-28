package chainofresponsibility.company;

/**
 * @author jeymingwu
 * @date 2020/12/28 17:31
 */
public class MajorManager extends Manager {

    public MajorManager(String name) {
        super(name);
    }

    @Override
    public void requestApplication(Request request) {
        if (request.getType().equals("请假") && request.getNumber() <= 5) {
            System.out.println(this.getClass().getName() + " 处理请求：" + request);
        } else if (this.superior != null) {
            this.superior.requestApplication(request);
        } else {
            System.out.println(this.getClass().getName() + " 无法处理请求：" + request);
        }
    }
}
