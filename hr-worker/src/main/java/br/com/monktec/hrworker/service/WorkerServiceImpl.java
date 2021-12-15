package br.com.monktec.hrworker.service;

import br.com.monktec.hrworker.repositories.WorkerRepository;
import br.com.monktec.hrworker.worker.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkerServiceImpl implements WorkerService{

    @Autowired
    private WorkerRepository workerRepository;

    @Override
    public List<Worker> findAll() {
        var workers = workerRepository.findAll();

        return workers;
    }

    @Override
    public Worker findById(Long id) {
        var worker = workerRepository.findById(id).get();

        return worker;
    }
}
