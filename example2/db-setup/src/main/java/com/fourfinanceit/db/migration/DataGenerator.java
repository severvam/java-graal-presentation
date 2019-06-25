package com.fourfinanceit.db.migration;

import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import static java.math.BigDecimal.valueOf;
import static java.math.RoundingMode.HALF_UP;
import static java.time.LocalDateTime.now;
import static java.util.stream.Collectors.toList;

public class DataGenerator {

    public List<Loan> generate() {
        final Random random = new Random();
        return Stream
                .generate(() -> new Loan(valueOf(random.nextDouble()).setScale(4, HALF_UP), now(), now()))
                .limit(1000)
                .collect(toList());
    }

}
