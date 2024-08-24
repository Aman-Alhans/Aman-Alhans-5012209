package com.example.bookstoreapi.metrics;

import org.springframework.stereotype.Service;

import io.micrometer.core.instrument.MeterRegistry;

@Service
public class CustomMetricsService {
	
	private final MeterRegistry meterRegistry;

    public CustomMetricsService(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
        // Register a custom counter metric
        meterRegistry.counter("custom.metric.counter", "type", "example");
    }

    public void incrementCustomMetric() {
        meterRegistry.counter("custom.metric.counter", "type", "example").increment();
    }
}
