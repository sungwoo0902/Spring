package kr.sungwoo.service;

import kr.sungwoo.document.UserDocument;
import kr.sungwoo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<UserDocument> findUser(String uid) {
        return userRepository.findByUid(uid);
    }

    public List<UserDocument> findAllUser() {
        return userRepository.findAll();
    }

    public UserDocument insertUser(UserDocument user) {
        return userRepository.insert(user);
    }

    public UserDocument updateUser(UserDocument user) {
        return userRepository.save(user);
    }

    public Optional<UserDocument> delteUser(String uid) {
        return userRepository.deleteByUid(uid);

    }
}
