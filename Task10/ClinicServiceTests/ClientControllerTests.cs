using ClinicService.Controllers;
using ClinicService.Models;
using ClinicService.Models.Requests;
using ClinicService.Services;
using Microsoft.AspNetCore.Mvc;
using Moq;

namespace ClinicServiceTests
{
    public class ClientControllerTests
    {

        private ClientController _clientController;
        private Mock<IClientRepository> _mockClientRepository;


        public ClientControllerTests()
        {
            _mockClientRepository = new Mock<IClientRepository>();
            _clientController = new ClientController(_mockClientRepository.Object);
        }


        [Fact]
        public void GetAllClientsTest()
        {
            // [1] Подготовка данных для тестирования

            List<Client> clientsList = new List<Client>();
            clientsList.Add(new Client());
            clientsList.Add(new Client());
            clientsList.Add(new Client());

            _mockClientRepository.Setup(repository =>
             repository.GetAll()).Returns(clientsList);

            // [2] Исполнение тестируемого метода

            var operationResult = _clientController.GetAll();

            // [3] Подготовка эталонного результата, проверка результата
            Assert.IsType<OkObjectResult>(operationResult.Result);
            var okObjectResult = (OkObjectResult)operationResult.Result;
            Assert.IsAssignableFrom<List<Client>>(okObjectResult.Value);

            _mockClientRepository.Verify(repository =>
              repository.GetAll(), Times.AtLeastOnce);

        }

        public static object[][] CorrectCreateClientData =
        {
            new object[] { new DateTime(1986, 1, 22), "AA1 B11222", "Иванов1", "Станислав1", "Андреевич1" },
            new object[] { new DateTime(1986, 1, 22), "AA1 B11222", "Иванов2", "Станислав2", "Андреевич2" },
            //new object[] { new DateTime(2013, 1, 22), "AA1 B11222", "Иванов3", "Станислав3", "Андреевич3" },
            new object[] { new DateTime(1986, 1, 22), "AA1 B11222", "Иванов4", "Станислав4", "Андреевич4" },
            new object[] { new DateTime(1986, 1, 22), "AA1 B11222", "Иванов5", "Станислав5", "Андреевич5" },
            //new object[] { new DateTime(1986, 1, 22), "AA1 B11222", "Иванов", "", "Андреевич" },
            new object[] { new DateTime(1986, 1, 22), "AA1 B11222", "Иванов6", "Станислав6", "Андреевич6" },
            new object[] { new DateTime(1986, 1, 22), "AA1 B11222", "Иванов7", "Станислав7", "Андреевич7" },
            new object[] { new DateTime(1986, 1, 22), "AA1 B11222", "Иванов8", "Станислав8", "Андреевич8" },

        };


        [Theory]
        [MemberData(nameof(CorrectCreateClientData))]
        public void CreateClientTest(
            DateTime birthday, string document, string surName, string firstName, string patronymic)
        {
            // [1] Подготовка данных для тестирования


            CreateClientRequest createClientRequest = new CreateClientRequest();
            createClientRequest.Birthday = birthday;
            createClientRequest.Document = document;
            createClientRequest.SurName = surName;
            createClientRequest.FirstName = firstName;
            createClientRequest.Patronymic = patronymic;

            _mockClientRepository.Setup(repository =>
            repository.Create(It.IsNotNull<Client>())).Returns(1).Verifiable();

            // [2] Исполнение тестируемого метода

            var operationResult = _clientController.Create(createClientRequest);

            // [3] Подготовка эталонного результата, проверка результата
            Assert.IsType<OkObjectResult>(operationResult.Result);
            var okObjectResult = (OkObjectResult)operationResult.Result;
            Assert.IsAssignableFrom<int>(okObjectResult.Value);
            _mockClientRepository.Verify(repository =>
            repository.Create(It.IsNotNull<Client>()), Times.AtLeastOnce());
        }

