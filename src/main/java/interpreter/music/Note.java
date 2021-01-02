package interpreter.music;

/**
 * 音符类
 *
 * @author jeymingwu
 * @date 2021/1/2 17:25
 */
public class Note extends AbstractExpression {

    @Override
    public void execute(String key, double value) {
        String note = null;
        switch (key) {
            case "C":
                note = "1";
                break;
            case "D":
                note = "2";
                break;
            case "E":
                note = "3";
                break;
            case "F":
                note = "4";
                break;
            case "G":
                note = "5";
                break;
            case "A":
                note = "6";
                break;
            case "B":
                note = "7";
                break;
        }
        System.out.print(note + " ");
    }
}
