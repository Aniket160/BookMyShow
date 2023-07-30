package com.springboot.BookMyShow.dao;

import com.springboot.BookMyShow.model.Auditorium;
import org.hibernate.sql.ast.tree.expression.JdbcParameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditoriumRepository extends JpaRepository<Auditorium,Long> {
	
}
