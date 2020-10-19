package help;

import org.apache.log4j.Logger;
import page.HomePage;

public class Log {

    public static org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger(HomePage.class);


    public static Logger getInstance() {
        return LOG;
    }
}
