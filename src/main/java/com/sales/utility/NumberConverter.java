package com.sales.utility;

public class NumberConverter {

    public NumberConverter() {

    }

    public int getInt(String num) {
        try {
           return  Integer.parseInt(num);
        } catch (Exception error) {
            return 0;
        }
    }
    public Double getDouble(String num) {
        try {
            return  Double.parseDouble(num);
        } catch (Exception error) {
            return 0.0;
        }
    }
}