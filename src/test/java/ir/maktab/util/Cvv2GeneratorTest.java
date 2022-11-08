package ir.maktab.util;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Cvv2GeneratorTest {
    static Cvv2Generator cvv2Generator;
    @BeforeAll
    static void setUp(){
        cvv2Generator=new Cvv2Generator();
    }

    @Test
    void generateCvv2() {
        int cvv2=cvv2Generator.generateCvv2();
        assertTrue(cvv2>1000 && cvv2<10000);
    }
}