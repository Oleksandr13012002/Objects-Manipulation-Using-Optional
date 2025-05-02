package app;

import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String... argc){

        UserRepository repo = new UserRepository();
        repo.addUser(new User(1, "Alex", "alex@gmail.com"));
        repo.addUser(new User(2, "Anton", "anton@gmail.com"));

        System.out.println();
        System.out.println("ОТРИМАННЯ ВСІХ КОРИСТУВАЧІВ");
        findAllUsers(repo);
        System.out.println();

        System.out.println("ОТРИМАННЯ ВСІХ КОРИСТУВАЧІВ (ПУСТИЙ РЕПОЗИТОРІЙ)");
        UserRepository emptyRepo = new UserRepository();
        findAllUsers(emptyRepo);
        System.out.println();

        System.out.println("ПОШУК КОРИСТУВАЧА ПО ІСНУЮЧОМУ ID");
        int existingId = 1;
        findUserById(repo, existingId);
        System.out.println();

        System.out.println("ПОШУК КОРИСТУВАЧА ПО НЕІСНУЮЧОМУ ID");
        int nonExistingId = 100;
        findUserById(repo, nonExistingId);
        System.out.println();

        System.out.println("ПОШУК КОРИСТУВАЧА ПО ІСНУЮЧІЙ EMAIL");
        String existingEmail = "alex@gmail.com";
        findUserByEmail(repo, existingEmail);
        System.out.println();

        System.out.println("ПОШУК КОРИСТУВАЧА ПО НЕІСНУЮЧІЙ EMAIL");
        String nonExistingEmail = "name@gmail.com";
        findUserByEmail(repo, nonExistingEmail);
        System.out.println();

    }

    public static void findUserById(UserRepository repo, int id){
        Optional<User> userById = repo.findUserById(id);
        userById.ifPresentOrElse(
                user -> System.out.printf("Знайдено користувача за id(%d): %s\n", id, user),
                () -> System.out.printf("Користувача з таким id(%d) не знайдено\n", id)
        );
    }

    public static void findUserByEmail(UserRepository repo, String email){
        Optional<User> userByEmail = repo.findUserByEmail(email);
        userByEmail.ifPresentOrElse(
                user -> System.out.printf("Знайдено користувача за email(%s): %s\n", email, user),
                () -> System.out.printf("Користувача з таким email(%s) не знайдено\n", email)
        );
    }

    public static void findAllUsers(UserRepository repo){
        Optional<List<User>> allUsers = repo.findAllUsers();
        allUsers.ifPresentOrElse(
                list -> {
                    System.out.println("Кількість користувачів: " + list.size());
                    list.forEach(System.out::println);
                },
                () -> System.out.println("Список користувачів порожній")
        );
    }
}
