package de.rub.nds.crypto.examples;

import java.security.Provider;
import java.security.Security;

public class ProviderList {

    public static void main(String[] args) {
        Provider[] providers = Security.getProviders();
        for (Provider p : providers) {
            System.out.println(p.getName());
        }
        for (Provider p : providers) {
            System.out.println(p.getServices());
        }
    }
}
