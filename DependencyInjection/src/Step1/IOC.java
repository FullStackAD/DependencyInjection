package Step1;

/**
 * Example of DI and IOC
 */
public class IOC {

    public static void main(String[] args) {
        IOC container = new IOC();
        User user = container.new User();
        user.add("Some Data");
    }
    /**
    * Business Layer Logic
    */
    public class User {
        MySqlDatabase database;

        /**
         * User is Creating an Instance of MySqlDatabase.
         */
        public User() {
            database = new MySqlDatabase();
        }

        public void add(String data) {
            database.persist(data);
        }
    }

    /**
     * Database Access Layer
     */
    public class MySqlDatabase {
        public void persist(String data) {
            System.out.println("Mysql has persisted: " + data);
        }
    }
}
