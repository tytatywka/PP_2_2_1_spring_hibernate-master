package hiber.service;

import hiber.dao.UserDao;
import hiber.model.Car;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {


   private UserDao userDao;
   @Autowired
   public void setUserDao(UserDao userDao) {
      this.userDao = userDao;
   }
   @Transactional
   @Override
   public void add(User user) {
      userDao.add(user);
   }
   @Transactional(readOnly = true)
   @Override
   public List<User> listUsers() {
      return userDao.listUsers();
   }

   @Transactional
   @Override
   public void add(Car car) {
      userDao.add(car);
   }
   @Transactional(readOnly = true)
   @Override
   public List<Object []> listCar(String model, int series) {
      return userDao.listCar(model, series);
   }
}
