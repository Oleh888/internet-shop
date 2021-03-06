package dev.internetshop.dao.impl;

import dev.internetshop.dao.UserDao;
import dev.internetshop.db.Storage;
import dev.internetshop.model.User;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class UserDaoImpl implements UserDao {

    @Override
    public User create(User user) {
        Storage.addUser(user);
        return user;
    }

    @Override
    public Optional<User> get(Long id) {
        return Storage.users
                .stream()
                .filter(user -> user.getUserId().equals(id))
                .findFirst();
    }

    @Override
    public List<User> getAll() {
        return Storage.users;
    }

    @Override
    public User update(User user) {
        IntStream.range(0, Storage.users.size())
                .filter(x -> user.getUserId().equals(Storage.users.get(x).getUserId()))
                .forEach(i -> Storage.users.set(i, user));
        return user;
    }

    @Override
    public boolean delete(Long id) {
        return Storage.users.removeIf(user -> user.getUserId().equals(id));
    }

    @Override
    public Optional<User> findByLogin(String login) {
        return Storage.users.stream()
                .filter(user -> user.getLogin().equals(login))
                .findFirst();
    }
}
