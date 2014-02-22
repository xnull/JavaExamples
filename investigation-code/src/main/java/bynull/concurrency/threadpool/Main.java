package bynull.concurrency.threadpool;

import java.util.concurrent.TimeUnit;

/**
 * Created by null on 2/21/14.
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        int POOL_SIZE = 5;

        ThreadPool threadPool = new ThreadPool(POOL_SIZE, getResulter());

        for (int i = 0; i < POOL_SIZE; i++) {
            threadPool.execute(getCommand());
        }

        TimeUnit.SECONDS.sleep(1);
        threadPool.shutdown();
    }

    private static Command getCommand() {
        return new Command() {
            private String result;

            @Override
            public void execute(Worker worker, CommandResult resulter) throws Exception {
                result = "Hey hello. Worker: " + worker.getWorkerName();
                resulter.result(this);
            }

            @Override
            public String getResult() {
                return result;
            }
        };
    }

    private static CommandResult getResulter() {
        return new CommandResult() {
            @Override
            public void result(Command command) {
                System.out.println("Command complete. Result: " + command.getResult());
            }
        };
    }
}
