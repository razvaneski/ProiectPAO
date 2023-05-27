package com.bank.services;

import com.bank.cards.Card;
public class CardsService extends BaseService<Card>{
    private static CardsService instance = null;

    private CardsService() {}

    public static CardsService getInstance() {
        if (instance == null) {
            instance = new CardsService();
        }
        return instance;
    }
}
