package alvarez.wilfredo.reactivecouchdb.service.user.datasource;

import alvarez.wilfredo.reactivecouchdb.configuration.CouchdbConfig;
import alvarez.wilfredo.reactivecouchdb.service.user.datasource.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserRepository {
    private final CouchdbConfig couchdbConfig;

    public List<String> getAll() {
        return couchdbConfig.getConnector().getAllDocIds();
    }
    public User getUser(String id) {
        return couchdbConfig.getConnector().get(User.class, id);
    }

    public void saveUser(User u) {
        couchdbConfig.getConnector().create(u);
    }

    public void updateUser(User u) {
        couchdbConfig.getConnector().update(u);
    }

    public void deleteUser(User u) {
        couchdbConfig.getConnector().delete(u);
    }
}
