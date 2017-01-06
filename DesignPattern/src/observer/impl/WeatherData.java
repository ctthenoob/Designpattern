/**
 * 
 */
package observer.impl;

import java.util.ArrayList;

import observer.Observer;
import observer.Subject;

/**
 * @author Administrator
 *
 */
public class WeatherData implements Subject {

	/*
	 * (non-Javadoc)
	 * 
	 * @see observer.Subject#registerObserver(observer.Observer)
	 */
	private ArrayList observers;
	private float temperature;
	private float humidity;
	private float pressure;

	public WeatherData() {

		observers = new ArrayList();
	}

	@Override
	public void registerObserver(Observer o) {

		observers.add(o);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see observer.Subject#removeObserver(observer.Observer)
	 */
	@Override
	public void removeObserver(Observer o) {
		int i = observers.indexOf(o);
		if (i > 0) {
			observers.remove(i);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see observer.Subject#notifyObservers()
	 */
	@Override
	public void notifyObservers() {
		for (int i = 0; i < observers.size(); i++) {
			Observer observer = (Observer) observers.get(i);
			observer.update(temperature, humidity, pressure);
		}

	}

	public void measurementsChanged() {
		notifyObservers();
	}

	public void setMeasurements(float temp, float humid, float pressure) {
		this.temperature = temp;
		this.humidity = humid;
		this.pressure = pressure;
		measurementsChanged();
	}

}
