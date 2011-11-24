package com.dust.net.https;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.security.GeneralSecurityException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.X509TrustManager;

public class HttpsTest {
	// We would never hardcode this literal in a real system,
	// this is only for this article.
	// private String url = "https://222.44.51.34:18443/iss.do";
	// private String url ="http://127.0.0.1:8080/tomcat-docs/";
//	private String url = "https://127.0.0.1:8443/service/imageco/invoke.do";
	
	private String url = "https://222.44.51.34:18443/iss.do";
	
	

	// Create an anonymous class to trust all certificates.
	// This is bad style, you should create a separate class.
	
	private X509TrustManager xtm = new X509TrustManager() {
		public void checkClientTrusted(X509Certificate[] chain, String authType) {
		}

		public void checkServerTrusted(X509Certificate[] chain, String authType) {
			System.out.println("cert: " + chain[0].toString() + ", authType: " + authType);
		}

		public X509Certificate[] getAcceptedIssuers() {
			return null;
		}
	};

	// Create an class to trust all hosts
	private HostnameVerifier hnv = new HostnameVerifier() {
		public boolean verify(String hostName, SSLSession session) {
			  System.out.println("Warning: URL Host: "+hostName+" vs. "+session.getPeerHost());
			return true;
		}
	};

	// In this function we configure our system with a less stringent
	// hostname verifier and X509 trust manager. This code is
	// executed once, and calls the static methods of HttpsURLConnection
	public HttpsTest() {
		// Initialize the TLS SSLContext with
		// our TrustManager
		
		//忽略掉安全检查，不管对方的https证书是否有效。
		SSLContext sslContext = null;

		try {
			sslContext = SSLContext.getInstance("TLS");
			X509TrustManager[] xtmArray = new X509TrustManager[] { xtm };
			sslContext.init(null, xtmArray, new java.security.SecureRandom());
		} catch (GeneralSecurityException gse) {
			gse.printStackTrace();
			// Print out some error message and deal with this exception
		}

		// Set the default SocketFactory and HostnameVerifier
		// for javax.net.ssl.HttpsURLConnection
		if (sslContext != null) {
			HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.getSocketFactory());
		}

		HttpsURLConnection.setDefaultHostnameVerifier(hnv);
	}

	// This function is called periodically, the important thing
	// to note here is that there is no special code that needs to
	// be added to deal with a "HTTPS" URL. All of the trust
	// management, verification, is handled by the HttpsURLConnection.
	public void run() {
		try {
			URLConnection urlCon = (new URL(url)).openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(urlCon.getInputStream()));
			String line;

			while ((line = in.readLine()) != null) {
				System.out.println(line);
			}

			// Whatever we want to do with these quotes
		} catch (MalformedURLException mue) {
			mue.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		HttpsTest httpsTest = new HttpsTest();
		httpsTest.run();
	}
}