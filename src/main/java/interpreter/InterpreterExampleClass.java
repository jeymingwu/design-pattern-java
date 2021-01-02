package interpreter;

import java.util.ArrayList;

/**
 * 解释器模式
 *
 * @author jeymingwu
 * @date 2021/1/2 16:52
 */
// 包含解释器之外的一些全局信息
class Context {

    private String input;
    private String output;

    public Context() {
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }
}

// 抽象表达式，声明一个抽象的解释操作
abstract class AbstractExpression {

    public abstract void interpreter(Context context);
}

// 具体解释器1
class TerminalExpression extends AbstractExpression {

    @Override
    public void interpreter(Context context) {
        System.out.println("终端解释器");
    }
}

// 具体解释器2
class NonTerminalExpression extends AbstractExpression {

    @Override
    public void interpreter(Context context) {
        System.out.println("非终端解释器");
    }
}

public class InterpreterExampleClass {

    public static void main(String[] args) {

        Context context = new Context();
        ArrayList<AbstractExpression> list = new ArrayList<>();
        list.add(new TerminalExpression());
        list.add(new NonTerminalExpression());
        list.add(new TerminalExpression());
        list.add(new TerminalExpression());

        for (AbstractExpression exp : list) {
            exp.interpreter(context);
        }
    }
}
