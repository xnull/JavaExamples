package bynull.eip.activemq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by null on 2/16/14.
 */
public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws Exception {

        startBroker();
        pause();
        runProducer();
        pause();
        runConsumer();

        System.out.println("This is the end");
    }

    private static void pause() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
    }

    private static void runConsumer() {
        logger.warn("Run consumer");
        ActiveMqConsumer consumer = new ActiveMqConsumer();
        consumer.run();
    }

    private static void runProducer() {
        logger.warn("Run producer");
        ActiveMqProduccer produccer = new ActiveMqProduccer();
        produccer.run();
    }

    private static void startBroker() throws Exception {
        logger.warn("start broker");
        EmbedBroker broker = new EmbedBroker();
        broker.start();
    }
}
