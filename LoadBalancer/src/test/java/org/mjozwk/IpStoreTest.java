package org.mjozwk;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class IpStoreTest {

    @InjectMocks
    private IpStore testee;

    @Test
    void getIpList() {
        assertThat(testee.getIpList()).isNotEmpty();
    }
}