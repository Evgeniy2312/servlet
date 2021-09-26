package by.Matveev.service;

import by.Matveev.dao.ListOperations;
import by.Matveev.dao.ListUser;
import by.Matveev.dao.RememberingInformationDao;
import by.Matveev.dao.UserDao;
import by.Matveev.entity.Operation;
import by.Matveev.entity.User;
import by.Matveev.service.aggregators.OperationAggregator;
import by.Matveev.service.aggregators.UserAggregator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.AggregateWith;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ServiceFacadeTest {
    private final ServiceFacade serviceFacade = new ServiceFacade();
    private final UserDao userDao = new ListUser();
    private final RememberingInformationDao rememberingInformationDao = new ListOperations();


    @BeforeAll
    void init() {
        User user = new User("ewer3@gmail.com", "123");
        User user2 = new User("Evgen12-23_2003@ges", "1234");
        List<User> users = userDao.getUsers();
        users.add(user);
        users.add(user2);
        List<Operation> operations = rememberingInformationDao.getOperations();
        operations.add(new Operation(4, 6, "add", user));
        operations.add(new Operation(10, 3, "mul", user2));
        operations.add(new Operation(9, 4, "sub", user2));
        operations.add(new Operation(15, 2, "div", user));
        operations.add(new Operation(3, 56, "add", user2));
        operations.add(new Operation(4, 6, "add", user));
    }

    @Order(1)
    @DisplayName("testing authorization method to the true")
    @ParameterizedTest
    @CsvSource({"ewer3@gmail.com, 123",
            "Evgen12-23_2003@ges, 1234 "}
    )
    void authorizationTrueTest(@AggregateWith(UserAggregator.class) User user) {
        assertEquals(Optional.of(user), serviceFacade.authorization(user));
    }

    @Order(2)
    @DisplayName("testing authorization method to the false")
    @ParameterizedTest
    @CsvSource({"ewer34@gmail.com, 1234",
            "Evgen1234-23_204@ges, 12wq4 "}
    )
    void authorizationFalseTest(@AggregateWith(UserAggregator.class) User user) {
        assertEquals(Optional.empty(), serviceFacade.authorization(user));
    }

//    @Order(3)
//    @DisplayName("testing registration method to the true")
//    @ParameterizedTest
//    @CsvSource({"ewer34@gmail.com, 1234",
//            "Evgen1234-23_204@ges, 12wq4 "}
//    )
//    void registrationTrueTest(@AggregateWith(UserAggregator.class) User user) {
//        assertAll("user",
//                () -> assertNotNull(user),
//                () -> assertTrue( serviceFacade.registration(user))
//        );
//    }

//    @Order(4)
//    @DisplayName("testing registration method to the false")
//    @ParameterizedTest
//    @CsvSource({"ewer3@gmail.com, 123",
//            "Evgen12-23_2003@ges, 1234 "}
//    )
////    void registrationFalseTest(@AggregateWith(UserAggregator.class) User user) {
////        assertAll("user",
////                () -> assertNotNull(user),
////                () -> assertFalse( serviceFacade.registration(user))
////                );
////    }

    @Order(6)
    @DisplayName("test changePassword method to the true")
    @ParameterizedTest
    @CsvSource({"123, 1234",
            "1234, 123q"
    })
    void changePasswordTrue(String oldPassword, String password) {
        User user = userDao.getUsers().get(0);
        assertAll("user",
                () -> assertEquals(user.getPassword(), oldPassword),
                () -> assertNotEquals(user.getPassword(), password),
                () -> serviceFacade.changePassword(user, password),
                () -> assertEquals(password, user.getPassword())
                );
    }

    @Order(5)
    @DisplayName("test changePassword method to the false")
    @ParameterizedTest
    @CsvSource({"123, 1234",
            "123, 123"}
    )
    void changePasswordFalse(String oldPassword, String password) {
        User user = userDao.getUsers().get(0);
        if(!user.getPassword().equals(oldPassword) || user.getPassword().equals(password)){
            assertFalse(false);
        }
    }


    private double getResult(double num){
        BigDecimal resultBD = new BigDecimal(num).setScale(2, RoundingMode.DOWN);
        return resultBD.doubleValue();
    }



    @DisplayName("test division")
    @ParameterizedTest
    @CsvSource({"4, 1, div",
            "4, 2, div",
            "10, 2, div"
    })
    void calculateDivision(@AggregateWith(OperationAggregator.class) Operation operation){
        assertEquals(getResult(operation.getI1()/ operation.getI2()), serviceFacade.calculate(operation));
    }


    @DisplayName("test addition")
    @ParameterizedTest
    @CsvSource({"4, 2, add",
            "8, 2, add",
            "10, 2, add"
    })
    void calculateAddition(@AggregateWith(OperationAggregator.class) Operation operation){
        assertEquals(getResult(operation.getI1() + operation.getI2()), serviceFacade.calculate(operation));
    }


    @DisplayName("test multiplication")
    @ParameterizedTest
    @CsvSource({"4, 4, mul",
            "10, 3, mul",
            "100, 2, mul"
    })
    void calculateMultiplication(@AggregateWith(OperationAggregator.class) Operation operation){
        assertEquals(getResult(operation.getI1() * operation.getI2()), serviceFacade.calculate(operation));
    }

    @DisplayName("test subtraction")
    @ParameterizedTest
    @CsvSource({"7, 1, sub",
            "24, 2, sub",
            "45, 2, sub"
    })
    void calculateSubtraction(@AggregateWith(OperationAggregator.class) Operation operation){
        assertEquals(getResult(operation.getI1() - operation.getI2()), serviceFacade.calculate(operation));
    }


    @DisplayName("testing getOperationsBySession method from the facade")
    @Test
    void getOperationBySession() {
        User user = userDao.getUsers().get(0);
        List<Operation> listExpected = rememberingInformationDao.
                getOperations().
                stream().
                filter(x -> x.getUser().equals(user)).collect(Collectors.toList());
        List<Operation> listActual = rememberingInformationDao.getOperationBySession(user);
        listExpected.removeAll(listActual);
        assertTrue(listExpected.isEmpty());
    }

    @DisplayName("testing getOperationsByType method from the facade")
    @ParameterizedTest
    @ValueSource(strings = {
            "div",
            "sub",
            "add",
            "mul"
    })
    void getOperationByType(String type) {
        User user = userDao.getUsers().get(1);
        List<Operation> listExpected = rememberingInformationDao.
                getOperations().
                stream().
                filter(x -> x.getUser().equals(user) && x.getOperation().equals(type)).collect(Collectors.toList());
        List<Operation> listActual = rememberingInformationDao.getOperationByNameOfFunctions(user, type);
        listExpected.removeAll(listActual);
        assertTrue(listExpected.isEmpty());
    }
//    @AfterAll
//    void cleaning(){
//        List<Operation> operations = rememberingInformationDao.getOperations();
//        List<User> users= userDao.getUser();
//        operations.clear();
//        users.clear();
//    }
}