package org.mjozwk;

import java.util.List;

public class IpStore {
    private static final List<String> ipList = List.of("192.168.0.1", "192.168.0.2", "192.168.0.3", "192.168.0.4");

    public List<String> getIpList() {
        return ipList;
    }
}
