package Tests;
import Models.BankAccountModel;
import org.testng.annotations.Test;
import static Constants.EndPoints.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.assertj.core.api.Assertions.*;


public class BankAccountsTests extends BaseTestSteps {

    @Test
    void testGetBankAccountsForUserAccount() {


        // Version 1
//        Response response = RestAssured.get(BASE_URL + LIST_ALL_BANK_ACCOUNTS_FOR_MERCHANT);
//
//        int statusCode = response.statusCode();
//
//        assertThat(statusCode).isEqualTo(200);
//        // List<Transaction> transactionList = response.jsonPath().getList("data", Transaction.class);
//        //assertThat(transactionList).isEmpty();

//       Version 2
//        given()
//                .header("Authorization", "Bearer " + accessToken)
//                .get(BASE_URL + LIST_ALL_BANK_ACCOUNTS_FOR_MERCHANT)
//                .then()
//                .statusCode(200)
//                .body("[0].bank_code", equalTo("RZBB9155"))
//                .body("[0].swift", equalTo("RZBBBGSF"))
//                .body("[0].account_number", equalTo("01******89"))
//                .body("[0].iban", equalTo("BG******************89"))
//                .body("[0].account_holder_name", equalTo("Caren Maren"))
//                .body("[0].status", equalTo("FULLY_VERIFIED"))
//                .body("[0].primary", equalTo(true))
//                .body("[0].created_at", equalTo("2023-03-14T16:02:45.387Z"))
//                .body("[0].bank_name", equalTo("Кей Би Си Банк България ЕАД"));

            //Version 3
        BankAccountModel expectedBankAccount = new BankAccountModel();
        expectedBankAccount.setBankCode("RZBB9155");
        expectedBankAccount.setSwift("RZBBBGSF");
        expectedBankAccount.setAccountNumber("01******89");
        expectedBankAccount.setIban("BG******************89");
        expectedBankAccount.setAccountHolderName("Caren Maren");
        expectedBankAccount.setStatus("FULLY_VERIFIED");
        expectedBankAccount.setPrimary(true);
        expectedBankAccount.setCreatedAt("2023-03-14T16:02:45.387Z");
        expectedBankAccount.setBankName("Кей Би Си Банк България ЕАД");

        BankAccountModel[] bankAccounts = given()
                .header("Authorization", "Bearer " + accessToken)
                .get(BASE_URL + LIST_ALL_BANK_ACCOUNTS_FOR_MERCHANT)
                .then()
                .statusCode(200)
                .extract()
                .as(BankAccountModel[].class);

            assertThat(bankAccounts.length).isEqualTo(1);
            assertThat(bankAccounts[0].getBankCode()).isEqualTo(expectedBankAccount.getBankCode());
            assertThat(bankAccounts[0].getSwift()).isEqualTo(expectedBankAccount.getSwift());
            assertThat(bankAccounts[0].getAccountNumber()).isEqualTo(expectedBankAccount.getAccountNumber());
            assertThat(bankAccounts[0].getIban()).isEqualTo(expectedBankAccount.getIban());
            assertThat(bankAccounts[0].getAccountHolderName()).isEqualTo(expectedBankAccount.getAccountHolderName());
            assertThat(bankAccounts[0].getStatus()).isEqualTo(expectedBankAccount.getStatus());
            assertThat(bankAccounts[0].isPrimary()).isEqualTo(expectedBankAccount.isPrimary());
            assertThat(bankAccounts[0].getCreatedAt()).isEqualTo(expectedBankAccount.getCreatedAt());
            assertThat(bankAccounts[0].getBankName()).isEqualTo(expectedBankAccount.getBankName());



    }
}
