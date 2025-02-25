/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.amniscient.api.core;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public final class RequestOptions {
    private final String apiKey;

    private final Optional<Integer> timeout;

    private final TimeUnit timeoutTimeUnit;

    private final Map<String, String> headers;

    private final Map<String, Supplier<String>> headerSuppliers;

    private RequestOptions(
            String apiKey,
            Optional<Integer> timeout,
            TimeUnit timeoutTimeUnit,
            Map<String, String> headers,
            Map<String, Supplier<String>> headerSuppliers) {
        this.apiKey = apiKey;
        this.timeout = timeout;
        this.timeoutTimeUnit = timeoutTimeUnit;
        this.headers = headers;
        this.headerSuppliers = headerSuppliers;
    }

    public Optional<Integer> getTimeout() {
        return timeout;
    }

    public TimeUnit getTimeoutTimeUnit() {
        return timeoutTimeUnit;
    }

    public Map<String, String> getHeaders() {
        Map<String, String> headers = new HashMap<>();
        if (this.apiKey != null) {
            headers.put("x-api-key", this.apiKey);
        }
        headers.putAll(this.headers);
        this.headerSuppliers.forEach((key, supplier) -> {
            headers.put(key, supplier.get());
        });
        return headers;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String apiKey = null;

        private Optional<Integer> timeout = Optional.empty();

        private TimeUnit timeoutTimeUnit = TimeUnit.SECONDS;

        private final Map<String, String> headers = new HashMap<>();

        private final Map<String, Supplier<String>> headerSuppliers = new HashMap<>();

        public Builder apiKey(String apiKey) {
            this.apiKey = apiKey;
            return this;
        }

        public Builder timeout(Integer timeout) {
            this.timeout = Optional.of(timeout);
            return this;
        }

        public Builder timeout(Integer timeout, TimeUnit timeoutTimeUnit) {
            this.timeout = Optional.of(timeout);
            this.timeoutTimeUnit = timeoutTimeUnit;
            return this;
        }

        public Builder addHeader(String key, String value) {
            this.headers.put(key, value);
            return this;
        }

        public Builder addHeader(String key, Supplier<String> value) {
            this.headerSuppliers.put(key, value);
            return this;
        }

        public RequestOptions build() {
            return new RequestOptions(apiKey, timeout, timeoutTimeUnit, headers, headerSuppliers);
        }
    }
}
