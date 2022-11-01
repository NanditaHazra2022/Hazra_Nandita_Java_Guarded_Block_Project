package ProducerConsumer;

/* Java program to demonstrate guarded blocks.
* This is a multithreaded program, following are the threads:
*   1. main thread for program execution.
*   2. Thread for producer to send message.
*   3. Thread for consumer to retrieve message. */
public class ProducerConsumerMessageExchange {

    // starting point of execution
    public static void main(String[] args) {
        // Instantiate Drop class
        Drop dropObject = new Drop();

        // Start thread to send message
        (new Thread(new Producer(dropObject))).start();

        // Start thread to retrieve message
        (new Thread(new Consumer(dropObject))).start();
    }

}
