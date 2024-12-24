using Microsoft.AspNetCore.Mvc;
using MyFirstWebApplication.Models;
using static System.Runtime.InteropServices.JavaScript.JSType;

namespace MyFirstWebApplication.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class WeatherForecastController : ControllerBase
    {

        private WeatherForecastHolder _weatherForecastHolder;

        public WeatherForecastController(
            WeatherForecastHolder weatherForecastHolder)
        {
            _weatherForecastHolder = weatherForecastHolder;
        }


        [HttpPost("add-data")]
        public ActionResult<bool> Add([FromQuery] DateTime date, [FromQuery] int temperatureC)
        {
            bool result = _weatherForecastHolder.Add(date, temperatureC);
            return Ok(result);
        }

        [HttpPut("update-data")]
        public ActionResult<bool> Update([FromQuery] DateTime date, [FromQuery] int temperatureC)
        {
            bool result = _weatherForecastHolder.Update(date, temperatureC);
            return Ok(result);

        }

        [HttpDelete("delete-data")]
        public ActionResult<bool> Delete([FromQuery] DateTime date)
        {
            bool result = _weatherForecastHolder.Delete(date);
            return Ok(result);
        }

        [HttpGet("get-data")]
        public ActionResult<List<WeatherForecast>> Get([FromQuery] DateTime from, [FromQuery] DateTime to)
        {
            List<WeatherForecast> result = _weatherForecastHolder.Get(from, to);
            return Ok(result);
        }

    }
}
