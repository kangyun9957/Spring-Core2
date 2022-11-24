package com.example.Advanced.app.v2;

import com.example.Advanced.trace.TraceId;
import com.example.Advanced.trace.TraceStatus;
import com.example.Advanced.trace.hellotrace.HelloTraceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV2 {

    private final OrderRepositoryV2 orderRepositoryV2;
    private final HelloTraceV2 traceV1;
    public void orderItem(TraceId traceId, String itemId){
        TraceStatus status = null;
        try{
            status = traceV1.beginSync(traceId,"OrderService.orderItem()");
            orderRepositoryV2.save(status.getTraceId(),itemId);
            traceV1.end(status);
        } catch (Exception e){
            traceV1.exception(status,e);
            throw e;
        }

    }
}
