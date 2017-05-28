package net.nuttle.service;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommService {
  
  private static final Logger LOG = LoggerFactory.getLogger(CommService.class);
  public static final String SERVICE_NAME = "comm_service";
  private String servletPath;

  public CommService(String servletPath) {
    this.servletPath = servletPath;
  }
  
  public String ping(String in) throws URISyntaxException, IOException {
    URI uri = new URIBuilder()
      .setScheme("http")
      .setHost("localhost")
      .setPort(8080)
      .setPath(servletPath)
      .setParameter("in", in)
      .build();
    HttpGet get = new HttpGet(uri);
    CloseableHttpClient client = HttpClients.createDefault();
    CloseableHttpResponse response = client.execute(get);
    StatusLine status = response.getStatusLine();
    LOG.debug("Status received: " + status.getStatusCode());
    if (status.getStatusCode() >= 300) {
      return "Status code: " + status.getStatusCode();
    }
    try {
      HttpEntity entity = response.getEntity();
      InputStream is = entity.getContent();
      String content = IOUtils.toString(is, Charset.forName("UTF-8"));
      return content;
    } finally {
      response.close();
    }
  }
}
