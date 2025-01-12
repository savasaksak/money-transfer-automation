package stepDefinitions;

import pages.*;

public class TestBase {
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    MoneyTransferPage moneyTransferPage = new MoneyTransferPage();
    TransferMoneyModal transferMoneyModal = new TransferMoneyModal();
    AddMoneyModal addMoneyModal = new AddMoneyModal();

    // Total amount for the account on transfer money page
    static double totalAmount = 0;
}
