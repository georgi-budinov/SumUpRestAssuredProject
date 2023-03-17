package Tests;
import Models.BankAccountModel;
import Reporting.Setup;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import static Constants.EndPoints.*;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.*;

@Listeners(Setup.class)

public class BankAccountsTests extends BaseTestSteps {

    @Test
    void testGetBankAccountsForUserAccount() {

        try {
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

                extentReportManager.logPassDetails("All assertions passed.");
            } catch (AssertionError e) {
                extentReportManager.logFailureDetails("Assertion failed: " + e.getMessage());
                throw e;
            }
    }
}
