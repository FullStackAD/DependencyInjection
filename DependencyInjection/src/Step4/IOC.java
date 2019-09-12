package Step4;

/**
 * Example of DI and IOC
 */
public class IOC {

    public static void main(String[] args) {
        IOC container = new IOC();
        User mySql = container.new User(container.new MySqlDatabase());
        User postgres = container.new User(container.new PostgreslDatabase());
        mySql.add("Some Data");
        postgres.add("Some Data");
    }
    /**
    * Business Layer Logic
    */
    public class User {
        Database database;

        /**
         * User is Accepts an Instance.
         * We achieved DI since we are no longer creating the Instances.
         */
        public User(Database database) {
            this.database = database;
        }

        public void add(String data) {
            database.persist(data);
        }
    }

    /**
     * Database Access Layer
     * An Interface to Help In IOC
     */
    public interface Database {
        public void persist(String data);
    }

    /**
     * MySQL Database Access Layer
     */
    public class MySqlDatabase implements Database{
        public void persist(String data) {
            System.out.println("Mysql has persisted: " + data);
        }
    }

    /**
     * POSTGRS Database Access Layer
     */
    public class PostgreslDatabase implements Database{
        public void persist(String data) {
            System.out.println("Postgres has persisted: " + data);
        }
    }
}
