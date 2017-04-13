import com.ebay.sdk.ApiContext;
import com.ebay.sdk.ApiCredential;
import com.ebay.sdk.call.GeteBayOfficialTimeCall;
import com.ebay.sdk.helper.*;
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) {
        try {

            // Instantiate  ApiContext and initialize with token and Trading API URL
            ApiContext apiContext = getApiContext();

            //Create call object and execute the call
            GeteBayOfficialTimeCall apiCall = new GeteBayOfficialTimeCall(apiContext);
            Calendar cal = apiCall.geteBayOfficialTime();

            //Handle the result returned
            System.out.println("Official eBay Time : " + cal.getTime().toString());
        }  //try
        catch(Exception e) {
            System.out.println("Fail to get eBay official time.");
            e.printStackTrace();
        }

    } // main

    // Initializes ApiContext with token and eBay API server URL
    private static ApiContext getApiContext() throws IOException {

        String input;
        ApiContext apiContext = new ApiContext();

        //set Api Token to access eBay Api Server
        ApiCredential cred = apiContext.getApiCredential();
        input = ConsoleUtil.readString("Enter your eBay Authentication Token: ");
        cred.seteBayToken(input);

        //set Api Server Url
        input = ConsoleUtil.readString("Enter eBay SOAP server URL (e.g., https://api.ebay.com/wsapi): ");
        apiContext.setApiServerUrl(input);

        return apiContext;
    } //getApiContext

} //ApplicationHelloWorld
