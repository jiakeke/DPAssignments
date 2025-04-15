package proxy.library;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AccessControlService {
    private static AccessControlService instance;
    private Map<Integer, Set<User>> permissions;

    private AccessControlService() {
        // Initialize permissions map
        permissions = new HashMap<>();
    }

    public static AccessControlService getInstance() {
        if (instance == null) {
            instance = new AccessControlService();
        }
        return instance;
    }

    public void grantAccess(Document document, User user) {
        permissions.computeIfAbsent(document.getId(), k -> new HashSet<>()).add(user);
    }

    public Boolean isAllowed(Document document, User user) {
        Set<User> usersWithAccess = permissions.get(document.getId());
        return usersWithAccess != null && usersWithAccess.contains(user);
    }
}
