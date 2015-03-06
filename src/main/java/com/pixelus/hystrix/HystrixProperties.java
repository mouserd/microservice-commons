package com.pixelus.hystrix;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "hystrix", ignoreUnknownFields = true)
public class HystrixProperties {

    private boolean enabled = false;
    private boolean streamEnabled = false;
    private String streamUrl = "/hystrix.stream";

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(final boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isStreamEnabled() {
        return streamEnabled;
    }

    public void setStreamEnabled(final boolean streamEnabled) {
        this.streamEnabled = streamEnabled;
    }

    public String getStreamUrl() {
        return streamUrl;
    }

    public void setStreamUrl(final String streamUrl) {
        this.streamUrl = streamUrl;
    }
}
