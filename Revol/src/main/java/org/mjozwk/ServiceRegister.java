package org.mjozwk;

import java.util.HashSet;
import java.util.Set;

public class ServiceRegister {

    private final Set<String> registeredAdresses = new HashSet<>();


    public void registerAdress(String adressToRegister) {
        validate(adressToRegister);
        registeredAdresses.add(adressToRegister);
    }

    private void validate(String adressToRegister) {
        String msg = "";
        if (adressToRegister == null) {
            msg = "Adress to register is null, adress: " + adressToRegister;

        } else if (adressToRegister.isEmpty()) {
            msg = "Adress to register is empty, adress: " + adressToRegister;

        } else if (registeredAdresses.size() >= 10) {
            msg = "Adresses size exceeded";

        } else if (registeredAdresses.contains(adressToRegister)) {
            msg = "Adress to register is already registered, adress" + adressToRegister;
        }

        if (!msg.isEmpty()) {
            throw new RuntimeException(msg);
        }
    }

    public Set<String> getRegisteredAdresses() {
        return registeredAdresses;
    }
}
