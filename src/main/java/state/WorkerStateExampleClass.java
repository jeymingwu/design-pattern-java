package state;

class Worker {

    private WorkerState state;
    private double hour;
    private boolean finish;

    public Worker() {
        this.state = new ForenoonState();
    }

    public WorkerState getState() {
        return state;
    }

    public void setState(WorkerState state) {
        this.state = state;
    }

    public double getHour() {
        return hour;
    }

    public void setHour(double hour) {
        this.hour = hour;
    }

    public boolean isFinish() {
        return finish;
    }

    public void setFinish(boolean finish) {
        this.finish = finish;
    }

    public void doWork() {
        this.state.doWork(this);
    }
}

abstract class WorkerState {

    public abstract void doWork(Worker worker);
}

class ForenoonState extends WorkerState {

    @Override
    public void doWork(Worker worker) {
        if (worker.getHour() < 12) {
            System.out.println("当前时间：" + worker.getHour() + " 上午工作，精神百倍");
        } else {
            worker.setState(new NoonState());
            worker.doWork();
        }
    }
}

class NoonState extends WorkerState {

    @Override
    public void doWork(Worker worker) {
        if (worker.getHour() < 13) {
            System.out.println("当前时间：" + worker.getHour() + " 饿了，午饭；犯困，午休");
        } else {
            worker.setState(new AfternoonState());
            worker.doWork();
        }
    }
}

class AfternoonState extends WorkerState {

    @Override
    public void doWork(Worker worker) {
        if (worker.getHour() < 17) {
            System.out.println("当前时间：" + worker.getHour() + " 下午状态不错，继续努力");
        } else {
            worker.setState(new EveningState());
        }
    }
}

class EveningState extends WorkerState {

    @Override
    public void doWork(Worker worker) {
        if (worker.isFinish()) {
            worker.setState(new RestState());
            worker.doWork();
        } else if (worker.getHour() < 21){
            System.out.println("当前时间：" + worker.getHour() + " 加班，疲惫至极！");
        } else {
            worker.setState(new SleepingState());
            worker.doWork();
        }
    }
}

class SleepingState extends WorkerState {

    @Override
    public void doWork(Worker worker) {
        System.out.println("当前时间：" + worker.getHour() + " 不行了，睡着了。");
    }
}

class RestState extends WorkerState {

    @Override
    public void doWork(Worker worker) {
        System.out.println("当前时间：" + worker.getHour() + " 下班回家");
    }
}

public class WorkerStateExampleClass {

    public static void main(String[] args) {

        Worker worker = new Worker();
        worker.setHour(9);
        worker.doWork();
        worker.setHour(10);
        worker.doWork();
        worker.setHour(12);
        worker.doWork();
        worker.setHour(13);
        worker.doWork();
        worker.setHour(14);
        worker.doWork();
        worker.setHour(17);
        worker.doWork();

//        worker.setFinish(true);
        worker.setFinish(false);
        worker.doWork();
        worker.setHour(19);
        worker.doWork();
        worker.setHour(22);
        worker.doWork();
    }
}
