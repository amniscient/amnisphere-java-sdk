/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.amniscient.api;

import com.amniscient.api.core.AmniscientApiApiException;
import com.amniscient.api.core.AmniscientApiHttpResponse;
import com.amniscient.api.core.AmniscientException;
import com.amniscient.api.core.ClientOptions;
import com.amniscient.api.core.MediaTypes;
import com.amniscient.api.core.ObjectMappers;
import com.amniscient.api.core.RequestOptions;
import com.amniscient.api.errors.BadRequestError;
import com.amniscient.api.errors.UnauthorizedError;
import com.amniscient.api.requests.DetectRequest;
import com.amniscient.api.requests.LoadModelRequest;
import com.amniscient.api.types.DetectResponse;
import com.amniscient.api.types.LoadModelResponse;
import com.amniscient.api.types.UnauthorizedErrorBody;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.IOException;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class RawAmniscientApiClient {
    protected final ClientOptions clientOptions;

    public RawAmniscientApiClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    /**
     * Initializes a model for inference. This endpoint must be called before running any detections.
     */
    public AmniscientApiHttpResponse<LoadModelResponse> loadModel(String modelId, LoadModelRequest request) {
        return loadModel(modelId, request, null);
    }

    /**
     * Initializes a model for inference. This endpoint must be called before running any detections.
     */
    public AmniscientApiHttpResponse<LoadModelResponse> loadModel(
            String modelId, LoadModelRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("loadModel")
                .addPathSegment(modelId)
                .build();
        RequestBody body;
        try {
            body = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(request), MediaTypes.APPLICATION_JSON);
        } catch (JsonProcessingException e) {
            throw new AmniscientException("Failed to serialize request", e);
        }
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("POST", body)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json")
                .build();
        OkHttpClient client = clientOptions.httpClient();
        if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
            client = clientOptions.httpClientWithTimeout(requestOptions);
        }
        try (Response response = client.newCall(okhttpRequest).execute()) {
            ResponseBody responseBody = response.body();
            if (response.isSuccessful()) {
                return new AmniscientApiHttpResponse<>(
                        ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), LoadModelResponse.class), response);
            }
            String responseBodyString = responseBody != null ? responseBody.string() : "{}";
            try {
                switch (response.code()) {
                    case 400:
                        throw new BadRequestError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class), response);
                    case 401:
                        throw new UnauthorizedError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, UnauthorizedErrorBody.class),
                                response);
                }
            } catch (JsonProcessingException ignored) {
                // unable to map error response, throwing generic error
            }
            throw new AmniscientApiApiException(
                    "Error with status code " + response.code(),
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class),
                    response);
        } catch (IOException e) {
            throw new AmniscientException("Network error executing HTTP request", e);
        }
    }

    /**
     * Detects an object within an uploaded image file. Make sure to load the model you're using for detection first!
     */
    public AmniscientApiHttpResponse<DetectResponse> detect(DetectRequest request) {
        return detect(request, null);
    }

    /**
     * Detects an object within an uploaded image file. Make sure to load the model you're using for detection first!
     */
    public AmniscientApiHttpResponse<DetectResponse> detect(DetectRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("detect")
                .build();
        MultipartBody.Builder body = new MultipartBody.Builder().setType(MultipartBody.FORM);
        try {
            body.addFormDataPart(
                    "organization_id", ObjectMappers.JSON_MAPPER.writeValueAsString(request.getOrganizationId()));
            body.addFormDataPart("file", ObjectMappers.JSON_MAPPER.writeValueAsString(request.getFile()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Request.Builder _requestBuilder = new Request.Builder()
                .url(httpUrl)
                .method("POST", body.build())
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Accept", "application/json");
        Request okhttpRequest = _requestBuilder.build();
        OkHttpClient client = clientOptions.httpClient();
        if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
            client = clientOptions.httpClientWithTimeout(requestOptions);
        }
        try (Response response = client.newCall(okhttpRequest).execute()) {
            ResponseBody responseBody = response.body();
            if (response.isSuccessful()) {
                return new AmniscientApiHttpResponse<>(
                        ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), DetectResponse.class), response);
            }
            String responseBodyString = responseBody != null ? responseBody.string() : "{}";
            try {
                if (response.code() == 400) {
                    throw new BadRequestError(
                            ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class), response);
                }
            } catch (JsonProcessingException ignored) {
                // unable to map error response, throwing generic error
            }
            throw new AmniscientApiApiException(
                    "Error with status code " + response.code(),
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class),
                    response);
        } catch (IOException e) {
            throw new AmniscientException("Network error executing HTTP request", e);
        }
    }
}
