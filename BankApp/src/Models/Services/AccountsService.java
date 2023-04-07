package Models.Services;

import Models.Account.Account;

import java.util.List;

public final class AccountsService extends BaseService<Account> {
    private static AccountsService instance = null;

    private AccountsService() {}

    public static AccountsService getInstance() {
        if (instance == null) {
            instance = new AccountsService();
        }
        return instance;
    }
}