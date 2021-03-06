package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class  MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      User user1 = new User("User1", "Lastname1", "user1@mail.ru");
      User user2 = new User("User2", "Lastname2", "user2@mail.ru");
      User user3 = new User("User3", "Lastname3", "user3@mail.ru");
      User user4 = new User("User4", "Lastname4", "user4@mail.ru");
      Car car1 = new Car("Lada",1111);
      Car car2 = new Car("BMW",2222);
      Car car3 = new Car("Mercedes",3333);
      Car car4 = new Car("Porsche",4444);
      user1.setCar(car1);
      user2.setCar(car2);
      user3.setCar(car3);
      user4.setCar(car4);
      userService.add(user1);
      userService.add(user2);
      userService.add(user3);
      userService.add(user4);
      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Model = "+user.getCar().getModel());
         System.out.println("Series = "+user.getCar().getSeries());
         System.out.println("-----------------------------");
      }
      List<Object []> cars = userService.listCar("Porsche",4444);
      for (Object[] car : cars) {
         System.out.println("Нахождение юзера по модели и серии");
         System.out.println(car[0].toString());
         System.out.println("-----------------------------");
      }
      context.close();
   }
}
