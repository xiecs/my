package com.dust.security;

import java.security.Provider;
import java.security.Security;

public class SecurityDemo {

	public static void main(String[] args) {
        Provider[] providers = Security.getProviders();
        for (int i = 0; i < providers.length; i++) {
            Provider provider = providers[i];
            System.out.println((provider.getName() + " " + provider.getVersion()
               + ": " + provider.getInfo()));   
        }
	}
}
