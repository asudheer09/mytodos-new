package com.user.mytodso.repository;

import com.user.mytodso.entity.Mytodos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MytodosRepository extends JpaRepository<Mytodos,Long> {
}
