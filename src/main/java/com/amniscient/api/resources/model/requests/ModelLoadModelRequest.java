/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.amniscient.api.resources.model.requests;

import com.amniscient.api.core.ObjectMappers;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = ModelLoadModelRequest.Builder.class)
public final class ModelLoadModelRequest {
    private final String organizationId;

    private final Map<String, Object> additionalProperties;

    private ModelLoadModelRequest(String organizationId, Map<String, Object> additionalProperties) {
        this.organizationId = organizationId;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return Your organization identifier
     */
    @JsonProperty("organization_id")
    public String getOrganizationId() {
        return organizationId;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ModelLoadModelRequest && equalTo((ModelLoadModelRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(ModelLoadModelRequest other) {
        return organizationId.equals(other.organizationId);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.organizationId);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static OrganizationIdStage builder() {
        return new Builder();
    }

    public interface OrganizationIdStage {
        _FinalStage organizationId(@NotNull String organizationId);

        Builder from(ModelLoadModelRequest other);
    }

    public interface _FinalStage {
        ModelLoadModelRequest build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements OrganizationIdStage, _FinalStage {
        private String organizationId;

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(ModelLoadModelRequest other) {
            organizationId(other.getOrganizationId());
            return this;
        }

        /**
         * <p>Your organization identifier</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @java.lang.Override
        @JsonSetter("organization_id")
        public _FinalStage organizationId(@NotNull String organizationId) {
            this.organizationId = Objects.requireNonNull(organizationId, "organizationId must not be null");
            return this;
        }

        @java.lang.Override
        public ModelLoadModelRequest build() {
            return new ModelLoadModelRequest(organizationId, additionalProperties);
        }
    }
}
