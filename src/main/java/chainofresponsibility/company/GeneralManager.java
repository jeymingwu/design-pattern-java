package chainofresponsibility.company;

/**
 * @author jeymingwu
 * @date 2020/12/28 17:32
 */
public class GeneralManager extends Manager {

    public GeneralManager(String name) {
        super(name);
    }

    @Override
    public void requestApplication(Request request) {
        if (request.getType().equals("请假")) {
            System.out.println(this.getClass().getName() + " 处理请求：" + request);
        } else if (request.getType().equals("加薪")) {
            if (request.getNumber() <= 500) {
                System.out.println(this.getClass().getName() + " 处理请求：" + request);
            } else {
                System.out.println(this.getClass().getName() + " 拒绝请求：" + request);
            }
        } else if (this.superior != null) {
            this.superior.requestApplication(request);
        } else {
            System.out.println(this.getClass().getName() + " 无法处理请求：" + request);
        }
    }
}
