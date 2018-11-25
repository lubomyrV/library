package com.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.model.Authors;

public interface AuthorsDao extends JpaRepository<Authors, Integer>{

}
