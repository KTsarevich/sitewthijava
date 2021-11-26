package com.example.demo.repo;

import com.example.demo.mod.Zakaz;
import org.springframework.data.repository.CrudRepository;

public interface zakazRepository extends CrudRepository<Zakaz, Long> {

}
