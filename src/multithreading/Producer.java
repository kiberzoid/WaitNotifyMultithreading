package multithreading;

public class Producer implements Runnable{
    private final Market market;

    public Producer(Market market) {
        this.market = market;
    }

    @Override
    public void run() {
        for(int i=0; i<20; i++) {
            market.putBread();
        }
    }
}
