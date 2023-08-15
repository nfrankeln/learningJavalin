package org.example;

import io.javalin.Javalin;
import user.UserController;
// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        var app = Javalin.create(/*config*/).start(7070);
                app.get("/", ctx -> ctx.result("Hello World"));
                app.get("/users", UserController.fetchAllUsernames);
                app.get("/users/{id}", UserController.fetchById);

        }
    }
