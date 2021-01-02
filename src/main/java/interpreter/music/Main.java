package interpreter.music;

/**
 * @author jeymingwu
 * @date 2021/1/2 17:30
 */
public class Main {

    public static void main(String[] args) {

        PlayContext playContext = new PlayContext();
        System.out.println("演奏-上海滩");
        String text = "T 500 O 2 E 0.5 G 0.5 A 3 E 0.5 G 0.5 D 3 E 0.5 G 0.5 A 0.5 O 3 C 1 O 2 A 0.5 G 1 C 0.5 E 0.5 " +
                "D 3 ";
        playContext.setText(text);
        AbstractExpression expression = null;
        try {
            while (playContext.getText().length() > 0) {
                String str = playContext.getText().substring(0, 1);
                switch (str) {
                    case "O":
                        expression = new Scale();
                        break;
                    case "T":
                        expression = new Speed();
                        break;
                    case "C":
                    case "D":
                    case "E":
                    case "F":
                    case "G":
                    case "A":
                    case "B":
                    case "P":
                        expression = new Note();
                        break;
                }
                expression.interpreter(playContext);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
