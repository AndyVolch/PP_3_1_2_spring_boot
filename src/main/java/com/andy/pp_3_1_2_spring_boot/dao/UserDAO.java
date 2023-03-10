package com.andy.pp_3_1_2_spring_boot.dao;

import com.andy.pp_3_1_2_spring_boot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<User, Long>{
}
