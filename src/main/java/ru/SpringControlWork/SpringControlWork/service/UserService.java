package ru.SpringControlWork.SpringControlWork.service;

import org.springframework.stereotype.Service;
import ru.SpringControlWork.SpringControlWork.aspects.TrackUserAction;
import ru.SpringControlWork.SpringControlWork.model.User;
import ru.SpringControlWork.SpringControlWork.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @TrackUserAction
    public List<User> findAll(){
        return userRepository.findAll();
    }
    @TrackUserAction
    public User saveUser(User user){
        return userRepository.save(user);
    }

    public void deleteById(int id){
        userRepository.deleteById(id);
    }
    @TrackUserAction
    public User getOne(int id){
        System.out.println("User service get id: "+id);
        return userRepository.getOne(id);
    }

    public User updateUser(User user){
        return userRepository.update(user);
    }
}