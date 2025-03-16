package org.example.helper;

import org.awaitility.Awaitility;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class AwaitilityUtils {

    public static <T> void waitForCondition(Supplier<T> conditionSupplier, T expectedValue, long timeoutInSeconds) {
        Awaitility.await()
                .atMost(timeoutInSeconds, TimeUnit.SECONDS)
                .until(() -> expectedValue.equals(conditionSupplier.get()));
    }
}
