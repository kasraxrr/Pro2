package model;

public class Temperature {
    public double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) / 1.8;
    }


    public double celsiusToFahrenheit(double celsius) {
        return celsius*1.8+32;
    }
}
