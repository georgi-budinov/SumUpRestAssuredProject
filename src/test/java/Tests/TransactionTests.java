package Tests;

import Reporting.Setup;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import static Constants.EndPoints.BASE_URL;
import static Constants.EndPoints.LIST_ALL_TRANSACTIONS;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.empty;

@Listeners(Setup.class)
public class TransactionTests extends BaseTestSteps {
    @Test
    void testTransactionListIsEmpty() {

        try {
        given()
                .header("Authorization", "Bearer " + accessToken)
                .get(BASE_URL + LIST_ALL_TRANSACTIONS)
                .then()
                .statusCode(200)
                .body("items", empty());
            extentReportManager.logPassDetails("All assertions passed.");
        } catch (AssertionError e) {
            extentReportManager.logFailureDetails("Test failed: " + e.getMessage());
            throw e;
        }
    }
}
