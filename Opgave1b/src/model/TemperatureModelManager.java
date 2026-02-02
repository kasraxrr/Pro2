package model;

public class TemperatureModelManager implements TemperatureModel {

    private Temperature temperature;


    public TemperatureModelManager(){
        temperature=new Temperature();
    }

    @Override
    public double toCelsius(double fahrenheit) {
        return temperature.fahrenheitToCelsius(fahrenheit);
    }

    @Override
    public double toFahrenheit(double celsius) {
        return temperature.celsiusToFahrenheit(celsius);
    }
}
