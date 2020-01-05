package es.upm.pproject.prePaidCard.controllers;

import es.upm.pproject.prePaidCard.model.*;

import java.util.Map;

public class Controller {

    private PrePaidCardInterface model;

    public Controller(PrePaidCardInterface model) {
        this.model = model;
    }

    public Controller() {
        model = new PrePaidCardManager(true);
    }


    public long buyCard(String owner, long balance, String pin) throws WrongPINException {
        return model.buyCard(owner, balance, pin);
    }

    public void chargeCard(long number, String pin, long amount) throws ExpiredCardException, CardDoesntExistException, WrongPINException {
        model.chargeCard(number, pin, amount);
    }

    public void payCard(long number, String pin, long amount) throws CardDoesntExistException, ExpiredCardException, WrongPINException, NotEnoughMoneyException {
        model.payCard(number, pin, amount);
    }

    public void changePin(long card, String oldPin, String newPin) throws CardDoesntExistException, WrongPINException {
        model.changePin(card, oldPin, newPin);
    }

    public long consultBalance(long number, String pin) throws CardDoesntExistException, WrongPINException {
        return model.consultBalance(number, pin);
    }

    public String consultMovements(long number, String pin) throws CardDoesntExistException, WrongPINException {
        return model.consultMovements(number, pin);
    }

    public Map<Long, Card> getCards() {
        return model.getCards();
    }




}