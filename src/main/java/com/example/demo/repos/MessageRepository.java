package com.example.demo.repos;

import com.example.demo.model.Message;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Propagation;

import java.util.List;

public interface MessageRepository extends CrudRepository<Message, Integer> {
    @Transactional//(propagation = Propagation.REQUIRED)
    List<Message> findByTag(String tag);
}
