package features.expenses;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.Test;
import base.BaseUITest;
import common.Configuration;
import enums.ExpenseSubMenuButtons;
import enums.NavigationBarTabs;
import Pages.AllExpensesPage;
import Pages.LoginPage;

@Feature("Expenses")
public class NewExpensesTest extends BaseUITest {

    @Test
    public void createNewExpensePositiveTest() {
        AllExpensesPage expensesScreen = (AllExpensesPage) new LoginPage(driver)
                .authoriseScenario(Configuration.STUDENT_LOGIN, Configuration.STUDENT_PASSWORD)
                .getPageNavigation()
                .moveCursorToNavigationTab(NavigationBarTabs.EXPENSES)
                .clickSubMenuButton(ExpenseSubMenuButtons.EXPENSE_REQUEST);

        expensesScreen
                .clickOnCreateNewExpenseButton()
                .enterDescription("test 1234")
                .selectBusinessUnit(1)
                .selectExpenditure(87)
                .setExpenseSum(10000)
                .clickNotifyDateChangedCheckBox()
                .selectDateInDatePicker(20)
                .clickSubmit()
                .checkNewExpensePopUp();
    }
}


