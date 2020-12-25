package proxy;

public class Pursuit implements IGiveGift{

    private Girl girl;

    public Pursuit() {
    }

    public Pursuit(Girl girl) {
        this.girl = girl;
    }

    @Override
    public void giveDolls() {
        System.out.println(this.girl.getName() + "，送你洋娃娃");
    }

    @Override
    public void giveFlowers() {
        System.out.println(this.girl.getName() + "，送你鲜花");
    }

    @Override
    public void giveChocolate() {
        System.out.println(this.girl.getName() + "，送你巧克力");
    }
}
