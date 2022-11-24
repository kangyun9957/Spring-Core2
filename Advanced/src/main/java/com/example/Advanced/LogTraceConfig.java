package com.example.Advanced;

import com.example.Advanced.trace.logtrace.FieldLogTrace;
import com.example.Advanced.trace.logtrace.LogTrace;
import com.example.Advanced.trace.logtrace.ThreadLocalLogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogTraceConfig {

    @Bean
    public LogTrace logTrace(){
        return new ThreadLocalLogTrace();
    }
}
