package br.com.monktec.hrworker.repositories;

import br.com.monktec.hrworker.worker.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository extends JpaRepository<Worker, Long> {
}
