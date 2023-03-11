package com.userregister.userregister.repository;

import com.userregister.userregister.model.Post;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository <Post, Integer> {
    @Query(value="SELECT p FROM Post p WHERE p.userOwner.id =?1")
    public List<Post> findByUserOwner(int id);
}
