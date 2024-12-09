package lessonfive.hometask;

import lessonfive.hometask.model.User;
import lessonfive.hometask.model.Role;
import lessonfive.hometask.repository.RoleRepository;
import lessonfive.hometask.repository.UserRepository;
import lessonfive.hometask.repository.impl.RoleRepositoryImpl;
import lessonfive.hometask.repository.impl.UserRepositoryImpl;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        RoleRepository roleRepository = new RoleRepositoryImpl();

        // Add roles to database.
        Role admin = new Role("Admin");
        System.out.println("Role Admin show before save:");
        System.out.println(admin);
        admin = roleRepository.create(admin);
        System.out.println("Role Admin added:");
        System.out.println(admin);
        System.out.println();

        Role staff = new Role();
        staff.setName("Staff");
        System.out.println("Role Staff show before save:");
        System.out.println(staff);
        staff = roleRepository.create(staff);
        System.out.println("Role Staff added:");
        System.out.println(staff);
        System.out.println();

        Role client = new Role("client");
        client.setName("Client");
        System.out.println("Role Client show before save:");
        System.out.println(client);
        client = roleRepository.create(client);
        System.out.println("Role Client added:");
        System.out.println(client);
        System.out.println();

        Role instructor = new Role(null, "tructor");
        System.out.println("Role Instructor show before changes:");
        System.out.println(instructor);
        instructor.setName("Instructor");
        System.out.println("Role Instructor show before save:");
        System.out.println(instructor);
        instructor = roleRepository.create(instructor);
        System.out.println("Role instructor added:");
        System.out.println(instructor);
        System.out.println();

        Role notSavedRole = new Role(null, "notSavedRole");
        System.out.println("Role not saved show before changes:");
        System.out.println(notSavedRole);
        notSavedRole.setName("non saved");
        notSavedRole.setId(1_000_000_000L);
        System.out.println("Role not saved show after changes:");
        System.out.println(notSavedRole);
        System.out.println();

        // Find roles.
        System.out.println();
        System.out.println("Role client print out:");
        roleRepository.findById(client.getId()).ifPresentOrElse(System.out::println, () -> System.out.println("-"));
        System.out.println();
        System.out.println("Not saved role print out:");
        roleRepository.findById(1_000_000_000L).ifPresentOrElse(System.out::println, () -> System.out.printf("Role with ID=%d was not found in database.%n", 1_000_000_000L));
        System.out.println();

        // Save users and add roles to them.
        // List of roles for developer type of users.
        List<Role> rolesetDeveloper = List.of(admin, staff, client, instructor);

        // List of roles for staff type of users.
        List<Role> rolesetOwner = List.of(staff, instructor);

        // Create new user.
        User userAdmin = new User();
        userAdmin.setName("Van");
        userAdmin.setEmail("email@com.com");
        userAdmin.setRoles(rolesetDeveloper);
        System.out.println("User with admin role before save:");
        System.out.println(userAdmin);
        System.out.println();

        // Create another new user.
        User userStaff = new User();
        userStaff.setName("Oll");
        userStaff.setEmail("");
        userStaff.setRoles(rolesetOwner);
        System.out.println("User with staff role before save:");
        System.out.println(userStaff);
        System.out.println();

        UserRepository userRepository = new UserRepositoryImpl();

        // Saving admin to database.
        userAdmin = userRepository.create(userAdmin);
        System.out.println("User with admin roles saved:");
        System.out.println(userAdmin);
        System.out.println();

        // Saving staff to database.
        userStaff = userRepository.create(userStaff);
        System.out.println("User with staff roles saved:");
        System.out.println(userStaff);
        System.out.println();

        // Look for user with Admin privileges.
        User finalUserAdmin = userAdmin;
        System.out.printf("Look for user with id=%d%n", finalUserAdmin.getId());
        userRepository.findById(userAdmin.getId()).ifPresentOrElse(showUserData(),
            () -> System.out.printf("User with id=%d not found%n", finalUserAdmin.getId()));
        System.out.println();

        // Look for user with Staff privileges.
        User finalUserStaff = userStaff;
        System.out.printf("Look for user with id=%d%n", finalUserStaff.getId());
        userRepository.findById(userStaff.getId()).ifPresentOrElse(showUserData(),
            () -> System.out.printf("User with id=%d not found%n", finalUserStaff.getId())
        );
        System.out.println();

        // Look for unknown user.
        Long unknownId = 0L;
        System.out.printf("Look for user with id=%d%n", unknownId);
        userRepository.findById(unknownId).ifPresentOrElse(showUserData(),
            () -> System.out.printf("User with id=%d not found%n", unknownId)
        );
        System.out.println();

        // Modify Staff roles list.
        List<Role> roles = userStaff.getRoles();
        System.out.println("User with staff roles:");
        System.out.println(userStaff);
        System.out.println(roles);
        userStaff.setRoles(List.of(staff, instructor, client)); // New set of roles for Staff privileges.
        userStaff = userRepository.update(userStaff);
        System.out.println("User with staff roles updated:");
        System.out.println(userStaff);
        System.out.println(userStaff.getRoles());
    }

    /**
     * IDEA generated this method,
     * Consumer - as I understand is just covers operation what I wanted to do: one input and no output.
     */
    @NotNull
    @Contract(pure = true)
    private static Consumer<User> showUserData() {
        return user -> {
            System.out.println("User found:");
            System.out.println(user);
            System.out.println("User's roles:");
            System.out.println(user.getRoles());
        };
    }
}
