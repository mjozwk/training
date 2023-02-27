package org.mjozwk;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mjozwk.policy.BalancingPolicy;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class LoadBalancerTest {

    @Mock
    private BalancingPolicy balancingPolicy;

    @Mock
    private IpStore ipStore;

    @InjectMocks
    private LoadBalancer loadBalancer;

    @Test
    void getNode() {

        String appropriateNode = "2.2.2";
        List<String> ipList = List.of("1.1.1", appropriateNode);
        when(ipStore.getIpList()).thenReturn(ipList);
        when(balancingPolicy.getAppropriateNode(ipList)).thenReturn(appropriateNode);

        var result = loadBalancer.getNode();

        assertThat(result).isNotEmpty().isEqualTo(appropriateNode);
        assertThat(ipList).contains(result);
        verify(balancingPolicy).getAppropriateNode(ipList);
    }
}