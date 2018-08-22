package common;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;


public class CommonVars {

    private static final String env = System.getProperty("env", "local");
    private static final String propertiesFile = env + ".properties";
    private static final Config config = ConfigFactory.load(propertiesFile).withFallback(ConfigFactory.load("local.properties"));

    public static final int numberRangeDivisionFactor = CommonVars.config.getInt("number_range_division_factor");

}

