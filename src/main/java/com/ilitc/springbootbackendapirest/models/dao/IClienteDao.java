package com.ilitc.springbootbackendapirest.models.dao;

import com.ilitc.springbootbackendapirest.models.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface IClienteDao extends CrudRepository<Cliente, Long> {

}
