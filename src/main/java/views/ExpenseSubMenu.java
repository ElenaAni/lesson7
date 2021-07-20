package views;

import org.openqa.selenium.WebDriver;
import Base.BaseView;
import Base.SubMenu;
import Base.SubMenuButtons;
import enums.ExpenseSubMenuButtons;
import Pages.AllExpensesPage;

public class ExpenseSubMenu extends SubMenu {

    public ExpenseSubMenu(WebDriver driver) {
        super(driver);
    }

    @Override
    public BaseView clickSubMenuButton(SubMenuButtons buttons) {
        if (buttons instanceof ExpenseSubMenuButtons) {
            switch ((ExpenseSubMenuButtons) buttons) {
                case EXPENSE_REQUEST:
                    driver.findElement(((ExpenseSubMenuButtons) buttons).getBy()).click();
                    return new AllExpensesPage(driver);
                default:
                    throw new IllegalArgumentException("Not implemented yet");
            }
        } else {
            throw new IllegalArgumentException("Incorrect button type");
        }
    }
}

