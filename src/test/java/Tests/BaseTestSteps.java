package Tests;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;

import static Constants.EndPoints.*;
import static io.restassured.RestAssured.*;

public class BaseTestSteps {

    protected String accessToken;

    @BeforeMethod
    public void getToken() {

        String jsonRequestBody = "{\"client_id\":\"cc_classic_149Vl9uSRwgbI2IY8jnr9M32rHT10\", " +
                                    "\"client_secret\":\"cc_sk_classic_48VWilfxEuMoevXnpyrPdpnCfRW8GYrNIR8qRRG95NvEudPngT\", " +
                                    "\"username\":\"pl.aleksiev90@gmail.com\", " +
                                    "\"password\":\"Sturmgewehr44\"}";
        // Make API call to get authentication token
        Response response = given()
                .baseUri(GET_TOKEN_BASE_URL)
                .contentType("application/json")
                .body(jsonRequestBody)
                .post(GET_TOKEN);

        // Get the token from the response body
        accessToken = response.jsonPath().getString("access_token");

        // Print the token for debugging purposes
        System.out.println("Auth token: " + accessToken);
    }
}
