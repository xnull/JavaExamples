import bynull.Utils.Utils;

/**
 * @author: null
 * Date: 07.01.14
 * Time: 17:50
 */
public class ClsLdr {

    public static void main(String[] args) throws ClassNotFoundException {


        Utils.print("Class cloder: " + Class.forName(ClsLdr.class.getName()).getClassLoader());
    }
}
