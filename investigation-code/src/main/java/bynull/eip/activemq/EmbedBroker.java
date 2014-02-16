package bynull.eip.activemq;

import org.apache.activemq.broker.BrokerService;

import java.util.concurrent.Executors;

/**
 * Created by null on 2/16/14.
 */
public class EmbedBroker {

    public void start() throws Exception {
        Executors.newFixedThreadPool(3).submit(new Runnable() {
            @Override
            public void run() {
                BrokerService broker = new BrokerService();

                // configure the broker
                try {
                    broker.addConnector("vm://localhost");
                    broker.start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
