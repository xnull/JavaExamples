package bynull.architecture;

import bynull.architecture.rest.Request;
import bynull.architecture.rest.RestEndpoint;

/**
 * Created by null on 2/13/14.
 */
public class Main {

    public static void main(String[] args) {
        RestEndpoint rest = new RestEndpoint();
        rest.execute(new Request());
    }
}
