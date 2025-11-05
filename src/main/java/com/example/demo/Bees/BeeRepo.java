package com.example.demo.Bees;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.Bees.Bee.Bees;

@Repository
public interface BeeRepo extends JpaRepository<Bee, Long> {
    List<Bee> getBeeByName(String name);

    @Query(value = "select * from bees s where s.name like %?1% ", nativeQuery = true)
    List<Bees> getBeesByDescription(String description);
}
