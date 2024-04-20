package com.simi.socialmedia.repository;

import com.simi.socialmedia.model.Chat;
import com.simi.socialmedia.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ChatRepository extends JpaRepository<Chat, Integer> {
    public List<Chat> findByUsersId(Integer userId);

    @Query("SELECT c FROM Chat c WHERE :user MEMBER OF c.users AND :reqUser MEMBER OF c.users")
    public Chat findChatByUsersId(@Param("user") User user, @Param("reqUser") User reqUser);

}
