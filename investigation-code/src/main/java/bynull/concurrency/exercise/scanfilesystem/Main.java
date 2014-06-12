package bynull.concurrency.exercise.scanfilesystem;

import bynull.Utils.Utils;

import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;

/**
 * Created by null on 12.06.14.
 */
public class Main {

    private static final Random RND = new SecureRandom();

    private static class DirectoryReader extends RecursiveTask<List<String>> {

        private final File directory;
        private final String taskId;

        private DirectoryReader(File directory) {
            this.directory = directory;
            taskId = String.valueOf(hashCode());
        }

        @Override
        protected List<String> compute() {
            System.out.printf("Process directory. Task id: %s, thread: %s, dir: %s %n", taskId, Thread.currentThread().getName(), directory);

            List<String> files = new ArrayList<>();

            File[] directoryContent = directory.listFiles();
            if (directoryContent == null){
                return files;
            }

            List<DirectoryReader> asyncTasks = new ArrayList<>();
            for (File file : directoryContent) {
                if (file.isDirectory()){
                    DirectoryReader dirTask = new DirectoryReader(file);
                    asyncTasks.add(dirTask);
                    dirTask.fork();
                }
                else{
                    files.add(file.getAbsolutePath());
                }
            }

            for (DirectoryReader asyncTask : asyncTasks) {
                files.addAll(asyncTask.join());
            }

            System.out.printf("Task id: %s is end%n", taskId);
            return files;
        }
    }

    public static void main(String[] args) throws InterruptedException, IOException {

        File rootDir = createTestDirectoryAndFiles();

        ForkJoinPool forkJoinPool = new ForkJoinPool();

        List<String> result = forkJoinPool.invoke(new DirectoryReader(rootDir));

        System.out.println("");
        System.out.println("------ Result ------");
        System.out.println("Found : " + result.size() + " files");
        System.out.println("------");
        System.out.println("");

        deleteDir(rootDir);
        System.out.println("The end");
    }

    private static File createTestDirectoryAndFiles() throws IOException {
        File rootDir = createDirectory(new File(System.getProperty("java.io.tmpdir")), String.valueOf(RND.nextLong()));

        for (int i = 0; i < 10; i++) {
            createDirectory(rootDir, "child-" + i);
        }

        new File(rootDir, RND.nextLong() + ".txt").createNewFile();
        for (int i = 0; i < 100; i++) {
            new File(new File(rootDir, "child-1"), RND.nextLong() + ".txt").createNewFile();
            new File(new File(rootDir, "child-2"), RND.nextLong() + ".txt").createNewFile();
        }
        return rootDir;
    }

    private static void deleteDir(File file) {
        if (!file.isDirectory()){
            file.delete();
            return;
        }

        if (file.listFiles() == null){
            return;
        }

        for (File subFile : file.listFiles()) {
            deleteDir(subFile);
        }

        if (file.isDirectory()){
            file.delete();
        }

    }

    private static File createDirectory(File parentDir, String dirName) {
        File dir = new File(parentDir, dirName);
        dir.mkdirs();
        return dir;
    }
}
