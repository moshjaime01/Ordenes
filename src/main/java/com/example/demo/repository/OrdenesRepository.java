package com.example.demo.repository;

import com.example.demo.data.Ordenes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdenesRepository extends JpaRepository<Ordenes,Long> {
}
