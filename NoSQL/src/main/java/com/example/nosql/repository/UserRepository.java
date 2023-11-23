package com.example.nosql.repository;

import com.example.nosql.document.UserDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<UserDocument, String> {

    public Optional<UserDocument> findByUid(String uid);
    public Optional<UserDocument> deleteByUid(String uid);


}
