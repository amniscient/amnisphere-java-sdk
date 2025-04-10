/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.amniscient.api;

import com.amniscient.api.core.ClientOptions;
import com.amniscient.api.core.Environment;
import okhttp3.OkHttpClient;

public final class AsyncAmniscientApiClientBuilder {
    private ClientOptions.Builder clientOptionsBuilder = ClientOptions.builder();

    private String apiKey = null;

    private Environment environment = Environment.DEFAULT;

    /**
     * Sets apiKey
     */
    public AsyncAmniscientApiClientBuilder apiKey(String apiKey) {
        this.apiKey = apiKey;
        return this;
    }

    public AsyncAmniscientApiClientBuilder environment(Environment environment) {
        this.environment = environment;
        return this;
    }

    public AsyncAmniscientApiClientBuilder url(String url) {
        this.environment = Environment.custom(url);
        return this;
    }

    /**
     * Sets the timeout (in seconds) for the client. Defaults to 60 seconds.
     */
    public AsyncAmniscientApiClientBuilder timeout(int timeout) {
        this.clientOptionsBuilder.timeout(timeout);
        return this;
    }

    /**
     * Sets the maximum number of retries for the client. Defaults to 2 retries.
     */
    public AsyncAmniscientApiClientBuilder maxRetries(int maxRetries) {
        this.clientOptionsBuilder.maxRetries(maxRetries);
        return this;
    }

    /**
     * Sets the underlying OkHttp client
     */
    public AsyncAmniscientApiClientBuilder httpClient(OkHttpClient httpClient) {
        this.clientOptionsBuilder.httpClient(httpClient);
        return this;
    }

    public AsyncAmniscientApiClient build() {
        if (apiKey == null) {
            throw new RuntimeException("Please provide apiKey");
        }
        this.clientOptionsBuilder.addHeader("x-api-key", this.apiKey);
        clientOptionsBuilder.environment(this.environment);
        return new AsyncAmniscientApiClient(clientOptionsBuilder.build());
    }
}
