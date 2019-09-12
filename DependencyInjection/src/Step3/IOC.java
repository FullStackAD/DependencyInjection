package Step3;

/**
 * Example of DI and IOC
 */
public class IOC {

    public static void main(String[] args) {
        IOC container = new IOC();
        User user = container.new User(container.new PostgreslDatabase());
        user.add("Some Data");
    }
    /**
    * Business Layer Logic
    */
    public class User {
        PostgreslDatabase database;

        /**
         * User is Accepts an Instance.
         * We achieved DI since we are no longer creating the Instances.
         */
        public User(PostgreslDatabase database) {
            this.database = database;
        }

        public void add(String data) {
            database.persist(data);
        }
    }

    /**
     * Database Access Layer
     */
    public class PostgreslDatabase {
        public void persist(String data) {
            System.out.println("Postgres has persisted: " + data);
        }
    }
}
