package Tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static Constants.EndPoints.BASE_URL;
import static Constants.EndPoints.LIST_ALL_TRANSACTIONS;
import static org.assertj.core.api.Assertions.*;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.empty;

public class TransactionTests extends BaseTestSteps {

    @Test
    void testTransactionListIsEmpty() {

//        Response response = get("https://api.sumup.com/v0.1/me/transactions/history");
//
//        int statusCode = response.statusCode();
//
//        assertThat(statusCode).isEqualTo(200);
//        List<Transaction> transactionList = response.jsonPath().getList("data", Transaction.class);
//        assertThat(transactionList).isEmpty();

        given()
                .header("Authorization", "Bearer " + accessToken)
                .get(BASE_URL + LIST_ALL_TRANSACTIONS)
                .then()
                .statusCode(200)
                .body("items", empty());
    }


}
