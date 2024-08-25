package org.airtribe.AsyncSyncApiCall.entity;

import java.util.List;


public class ApiResponse {
    private List<Result> results;

    // Getters and setters
    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }
}