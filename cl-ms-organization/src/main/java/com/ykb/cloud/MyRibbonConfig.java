package com.ykb.cloud;

import org.springframework.context.annotation.Bean;

import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.NoOpPing;

public class MyRibbonConfig {

    @Bean
    public IRule createRule() {
        return new AvailabilityFilteringRule();
    }

    @Bean
    public IPing createPing() {
        return new NoOpPing();
    }

}
