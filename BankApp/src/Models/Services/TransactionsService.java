package Models.Services;

public class TransactionsService {
    private static TransactionsService instance = null;

    private TransactionsService() {}

    public static TransactionsService getInstance() {
        if (instance == null) {
            instance = new TransactionsService();
        }
        return instance;
    }
}
