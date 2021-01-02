package interpreter.music;

/**
 * 演奏速度
 *
 * @author jeymingwu
 * @date 2021/1/2 17:43
 */
public class Speed extends AbstractExpression{

    @Override
    public void execute(String key, double value) {
        String speed = null;
        if (value < 500) {
            speed = "快速";
        } else if (value >= 1000) {
            speed = "慢速";
        } else {
            speed = "中速";
        }
        System.out.print(speed + " ");
    }
}
