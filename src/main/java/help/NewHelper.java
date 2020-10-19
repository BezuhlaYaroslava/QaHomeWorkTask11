package help;

public class NewHelper {
    public static void waitUnEl(){
        try {
            Thread.sleep(5*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
