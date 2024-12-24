using ClinicService.Models;
using ClinicService.Models.Requests;
using ClinicService.Services;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
 
namespace ClinicService.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class ConsultationController : ControllerBase
    {
        
        private IConsultationRepository _consultationRepository;
 
        public ConsultationController(IConsultationRepository consultationRepository)
        {
            _consultationRepository = consultationRepository;
        }


        [HttpPost("create")]
        public IActionResult Create([FromBody] CreateConsultationRequest createRequest)
        {
            Consultation consultation = new Consultation();
            consultation.ClientId = createRequest.ClientId;
            consultation.PetId = createRequest.PetId;
            consultation.ConsultationDate = createRequest.ConsultationDate;
            consultation.Description = createRequest.Description;
            
            return Ok(_consultationRepository.Create(consultation));
        }

        [HttpPut("edit")]
        public IActionResult Update([FromBody] UpdateConsultationRequest updateRequest)
        {
            Consultation consultation = new Consultation();
            consultation.ConsultationId = updateRequest.ConsultationId;
            consultation.ClientId = updateRequest.ClientId;
            consultation.PetId = updateRequest.PetId;
            consultation.ConsultationDate = updateRequest.ConsultationDate;
            consultation.Description = updateRequest.Description;
            return Ok(_consultationRepository.Update(consultation));
        }


        [HttpDelete("delete")]
        public IActionResult Delete([FromQuery] int ConsultationId)
        {
            int res = _consultationRepository.Delete(ConsultationId);
            return Ok(res);
        }

        [HttpGet("get-all")]
        public IActionResult GetAll()
        {
            return Ok(_consultationRepository.GetAll());
        }


        [HttpGet("get/{consultationId}")]
        public IActionResult GetById([FromRoute] int consultationId)
        {
            return Ok(_consultationRepository.GetById(consultationId));
        }



    }
}
