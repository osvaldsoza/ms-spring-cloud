package br.com.monktec.hrworker.service;

import br.com.monktec.hrworker.worker.Worker;

import java.util.List;


public interface WorkerService {

    List<Worker> findAll();

    Worker findById(Long id);
}
