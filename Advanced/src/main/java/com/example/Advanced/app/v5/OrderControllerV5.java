package com.example.Advanced.app.v5;

import com.example.Advanced.trace.TraceCallback;
import com.example.Advanced.trace.TraceTemplate;
import com.example.Advanced.trace.logtrace.LogTrace;
import com.example.Advanced.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderControllerV5 {

    private final OrderServiceV5 orderService;
    private final TraceTemplate template;

    public OrderControllerV5(OrderServiceV5 orderService, LogTrace trace) {
        this.orderService = orderService;
        this.template = new TraceTemplate(trace);
    }
    @GetMapping("/v5/request")
    public String request(String itemId) {
        return template.execute("OrderController.request()", new
                TraceCallback<>() {
                    @Override
                    public String call() {
                        orderService.orderItem(itemId);
                        return "ok";
                    }
                });
    }
}
