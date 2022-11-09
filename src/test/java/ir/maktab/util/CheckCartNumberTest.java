package ir.maktab.util;

import ir.maktab.exception.CartNumberNotTrueException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckCartNumberTest {
    CheckCartNumber checkCartNumber = new CheckCartNumber();

    @Test
    void checkCartNumberHas16Digit() {
        String cartNumber = "12345678";
        try {
            checkCartNumber.checkCartNumber(cartNumber);
        } catch (CartNumberNotTrueException e) {
            assertEquals("cartNumber should have 16 digit", e.getMessage());
        }
    }

    @Test
    void checkCartNumberHasOnlyDigit() {
        String cartNumber = "1212ert34ert5678";
        try {
            checkCartNumber.checkCartNumber(cartNumber);
        } catch (CartNumberNotTrueException e) {
            assertEquals("please enter just digit", e.getMessage());
        }
    }
}