/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.amniscient.api.resources.model.types;

import com.amniscient.api.core.ObjectMappers;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = ModelLoadModelResponse.Builder.class)
public final class ModelLoadModelResponse {
    private final Optional<String> status;

    private final Optional<String> message;

    private final Optional<String> modelId;

    private final Map<String, Object> additionalProperties;

    private ModelLoadModelResponse(
            Optional<String> status,
            Optional<String> message,
            Optional<String> modelId,
            Map<String, Object> additionalProperties) {
        this.status = status;
        this.message = message;
        this.modelId = modelId;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return A status code denoting success or failure.
     */
    @JsonProperty("status")
    public Optional<String> getStatus() {
        return status;
    }

    @JsonProperty("message")
    public Optional<String> getMessage() {
        return message;
    }

    /**
     * @return The model ID of the model you loaded. This should match the model ID that was input as a path parameter to this API.
     */
    @JsonProperty("model_id")
    public Optional<String> getModelId() {
        return modelId;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ModelLoadModelResponse && equalTo((ModelLoadModelResponse) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(ModelLoadModelResponse other) {
        return status.equals(other.status) && message.equals(other.message) && modelId.equals(other.modelId);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.status, this.message, this.modelId);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> status = Optional.empty();

        private Optional<String> message = Optional.empty();

        private Optional<String> modelId = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(ModelLoadModelResponse other) {
            status(other.getStatus());
            message(other.getMessage());
            modelId(other.getModelId());
            return this;
        }

        @JsonSetter(value = "status", nulls = Nulls.SKIP)
        public Builder status(Optional<String> status) {
            this.status = status;
            return this;
        }

        public Builder status(String status) {
            this.status = Optional.ofNullable(status);
            return this;
        }

        @JsonSetter(value = "message", nulls = Nulls.SKIP)
        public Builder message(Optional<String> message) {
            this.message = message;
            return this;
        }

        public Builder message(String message) {
            this.message = Optional.ofNullable(message);
            return this;
        }

        @JsonSetter(value = "model_id", nulls = Nulls.SKIP)
        public Builder modelId(Optional<String> modelId) {
            this.modelId = modelId;
            return this;
        }

        public Builder modelId(String modelId) {
            this.modelId = Optional.ofNullable(modelId);
            return this;
        }

        public ModelLoadModelResponse build() {
            return new ModelLoadModelResponse(status, message, modelId, additionalProperties);
        }
    }
}
