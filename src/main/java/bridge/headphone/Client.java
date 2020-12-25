package bridge.headphone;

public class Client {

    public static void main(String[] args) {
        ISoft playGame = new PlayGame();
        ISoft playMusic = new PlayMusic();

        AbstractModel apple = new Apple();
        apple.setSoft(playGame);
        apple.run();

        apple.setSoft(playMusic);
        apple.run();

        AbstractModel samsung = new Samsung();
        samsung.setSoft(playGame);
        samsung.run();

        samsung.setSoft(playMusic);
        samsung.run();
    }
}
