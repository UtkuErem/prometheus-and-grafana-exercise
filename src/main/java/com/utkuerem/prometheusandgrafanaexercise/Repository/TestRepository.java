package com.utkuerem.prometheusandgrafanaexercise.Repository;

import com.utkuerem.prometheusandgrafanaexercise.entity.TestEntity;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<TestEntity, Long> {

}
