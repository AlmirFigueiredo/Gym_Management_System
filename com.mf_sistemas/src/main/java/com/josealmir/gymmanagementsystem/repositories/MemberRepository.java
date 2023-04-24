package com.josealmir.gymmanagementsystem.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.josealmir.gymmanagementsystem.model.person.Member;

public interface MemberRepository extends MongoRepository<Member, ObjectId> {
    
}
