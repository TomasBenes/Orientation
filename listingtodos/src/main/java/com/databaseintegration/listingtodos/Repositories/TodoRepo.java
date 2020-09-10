package com.databaseintegration.listingtodos.Repositories;

import com.databaseintegration.listingtodos.Model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepo extends JpaRepository<Todo, Long> {




}
