package config;

public interface URLConfigs {
    String API_URL = System.getProperty("apiURL", "https://api-test.afterpay.dev");
    String PORTAL_URL = System.getProperty("portalURL", "https://ac.myafterpay.com/en-se");
    String COMMAND_LINE_AUTH_KEY = System.getProperty("authKEY", "");
    String STORED_AUTH_KEY = "Q7DaxRnFls6IpwSW1SQ2FaTFOf7UdReAFNoKY68L";
}
