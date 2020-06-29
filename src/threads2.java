import java.time.Duration;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class threads2 {
    private static final Random generator = new Random();
    private static final Queue<String> quene = new LinkedList<>();

    public static void main(String[] args) {
        int itemCount = 5;

        Thread producer = new Thread(() -> {
            for (int i = 0; i < itemCount; i++) {
                try {
                    Thread.sleep(Duration.ofSeconds(generator.nextInt(5)).toMillis());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (quene) {
                    quene.add("Item no. " + i);
                    quene.notify();
                }
            }

        });


        Thread consumer = new Thread(() -> {
            int itemsLeft = itemCount;

            while (itemsLeft > 0) {
                String item;
                synchronized (quene) {
                    while (quene.isEmpty()) {
                        try {
                            quene.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    item = quene.poll();
                }
                itemsLeft--;
                System.out.println("Consumer got item: " + item);
            }

        }
        );


        System.out.println("hej");
        consumer.start();
        producer.start();
    }
}
