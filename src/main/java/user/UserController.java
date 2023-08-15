package user;

import io.javalin.http.Handler;
import java.util.Optional;
import java.util.Objects;
public class UserController {
    public static Handler fetchAllUsernames = ctx -> {
        UserDao dao = UserDao.instance();
        Iterable<String> allUsers = dao.getAllUsernames();
        ctx.json(allUsers);
    };

    public static Handler fetchById = ctx -> {
        int id = Integer.parseInt(Objects.requireNonNull(ctx.pathParam("id")));
        UserDao dao = UserDao.instance();
        Optional<User> user = dao.getUserById(id);
        user.ifPresent(u -> ctx.json(u));
        if (!user.isPresent()) {
            ctx.html("Not Found");
        }
    };
}

