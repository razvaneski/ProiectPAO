import Models.Services.AccountsService;
import Models.Services.CardsService;
import Models.Services.CustomersService;
import Models.Services.TransactionsService;
public final class MainService {
    private static MainService instance = null;

    private MainService() {}

    public static MainService getInstance() {
        if (instance == null) {
            instance = new MainService();
        }
        return instance;
    }
}
