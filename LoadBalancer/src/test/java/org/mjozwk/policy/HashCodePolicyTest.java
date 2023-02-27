package org.mjozwk.policy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class HashCodePolicyTest {

    @InjectMocks
    private HashCodePolicy testee = new HashCodePolicy("2.2.2");

    @Test
    void getAppropriateNode() {
        List<String> ipList = List.of("1.1.1",  "2.2.2");

        var result = testee.getAppropriateNode(ipList);

        assertThat(result).isEqualTo("1.1.1");
    }
}