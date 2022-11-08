package ir.maktab.util;

import ir.maktab.exception.CartNumberNotTrueException;

public class CheckCartNumber {
    public void checkCartNumber(String cartNumber) throws CartNumberNotTrueException {
        if (cartNumber.length() != 16){
            throw new CartNumberNotTrueException("cartNumber should have 16 digit");
        }
        if (!(cartNumber.matches("[0,9]{16}"))){
            throw new CartNumberNotTrueException("please enter just digit");
        }
    }
}
