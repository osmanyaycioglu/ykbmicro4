package com.ykb.cloud;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ykb.cloud.models.Employee;

@Repository
public interface EmployeeDAO extends CrudRepository<Employee, String> {

    List<Employee> findByEmailAndName(String email,
                                      String name);

    @Query("select e from Employee e where e.name=:isim and e.email=:em")
    List<Employee> xyz(@Param("em") String email,
                       @Param("isim") String name);

    @Query(value = "select * from employee  where name=:isim and email=:em", nativeQuery = true)
    List<Employee> abc(@Param("em") String email,
                       @Param("isim") String name);

}
