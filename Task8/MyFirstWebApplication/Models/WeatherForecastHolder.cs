using System.Net.Http.Headers;

namespace MyFirstWebApplication.Models
{
    /// <summary>
    /// Объект на базе класса WeatherForecastHolder будет хранить список показателей по температуре
    /// </summary>
    public class WeatherForecastHolder
    {
        //private static WeatherForecastHolder _instance;

        //public static WeatherForecastHolder Instance()
        //{
        //    if (_instance == null)
        //        _instance = new WeatherForecastHolder();
        //    return _instance;
        //}

        // Коллекция для хранения показателей по температуре
        private List<WeatherForecast> _values;


        public WeatherForecastHolder()
        {
            _values = new List<WeatherForecast>();
        }

        /// <summary>
        /// Добавить новый показатель по температуре
        /// </summary>
        /// <param name="date"></param>
        /// <param name="temperatureC"></param>
        public bool Add(DateTime date, int temperatureC)
        {
            WeatherForecast forecast = new WeatherForecast();
            forecast.TemperatureC = temperatureC;
            forecast.Date = date;
            _values.Add(forecast);
            return true;
        }

        /// <summary>
        /// Обновить показатель по температуре
        /// </summary>
        /// <param name="date"></param>
        /// <param name="temperatureC"></param>
        /// <returns></returns>
        public bool Update(DateTime date, int temperatureC)
        {
            foreach (WeatherForecast forecast in _values)
            {
                if (forecast.Date == date)
                {
                    forecast.TemperatureC = temperatureC;
                    return true;
                }
            }
            return false;
        }


        /// <summary>
        /// Удаляем данные о температуре
        /// </summary>
        /// <param name="date"></param>
        /// <returns></returns>
        public bool Delete(DateTime date)
        {
            // способ первый... почему-то не рабочий - почему не удаляет?
            // foreach (WeatherForecast forecast in _values)
            // {
                // if (forecast.Date == date)
                // {
                //     WeatherForecast tempForecast = new WeatherForecast();
                //         tempForecast.Date = forecast.Date;
                //         tempForecast.TemperatureC = forecast.TemperatureC;
                //     _values.Remove(tempForecast);
               //      return true;
                // }
            //}  

            // способ второй - РАБОЧИЙ!              
            if (_values.Exists(f => f.Date==date)){
                WeatherForecast item = _values.Find(f => f.Date==date);
                _values.Remove(item);
                return true;
            }
            return false;

        }

        /// <summary>
        /// Получить показатели по температуре за период
        /// </summary>
        /// <param name="from"></param>
        /// <param name="to"></param>
        /// <returns></returns>
        public List<WeatherForecast> Get(DateTime from, DateTime to)
        {
            List<WeatherForecast> resultList = new List<WeatherForecast>();
            foreach (WeatherForecast forecast in _values)
            {
                if (forecast.Date >= from && forecast.Date <= to)
                {
                    resultList.Add(forecast);
                }
            }
            return resultList;
        }

    }
}
