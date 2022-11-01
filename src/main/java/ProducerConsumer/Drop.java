package ProducerConsumer;

public class Drop {
    // Message sent from producer to consumer.
    private String message;

    // True if consumer should wait
    // for producer to send message,
    // false if producer should wait for
    // consumer to retrieve message.
    private boolean empty = true;

    // Method to be used by consumer
    // to retrieve message
    public synchronized String take() {
        // Guarded block: Wait until message is available.
        while (empty) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.err.println("Caught InterruptedException"
                        +  e.getMessage());
            }
        }

        // Toggle status.
        empty = true;

        // Notify that status has changed.
        notifyAll();

        return message;
    }

    // method used by producer
    // to send message
    public synchronized void put(String message) {
        // Guarded block: Wait until message has been retrieved.
        while (!empty) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.err.println("Caught InterruptedException"
                        +  e.getMessage());
            }
        }

        // Toggle status.
        empty = false;

        // Store message.
        this.message = message;

        // Notify consumer that status has changed.
        notifyAll();
    }

}
