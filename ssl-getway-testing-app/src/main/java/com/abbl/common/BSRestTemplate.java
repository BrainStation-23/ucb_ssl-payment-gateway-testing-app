package com.abbl.common;


import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.*;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nasir on 4/14/2014.
 */
@Service
@Configurable
public class BSRestTemplate<T extends BaseModel> {

    static {
        disableSslVerification();
    }

    private static void disableSslVerification() {
        try
        {
            // Create a trust manager that does not validate certificate chains
            TrustManager[] trustAllCerts = new TrustManager[] {new X509TrustManager() {
                public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
                public void checkClientTrusted(X509Certificate[] certs, String authType) {
                }
                public void checkServerTrusted(X509Certificate[] certs, String authType) {
                }
            }
            };

            // Install the all-trusting trust manager
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

            // Create all-trusting host name verifier
            HostnameVerifier allHostsValid = new HostnameVerifier() {
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            };

            // Install the all-trusting host verifier
            HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }
    }
    public T postWithModel(String uRL, Object data, Class<T> type) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

        T result = null;

        try {

            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            result = restTemplate.postForObject(uRL, data, type);
            return result;
        } catch (Exception ex) {
        }


        return result;
    }



    public T get(String uRL, Object data, Class<T> type) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

        T result = null;

        try {

            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            result = restTemplate.getForObject(uRL, type);

                return result;

        } catch (Exception ex) {
        }


        return result;
    }


    public T postWithModelWithoutHeader(String uRL, Object data, Class<T> type) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());


        T result = null;

        try {

            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            result = restTemplate.postForObject(uRL, data, type);

            return result;

        } catch (Exception ex) {
            System.out.println(""+ex);
        }


        return result;
    }

    private T getExceptionResult(Class<T> type,String message,int responseCode) {
        T gObj = null;
        try {
            gObj = type.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return gObj;
    }

}
