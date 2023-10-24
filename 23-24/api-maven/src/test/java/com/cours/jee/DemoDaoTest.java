package com.cours.jee;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import com.cours.jee.dao.CalculatorDao;
import com.cours.jee.model.CalculatorResult;

import jakarta.inject.Inject;

public class DemoDaoTest {
    CalculatorDao calculatorDao = new CalculatorDao();

    @Test
    void testAdd() {
        calculatorDao.add(new CalculatorResult(10, 1));
        var results = calculatorDao.getAll();
        Assertions.assertThat(results).containsExactlyInAnyOrder(new CalculatorResult(10, 1));
    }
}
