package findby.precondition;

import findby.findby.CreateAccount;
import findby.findby.NavBar;

public class Precondition {
    NavBar navBar;
    CreateAccount createAccount;

    public void precondition(String firstname, String lastname, String email, String password) {
        navBar = new NavBar();
        createAccount = new CreateAccount();

        navBar.openSignUp();
        createAccount.createNewAccount(firstname, lastname, email, password);
        createAccount.submitNewAccount();
    }
}
