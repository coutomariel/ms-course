package com.coutomariel.hrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coutomariel.hrworker.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long> {

}
