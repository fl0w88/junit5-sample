package com.example.project.data;

import com.example.project.keywords.domain.Base64Text;

public class Base64DataProvider {

    public Base64Text getTestData() {
        Base64Text result = new Base64Text();
        result.setText("aus der Datenbank");
        return result;
    }

}
