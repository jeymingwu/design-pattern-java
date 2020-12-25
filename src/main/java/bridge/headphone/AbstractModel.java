package bridge.headphone;

public abstract class AbstractModel {

    protected ISoft soft;

    public void setSoft(ISoft soft) {
        this.soft = soft;
    }

    public abstract void run();
}
