package org.pjay;

/**
 * @author vijayk
 */
public class MaxAndMinCityTemperatures {

    public static void main(String[] args) {
        // Let's take example of 5 days for now, with 10 cities
        int lowTempCityIndex = -1, highTempCityIndex = -1, lowTempDayIndex = -1, highTempDayIndex = -1;
        double lowTemperature = Double.MAX_VALUE, hightTemperature = Double.MIN_VALUE;
        String[] cities = {"city1", "city2", "city3", "city4", "city5", "city6", "city7", "city8", "city9", "city10"};
        //System.out.println(cities.length);
        //System.out.println(cities[cities.length - 1]);
        double[][] temperatureArray = new double[][]{
                {22.4, 44.5, 55.6, 33.4, 22.6, 62.4, 34.55, 23.55, 66.89, 14.67},
                {44.5, 43.5, 51.6, 22.4, 25.6, 34.4, 36.5, 25.55, 61.9, 11.67},
                {44.4, 33.5, 57.6, 31.4, 45.6, 61.4, 23.55, 26.55, 61.89, 23.67},
                {34.7, 43, 66, 31.1, 23.6, 45.4, 31.55, 21.5, 67, 11.78},
                {21.4, 41.5, 65.6, 31.4, 32.6, 56.4, 65.55, 32.55, 56.89, 12.67}
        };

        //System.out.println(temperatureArray.length);
        //System.out.println(temperatureArray[0].length);

        for (int i = 0; i < temperatureArray.length; i++) {
            // Logic here
            for (int j = 0; j < temperatureArray[i].length; j++) {
                //lowTemperature = Math.min(lowTemperature, temperatureArray[i][j]);
                if (temperatureArray[i][j] < lowTemperature) {
                    lowTemperature = temperatureArray[i][j];
                    lowTempDayIndex = i;
                    lowTempCityIndex = j;
                }
                //hightTemperature = Math.max(hightTemperature, temperatureArray[i][j]);
                if (temperatureArray[i][j] > hightTemperature) {
                    hightTemperature = temperatureArray[i][j];
                    highTempDayIndex = i;
                    highTempCityIndex = j;
                }
            }
        }

        System.out.println("Lowest temperature is on day :: " + (lowTempDayIndex + 1) + " for city :: " + cities[lowTempCityIndex] + " and temperature is :: " + lowTemperature);
        System.out.println("Lowest temperature is on day :: " + (highTempDayIndex + 1) + " for city :: " + cities[highTempCityIndex] + " and temperature is :: " + hightTemperature);

    }

}