        public static object[][] IncorrectCreateClientData =
        {
            new object[] { new DateTime(2013, 1, 22), "AA1 B11222", "Иванов3", "Станислав3", "Андреевич3" },
            new object[] { new DateTime(1986, 1, 22), "AA1 B11222", "Иванов", "", "Андреевич" },

        };

        [Theory]
        [MemberData(nameof(IncorrectCreateClientData))]
        public void CreateClientErrorTest(
            DateTime birthday, string document, string surName, string firstName, string patronymic)
        {
            // [1] Подготовка данных для тестирования

            CreateClientRequest createClientRequest = new CreateClientRequest();
            createClientRequest.Birthday = birthday;
            createClientRequest.Document = document;
            createClientRequest.SurName = surName;
            createClientRequest.FirstName = firstName;
            createClientRequest.Patronymic = patronymic;

            _mockClientRepository.Setup(repository =>
            repository.Create(It.IsNotNull<Client>())).Returns(1).Verifiable();

            // [2] Исполнение тестируемого метода

            var operationResult = _clientController.Create(createClientRequest);

            // [3] Подготовка эталонного результата, проверка результата
            Assert.IsType<OkObjectResult>(operationResult.Result);
            var okObjectResult = (OkObjectResult)operationResult.Result;

            _mockClientRepository.Verify(repository =>
            repository.Create(It.IsNotNull<Client>()), Times.Never());
        }

        [Fact]
        public void UpdateClientTest()
        {
            // [1] Подготовка данных для тестирования
            var updateClientRequest = new UpdateClientRequest
            {
                Birthday = new DateTime(1986, 1, 22),
                Document = "AA1 B11222",
                SurName = "Иванов",
                FirstName = "Станислав",
                Patronymic = "Андреевич"
            };

            _mockClientRepository.Setup(repository =>
            repository.Update(It.IsNotNull<Client>())).Returns(1).Verifiable();

            // [2] Исполнение тестируемого метода
            var operationResult = _clientController.Update(updateClientRequest);

            // [3] Подготовка эталонного результата, проверка результата
            Assert.IsType<OkObjectResult>(operationResult.Result);
            var okObjectResult = (OkObjectResult)operationResult.Result;
            Assert.IsAssignableFrom<int>(okObjectResult.Value);
            _mockClientRepository.Verify(repository =>
            repository.Update(It.IsNotNull<Client>()), Times.AtLeastOnce());
        }

        [Fact]
        public void DeleteClientTest()
        {
            // [1] Подготовка данных для тестирования
            const int clientId = 1;

            _mockClientRepository.Setup(repository =>
            repository.Delete(It.IsNotNull<int>())).Returns(1).Verifiable();

            // [2] Исполнение тестируемого метода
            var operationResult = _clientController.Delete(clientId);

            // [3] Подготовка эталонного результата, проверка результата
            Assert.IsType<OkObjectResult>(operationResult.Result);
            var okObjectResult = (OkObjectResult)operationResult.Result;
            Assert.IsAssignableFrom<int>(okObjectResult.Value);
            _mockClientRepository.Verify(repository =>
            repository.Delete(It.IsNotNull<int>()), Times.AtLeastOnce());
        }

        [Fact]
        public void GetClientByIdTest()
        {
            // [1] Подготовка данных для тестирования
            const int clientId = 1;

            _mockClientRepository.Setup(repository =>
            repository.GetById(It.IsNotNull<int>())).Returns(new Client()).Verifiable();

            // [2] Исполнение тестируемого метода
            var operationResult = _clientController.GetById(clientId);

            // [3] Подготовка эталонного результата, проверка результата
            Assert.IsType<OkObjectResult>(operationResult.Result);
            var okObjectResult = (OkObjectResult)operationResult.Result;
            Assert.IsAssignableFrom<Client>(okObjectResult.Value);
            _mockClientRepository.Verify(repository =>
            repository.GetById(It.IsNotNull<int>()), Times.AtLeastOnce());
        }
    }
}
