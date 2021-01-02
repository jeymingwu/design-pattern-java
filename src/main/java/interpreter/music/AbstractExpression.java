package interpreter.music;

/**
 * 音乐解释器
 * O 表示音阶，“O 1” 表示低音阶，“O 2” 表示中音阶，“O 3” 表示高音阶；
 * P 表示休止符；
 * “C D E F G A B” 表示 “Do-Re-Mi-Fa-So-La-Ti”；
 * 音符长度：“1” 表示一拍，“2” 表示二拍，“0.5” 表示半拍，“0.25” 表示四分之一拍；
 *
 * @author jeymingwu
 * @date 2021/1/2 17:07
 */
public abstract class AbstractExpression {

    public void interpreter(PlayContext context) {
        if (context.getText().length() == 0) {
            return;
        } else {
            String playKey = context.getText().substring(0, 1);
            context.setText(context.getText().substring(2));
            double playValue = Double.valueOf(context.getText().substring(0, context.getText().indexOf(" ")));
            context.setText(context.getText().substring(context.getText().indexOf(" ") + 1));

            execute(playKey, playValue);
        }
    }

    public abstract void execute(String key, double value);
}
