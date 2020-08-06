// tag::comment[]
/*******************************************************************************
 * Copyright (c) 2017 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
// end::comment[]
package io.openliberty.guides.hello.it;

import static org.junit.jupiter.api.Assertions.*;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class EndpointIT {

  private static String URL;

  @BeforeAll
  public static void init() {
    // tag::URL[]
    String port = System.getProperty("liberty.test.port");
    String war = System.getProperty("war.name");
    URL = "http://localhost:" + port + "/" + war + "/" + "servlet";
    // end::URL[]
  }

  @Test
  public void testServlet() throws Exception {

    CloseableHttpClient httpClient = HttpClients.createDefault();
    HttpGet httpGet = new HttpGet(URL);

    CloseableHttpResponse response = httpClient.execute(httpGet);

    try {
      int actualStatusCode = response.getStatusLine().getStatusCode();

      int expectedStatusCode = HttpStatus.SC_OK;
      assertEquals(/*"HTTP GET failed",*/ expectedStatusCode, actualStatusCode);

      HttpEntity httpEntity = response.getEntity();
      String bodyString = EntityUtils.toString(httpEntity);
      // String response = httpGetMethod.getResponseBodyAsString(1000);
      assertTrue(
          /*"Unexpected response body",*/
          bodyString.contains("Hello! Is Gradle working for you?"));
    } finally {
      response.close();
      httpClient.close();
    }
  }
}
