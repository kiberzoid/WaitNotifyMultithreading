package multithreading;

public class Main {
    public static void main(String[] args){
        Market market = new Market();
        Thread consumer1 = new Thread(new Consumer(market));
        Thread consumer2 = new Thread(new Consumer(market));
        Thread producer = new Thread(new Producer(market));
        consumer1.setName("consumer1 - ");
        consumer2.setName("consumer2 - ");
        producer.setName("producer - ");
        consumer1.start();
        consumer2.start();
        producer.start();
    }
}
