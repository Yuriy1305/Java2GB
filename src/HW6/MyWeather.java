package HW6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class TeacherWork {
        public static void main(String[] args) {
        try {
// запрос по Питеру 5 дней с полученым ключом и в градусах Цельсия:
            URL weatherUrl = new URL(
               "http://dataservice.accuweather.com/forecasts/v1/daily/5day/295212?apikey=Q9xCitbhbtPpwbQrHTPnvmm1VNa7XrWY&metric=true");
// связываемся с сервером:
            HttpURLConnection urlConnection = (HttpURLConnection) weatherUrl.openConnection();
// при правильном ответе на наш запрос (проверил на странице браузера, см. ниже):
            if (urlConnection.getResponseCode() == 200) {
// пытаемся читать поток и записываем содержание:
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()))) {
                    StringBuilder responseContent = new StringBuilder();
                    String line = "";
// читаем до конца, т.к. не файл, то ждем null:
                    while ((line = reader.readLine()) != null) {
                        responseContent.append(line);
                    }
// закрываем чтиние:
                    reader.close();
    // стараница с сайта:
// {
//  "Headline": {
//    "EffectiveDate": "2022-03-25T13:00:00+03:00",
//    "EffectiveEpochDate": 1648202400,
//    "Severity": 2,
//    "Text": "Snowfall from Friday afternoon into late Friday night will total 10-15 cm",
//    "Category": "snow",
//    "EndDate": "2022-03-26T07:00:00+03:00",
//    "EndEpochDate": 1648267200,
//    "MobileLink": "http://www.accuweather.com/en/ru/saint-petersburg/295212/daily-weather-forecast/295212?unit=c&lang=en-us",
//    "Link": "http://www.accuweather.com/en/ru/saint-petersburg/295212/daily-weather-forecast/295212?unit=c&lang=en-us"
//  },
//  "DailyForecasts": [
//    {
//      "Date": "2022-03-22T07:00:00+03:00",
//      "EpochDate": 1647921600,
//      "Temperature": {
//        "Minimum": {
//          "Value": -3.9,
//          "Unit": "C",
//          "UnitType": 17
//        },
//        "Maximum": {
//          "Value": 4.6,
//          "Unit": "C",
//          "UnitType": 17
//        }
//      },
//      "Day": {
//        "Icon": 1,
//        "IconPhrase": "Sunny",
//        "HasPrecipitation": false
//      },
//      "Night": {
//        "Icon": 33,
//        "IconPhrase": "Clear",
//        "HasPrecipitation": false
//      },
//      "Sources": [
//        "AccuWeather"
//      ],
//      "MobileLink": "http://www.accuweather.com/en/ru/saint-petersburg/295212/daily-weather-forecast/295212?day=1&unit=c&lang=en-us",
//      "Link": "http://www.accuweather.com/en/ru/saint-petersburg/295212/daily-weather-forecast/295212?day=1&unit=c&lang=en-us"
//    },
//    {
//      "Date": "2022-03-23T07:00:00+03:00",
//      "EpochDate": 1648008000,
//      "Temperature": {
//        "Minimum": {
//          "Value": -2.2,
//          "Unit": "C",
//          "UnitType": 17
//        },
//        "Maximum": {
//          "Value": 3.7,
//          "Unit": "C",
//          "UnitType": 17
//        }
//      },
//      "Day": {
//        "Icon": 3,
//        "IconPhrase": "Partly sunny",
//        "HasPrecipitation": false
//      },
//      "Night": {
//        "Icon": 35,
//        "IconPhrase": "Partly cloudy",
//        "HasPrecipitation": false
//      },
//      "Sources": [
//        "AccuWeather"
//      ],
//      "MobileLink": "http://www.accuweather.com/en/ru/saint-petersburg/295212/daily-weather-forecast/295212?day=2&unit=c&lang=en-us",
//      "Link": "http://www.accuweather.com/en/ru/saint-petersburg/295212/daily-weather-forecast/295212?day=2&unit=c&lang=en-us"
//    },
//    {
//      "Date": "2022-03-24T07:00:00+03:00",
//      "EpochDate": 1648094400,
//      "Temperature": {
//        "Minimum": {
//          "Value": -3.6,
//          "Unit": "C",
//          "UnitType": 17
//        },
//        "Maximum": {
//          "Value": 5.4,
//          "Unit": "C",
//          "UnitType": 17
//        }
//      },
//      "Day": {
//        "Icon": 6,
//        "IconPhrase": "Mostly cloudy",
//        "HasPrecipitation": false
//      },
//      "Night": {
//        "Icon": 7,
//        "IconPhrase": "Cloudy",
//        "HasPrecipitation": false
//      },
//      "Sources": [
//        "AccuWeather"
//      ],
//      "MobileLink": "http://www.accuweather.com/en/ru/saint-petersburg/295212/daily-weather-forecast/295212?day=3&unit=c&lang=en-us",
//      "Link": "http://www.accuweather.com/en/ru/saint-petersburg/295212/daily-weather-forecast/295212?day=3&unit=c&lang=en-us"
//    },
//    {
//      "Date": "2022-03-25T07:00:00+03:00",
//      "EpochDate": 1648180800,
//      "Temperature": {
//        "Minimum": {
//          "Value": 1,
//          "Unit": "C",
//          "UnitType": 17
//        },
//        "Maximum": {
//          "Value": 3.1,
//          "Unit": "C",
//          "UnitType": 17
//        }
//      },
//      "Day": {
//        "Icon": 19,
//        "IconPhrase": "Flurries",
//        "HasPrecipitation": true,
//        "PrecipitationType": "Snow",
//        "PrecipitationIntensity": "Light"
//      },
//      "Night": {
//        "Icon": 22,
//        "IconPhrase": "Snow",
//        "HasPrecipitation": true,
//        "PrecipitationType": "Snow",
//        "PrecipitationIntensity": "Moderate"
//      },
//      "Sources": [
//        "AccuWeather"
//      ],
//      "MobileLink": "http://www.accuweather.com/en/ru/saint-petersburg/295212/daily-weather-forecast/295212?day=4&unit=c&lang=en-us",
//      "Link": "http://www.accuweather.com/en/ru/saint-petersburg/295212/daily-weather-forecast/295212?day=4&unit=c&lang=en-us"
//    },
//    {
//      "Date": "2022-03-26T07:00:00+03:00",
//      "EpochDate": 1648267200,
//      "Temperature": {
//        "Minimum": {
//          "Value": -5.4,
//          "Unit": "C",
//          "UnitType": 17
//        },
//        "Maximum": {
//          "Value": 3.2,
//          "Unit": "C",
//          "UnitType": 17
//        }
//      },
//      "Day": {
//        "Icon": 12,
//        "IconPhrase": "Showers",
//        "HasPrecipitation": true,
//        "PrecipitationType": "Rain",
//        "PrecipitationIntensity": "Light"
//      },
//      "Night": {
//        "Icon": 36,
//        "IconPhrase": "Intermittent clouds",
//        "HasPrecipitation": false
//      },
//      "Sources": [
//        "AccuWeather"
//      ],
//      "MobileLink": "http://www.accuweather.com/en/ru/saint-petersburg/295212/daily-weather-forecast/295212?day=5&unit=c&lang=en-us",
//      "Link": "http://www.accuweather.com/en/ru/saint-petersburg/295212/daily-weather-forecast/295212?day=5&unit=c&lang=en-us"
//    }
//  ]
//}
// Исходя из вышесказанного, ищем подстроку данных о погоде-температуре 1го дня:
                    System.out.println("Ответ: " + responseContent+ "\n"+"Погода 1го дня: "+
                    responseContent.substring(responseContent.indexOf("DailyForecasts")+26, responseContent.indexOf("DailyForecasts")+188));
// и т.д..... Дальше делать не стал после разбора ДЗ на вебинаре и самого вебинара...
                } catch (IOException e) {
                    System.out.println("Ошибка1: " + e.getMessage());
// не забываем закончить связь с сервером:
                } finally {
                    urlConnection.disconnect();
                }
            }
        } catch (Exception ex) {
            System.out.println("Ошибка2: " + ex.getMessage());
        }
    }
}