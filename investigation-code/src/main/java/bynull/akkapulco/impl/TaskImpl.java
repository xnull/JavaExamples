package bynull.akkapulco.impl;

import bynull.Utils.Utils;
import bynull.akkapulco.api.Task;

/**
 * Created by null on 2/27/14.
 */
public class TaskImpl implements Task<String> {
    @Override
    public void execute(String parameter) {
        Utils.print("Hey hello");
    }
}
