package org.mjozwk.policy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class RandomPolicyTest {

    @InjectMocks
    private RandomPolicy testee;

    @Test
    void getAppropriateNode() {
        List<String> ipList = List.of("1.1.1",  "2.2.2");

        var appropriateNode = testee.getAppropriateNode(ipList);

        assertThat(appropriateNode).isIn(ipList);
    }
}