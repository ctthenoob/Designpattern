package observer.impl;

import observer.DisplayElement;
import observer.Observer;
import observer.Subject;

public class CurrentConditionDisplay implements Observer, DisplayElement {

	private float temperature;
	private float humidity;
	private float pressure;

	private Subject weatherData;

	public CurrentConditionDisplay(Subject weatherData) {
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
	}

	@Override
	public void display() {
		System.out
				.println("current conditions of temp and humidty and pressure is:"
						+ temperature
						+ "-----"
						+ humidity
						+ "------"
						+ pressure);
	}

	@Override
	public void update(float temp, float humidity, float pressure) {
		this.temperature = temp;
		this.humidity = humidity;
		this.pressure = pressure;
		display();
	}

}
