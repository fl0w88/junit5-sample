package com.example.project.taf.tests;

import com.example.project.keywords.Base64Keywords;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Base64Test extends TestCaseBase {

    @Test
    public void testBase64Conversion() {
        b64App().base64Keywords().openBase64Site();

        b64App().base64Keywords().closeCookies();

        String testResult = b64App().base64Keywords().encodeTest();

        Assertions.assertEquals("bXVzdGVy", testResult);

        Base64Keywords.waitALittle();
    }

}
