/*
 * Zed Attack Proxy (ZAP) and its related class files.
 *
 * ZAP is an HTTP/HTTPS proxy for assessing web application security.
 *
 * Copyright 2018 The ZAP Development Team
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.zaproxy.clientapi.gen;

import java.util.HashMap;
import java.util.Map;
import org.zaproxy.clientapi.core.ApiResponse;
import org.zaproxy.clientapi.core.ClientApi;
import org.zaproxy.clientapi.core.ClientApiException;

/** API Client for the Talon GraphQL addOn */
@SuppressWarnings("javadoc")
public class TalonGraphQL {

    private final ClientApi api;

    public TalonGraphQL(ClientApi api) {
        this.api = api;
    }

    /**
     * Import and spider a GraphQL API via an imported file schema
     *
     * @return ApiException
     * @param file absolute file path to the GraphQL schema
     * @param batchQueries deprecated
     * @param maxDepth max recursion depth for query generation
     * @param operation GraphQL operation type (e.g. Query/Mutation)
     * @param requestDelay delay time between subsequent spidering requests
     * @param requestMethod http request verb, GET or POST are supported in GraphQL
     * @param requestPerCycle number of requests per request interval
     * @param uri target URI to spider using the file-based schema
     * @param uriMaxLength maximum length when using GET requests
     */
    public ApiResponse scanGraphQLByFile(
            String file,
            String uri,
            String requestMethod,
            String batchQueries,
            String uriMaxLength,
            String maxDepth,
            String requestPerCycle,
            String requestDelay,
            String operation)
            throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (file != null) {
            map.put("file", file);
        }
        if (uri != null) {
            map.put("uri", uri);
        }
        map.put("requestMethod", requestMethod);
        map.put("batchQueries", batchQueries);
        map.put("uriMaxLength", uriMaxLength);
        map.put("maxDepth", maxDepth);
        map.put("requestPerCycle", requestPerCycle);
        map.put("requestDelay", requestDelay);
        map.put("operation", operation);
        return api.callApi("talon", "action", "scanGraphQLByFile", map);
    }

    /**
     * Introspect a GraphQL schema endpoint and perform spidering
     *
     * @return ApiException
     * @param batchQueries deprecated
     * @param maxDepth max recursion depth for query generation
     * @param operation GraphQL operation type (e.g. Query/Mutation)
     * @param requestDelay delay time between subsequent spidering requests
     * @param requestMethod http request verb, GET or POST are supported in GraphQL
     * @param requestPerCycle number of requests per request interval
     * @param uri target URI to spider using the file-based schema
     * @param uriMaxLength maximum length when using GET requests
     */
    public ApiResponse scanGraphQLByURI(
            String uri,
            String requestMethod,
            String batchQueries,
            String uriMaxLength,
            String maxDepth,
            String requestPerCycle,
            String requestDelay,
            String operation)
            throws ClientApiException {
        Map<String, String> map = new HashMap<>();
        if (uri != null) {
            map.put("uri", uri);
        }
        map.put("requestMethod", requestMethod);
        map.put("batchQueries", batchQueries);
        map.put("uriMaxLength", uriMaxLength);
        map.put("maxDepth", maxDepth);
        map.put("requestPerCycle", requestPerCycle);
        map.put("requestDelay", requestDelay);
        map.put("operation", operation);
        return api.callApi("talon", "action", "scanGraphQLByURI", map);
    }
}
