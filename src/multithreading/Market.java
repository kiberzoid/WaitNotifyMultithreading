package multithreading;

import java.util.Objects;

public class Market {
    private int breadCount;

    public Market() {
        this.breadCount = 0;
    }

    public synchronized void getBread() {
        while(breadCount < 1){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        breadCount--;
        System.out.println(Thread.currentThread().getName() + "Покупатель купил хлеб");
        System.out.println("В магазине осталось: " + breadCount);
        notifyAll();
    }

    public synchronized void putBread() {
        while(breadCount > 4){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        breadCount++;
        System.out.println(Thread.currentThread().getName() + "Производитель привез хлеб");
        System.out.println("В магазине осталось: " + breadCount);
        notifyAll();
    }

    @Override
    public String toString() {
        return "Market{" +
                "breadCount=" + breadCount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o.getClass() != getClass()) return false;
        Market market = (Market) o;
        return breadCount == market.breadCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(breadCount);
    }
}
