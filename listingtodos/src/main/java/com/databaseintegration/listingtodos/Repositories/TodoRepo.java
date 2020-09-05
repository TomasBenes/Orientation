package com.databaseintegration.listingtodos.Repositories;

import com.databaseintegration.listingtodos.Model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepo extends JpaRepository<Todo, Long> {

}
