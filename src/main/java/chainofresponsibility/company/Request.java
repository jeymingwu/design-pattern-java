package chainofresponsibility.company;

/**
 * @author jeymingwu
 * @date 2020/12/28 17:24
 */
public class Request {

    private String type;
    private String content;
    private int number;

    public Request(String type, String content, int priority) {
        this.type = type;
        this.content = content;
        this.number = priority;
    }

    public String getType() {
        return type;
    }

    public String getContent() {
        return content;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Request{" +
                "type='" + type + '\'' +
                ", content='" + content + '\'' +
                ", priority=" + number +
                '}';
    }
}
