package com.workintech.fswebs18challengemaven.util;

import com.workintech.fswebs18challengemaven.entity.Card;
import com.workintech.fswebs18challengemaven.entity.Type;
import com.workintech.fswebs18challengemaven.exceptions.CardException;
import org.springframework.http.HttpStatus;

public class CardValidation {

    public static void validate(Card card) {
        if (card == null) {
            throw new CardException("Card cannot be null", HttpStatus.BAD_REQUEST);
        }
        // JOKER ise color ve value null olmalı
        if (card.getType() == Type.JOKER) {
            card.setColor(null);
            card.setValue(null);
        }
        // Hem type hem value olamaz
        if (card.getType() != null && card.getValue() != null) {
            throw new CardException("Card cannot have both type and value", HttpStatus.BAD_REQUEST);
        }
    }
}