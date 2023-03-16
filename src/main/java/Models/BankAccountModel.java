package Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
        "bank_code",
        "swift",
        "account_number",
        "iban",
        "account_holder_name",
        "status",
        "primary",
        "created_at",
        "bank_name"
})
public class BankAccountModel {

    @JsonProperty("bank_code")
    private String bankCode;

    @JsonProperty("swift")
    private String swift;

    @JsonProperty("account_number")
    private String accountNumber;

    @JsonProperty("iban")
    private String iban;

    @JsonProperty("account_holder_name")
    private String accountHolderName;

    @JsonProperty("status")
    private String status;

    @JsonProperty("primary")
    private boolean primary;

    @JsonProperty("created_at")
    private String createdAt;

    @JsonProperty("bank_name")
    private String bankName;

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getSwift() {
        return swift;
    }

    public void setSwift(String swift) {
        this.swift = swift;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isPrimary() {
        return primary;
    }

    public void setPrimary(boolean primary) {
        this.primary = primary;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
}