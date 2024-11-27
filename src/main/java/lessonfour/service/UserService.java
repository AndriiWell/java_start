package lessonfour.service;

import lessonfour.repository.UserRepository;

public class UserService {
   private UserRepository userRepository;

   public UserService(UserRepository userRepository) {
       this.userRepository = userRepository;
   }

   public void login(String e, String p){

   }
}
