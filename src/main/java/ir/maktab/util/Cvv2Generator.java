package ir.maktab.util;

import java.util.Random;

public class Cvv2Generator {
    public int generateCvv2(){
        Random random = new Random();
        int cvv2=random.nextInt(1000,10000);
        return cvv2;
    }
}
