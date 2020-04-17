package ru.jeanponomarev.temperature.model.temperature_scales;

public enum TemperatureScaleName {
    CELSIUS("Celsius"),
    FAHRENHEIT("Fahrenheit"),
    KELVIN("Kelvin"),
    REAUMUR("Reaumur");

    private String userInterfaceScaleName;

    TemperatureScaleName(String userInterfaceScaleName) {
        this.userInterfaceScaleName = userInterfaceScaleName;
    }

    public String getUserInterfaceScaleName() {
        return userInterfaceScaleName;
    }
}
