package org.mjozwk;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ServiceRegisterTest {

    /*
    It should be possible to register an instance, identified by an address
Each address should be unique, it should not be possible to register the same address more than once
Service Registry should accept up to 10 addresses

service instance - one function

Set -> for unique adress

ServiceRegistery.java

- Set services
- public void registerAdress () {
set - check size before put
then add


exception or msg about size exceeded

Clinet can put wrong format
}
     */
    @InjectMocks
    private ServiceRegister testee;

    @Test
    void registerAdress() {

        String adressToRegister = "192.168.0.1";
        testee.registerAdress(adressToRegister);

        assertThat(testee.getRegisteredAdresses()).contains(adressToRegister);

    }

    @Test
    void registerAdress_whenAdressToRegisterIsNull() {

        String adressToRegister = null;

        assertThrows(RuntimeException.class,
                () ->
                {testee.registerAdress(adressToRegister);
                });

        assertThat(testee.getRegisteredAdresses()).doesNotContain(adressToRegister);

    }

    @Test
    void registerAdress_whenAdressToRegisterIsEmpty() {

        String adressToRegister = "";
        assertThrows(RuntimeException.class,
                () ->
                {testee.registerAdress(adressToRegister);
        });

        assertThat(testee.getRegisteredAdresses()).doesNotContain(adressToRegister);

    }

    @Test
    void registerAdress_whenAdressIsRegistered() {

        String adressToRegister = "192.168.0.1";
        testee.getRegisteredAdresses().add(adressToRegister);

        assertThrows(RuntimeException.class,
                () ->
                {testee.registerAdress(adressToRegister);
                });

        assertThat(testee.getRegisteredAdresses()).contains(adressToRegister);

    }

    @Test
    void registerAdress_whenAdressLimitIsExceeded() {

        String adressToRegister = "192.168.0.1";
        Set<String> registeredAdresses = testee.getRegisteredAdresses();
        exceedAdresses(registeredAdresses);

        assertThrows(RuntimeException.class,
                () ->
                {testee.registerAdress(adressToRegister);
                });


    }

    private void exceedAdresses(Set<String> registeredAdresses) {
        for (char i =0; i< 10; i++)
            registeredAdresses.add(String.valueOf(i));
    }
}