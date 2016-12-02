
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

/*
 * This class shows how to make a simple authenticated call to the
 * Amazon Product Advertising API.
 *
 * See the README.html that came with this sample for instructions on
 * configuring and running the sample.
 */
public class JavaCodeSnippet {

    /*
     * Your AWS Access Key ID, as taken from the AWS Your Account page.
     */
    private static final String AWS_ACCESS_KEY_ID = "AKIAIHWUGPE7AQ54YM3Q";

    /*
     * Your AWS Secret Key corresponding to the above ID, as taken from the AWS
     * Your Account page.
     */
    private static final String AWS_SECRET_KEY = "20rmZWO+UZesM9srugi4YIxpsxmUk9uuQ5jnNjuP";

    /*
     * Use the end-point according to the region you are interested in.
     */
    private static final String ENDPOINT = "webservices.amazon.com";

    public static void main(String[] args) {

        /*
         * Set up the signed requests helper.
         */
        SignedRequestsHelper helper;

        try {
            helper = SignedRequestsHelper.getInstance(ENDPOINT, AWS_ACCESS_KEY_ID, AWS_SECRET_KEY);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        String requestUrl = null;

        Map<String, String> params = new HashMap<String, String>();

        params.put("Service", "AWSECommerceService");
        params.put("Operation", "ItemSearch");
        params.put("AWSAccessKeyId", "AKIAIHWUGPE7AQ54YM3Q");
        params.put("AssociateTag", "121894-20");
        params.put("SearchIndex", "Beauty");
        params.put("Keywords", "shampoo");
        params.put("ResponseGroup", "BrowseNodes,Images,ItemAttributes,Offers");
        params.put("Sort", "price");
        params.put("BrowseNode", "11057241");
        params.put("MerchantId", "Amazon");

        requestUrl = helper.sign(params);

        System.out.println("Signed URL: \"" + requestUrl + "\"");

        HttpURLConnectionExample http = new HttpURLConnectionExample();
        try {
            http.sendPost(requestUrl);
        }catch (Exception e){
            System.out.println("I'm a towel!");

        }
    }
}
