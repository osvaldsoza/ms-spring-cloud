package br.com.monktec.hrworker.service;

import br.com.monktec.hrworker.repositories.WorkerRepository;
import br.com.monktec.hrworker.worker.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class WorkerService {

    private final WorkerRepository workerRepository;

    public WorkerService(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    public List<Worker> findAll() {
        var workers = workerRepository.findAll();

        return workers;
    }

    public Worker findById(Long id) {
        var worker = workerRepository.findById(id).get();

        return worker;
    }
}
