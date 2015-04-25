package org.dream.bean.response;

import com.google.gson.annotations.Expose;

public class TraceId {
    @Expose
    private String traceId;
    
    public TraceId(String traceId){
        this.traceId=traceId;
    }
    
    /**
     * @return the traceId
     */
    public String getTraceId() {
        return traceId;
    }

    /**
     * @param traceId the traceId to set
     */
    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }
}
