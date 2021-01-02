package interpreter.music;

/**
 * 音阶类
 *
 * @author jeymingwu
 * @date 2021/1/2 17:28
 */
public class Scale extends AbstractExpression {

    @Override
    public void execute(String key, double value) {
        String scale = null;
        switch ((int) value) {
            case 1:
                scale = "低音";
                break;
            case 2:
                scale = "中音";
                break;
            case 3:
                scale = "高音";
                break;
        }
        System.out.print(scale + " ");
    }
}
