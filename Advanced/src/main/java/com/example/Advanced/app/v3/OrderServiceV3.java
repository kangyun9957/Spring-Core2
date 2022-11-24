package com.example.Advanced.app.v3;

import com.example.Advanced.trace.TraceId;
import com.example.Advanced.trace.TraceStatus;
import com.example.Advanced.trace.hellotrace.HelloTraceV2;
import com.example.Advanced.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV3 {

    private final OrderRepositoryV3 orderRepositoryV3;
    private final LogTrace traceV1;
    public void orderItem(String itemId){
        TraceStatus status = null;
        try{
            status = traceV1.begin("OrderService.orderItem()");
            orderRepositoryV3.save(itemId);
            traceV1.end(status);
        } catch (Exception e){
            traceV1.exception(status,e);
            throw e;
        }

    }
}
