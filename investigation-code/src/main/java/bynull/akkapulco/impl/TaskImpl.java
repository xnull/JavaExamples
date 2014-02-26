package bynull.akkapulco.impl;

import bynull.akkapulco.api.Task;

/**
 * Created by null on 2/27/14.
 */
public class TaskImpl implements Task<String> {
    @Override
    public void execute(String parameter) {
        System.out.println("Hey hello");
    }
}
