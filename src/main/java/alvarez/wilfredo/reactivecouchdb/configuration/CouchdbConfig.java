package alvarez.wilfredo.reactivecouchdb.configuration;

import lombok.RequiredArgsConstructor;
import org.ektorp.CouchDbConnector;
import org.ektorp.CouchDbInstance;
import org.ektorp.http.HttpClient;
import org.ektorp.http.StdHttpClient;
import org.ektorp.impl.StdCouchDbConnector;
import org.ektorp.impl.StdCouchDbInstance;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "couchdb.client")
@RequiredArgsConstructor
public class CouchdbConfig {
    private String host;
    private String port;
    private String username;
    private String password;
    private String db;
    private CouchDbConnector couchDbConnector;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDb() {
        return db;
    }

    public void setDb(String db) {
        this.db = db;
    }

    @Bean
    public HttpClient getHttpClient() {
        return new StdHttpClient.Builder()
                .host(getHost())
                .port(Integer.parseInt(getPort()))
                .username(getUsername())
                .password(getPassword())
                .build();
    }

    @Bean
    public CouchDbInstance getCouchDbInstance() {
        return new StdCouchDbInstance(getHttpClient());
    }

    @Bean
    public void initConector() {
        couchDbConnector = new StdCouchDbConnector(getDb(), getCouchDbInstance());
    }

    public CouchDbConnector getConnector() {
        couchDbConnector.createDatabaseIfNotExists();
        return couchDbConnector;
    }
}
