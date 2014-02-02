/**
 * @author: null
 * Date: 07.01.14
 * Time: 17:50
 */
public class ClsLdr {

    public static void main(String[] args) throws ClassNotFoundException {


        System.out.println("Class cloder: " + Class.forName(ClsLdr.class.getName()).getClassLoader());
    }
}
