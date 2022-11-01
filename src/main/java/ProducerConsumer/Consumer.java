package ProducerConsumer;

// Using Runnable interface to have method: run
// for containing the code executed in the thread.
public class Consumer
        implements Runnable {
    private final Drop drop2;

    // Constructor
    public Consumer(Drop drop2) {
        this.drop2 = drop2;
    }

    public void run() {

        // Call take method of Drop class
        // to retrieve message
        for (String message = drop2.take();
             ! message.equals("DONE");
             message = drop2.take()) {

            System.out.format("MESSAGE RECEIVED: %s%n", message);

        }

    }
}