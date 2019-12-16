package com.ignas;

    import com.ignas.model.Associations.ManyToMany.Employee;
    import com.ignas.model.Associations.ManyToMany.Project;
    import com.ignas.model.Associations.OneToOne.AddressOneToOne;
    import com.ignas.model.Associations.OneToOne.UserOneToOne;
    import com.ignas.model.BasicTypes.Contact;
    import com.ignas.model.BasicTypes.Name;
    import com.ignas.model.CollectionTypes.UserWPhone;
    import com.ignas.model.EntityListenersModel.Movie;
    import com.ignas.model.HqlExamplesModel.Phone;
    import com.ignas.model.HqlExamplesModel.PhoneType;
    import com.ignas.model.HqlExamplesModel.UserWPhoneObject;
    import com.ignas.model.User;
    import org.hibernate.Session;
    import org.hibernate.SessionFactory;
    import org.hibernate.Transaction;
    import org.hibernate.boot.Metadata;
    import org.hibernate.boot.MetadataSources;
    import org.hibernate.boot.registry.StandardServiceRegistry;
    import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

    import javax.persistence.EntityManager;
    import javax.persistence.EntityManagerFactory;
    import javax.persistence.Persistence;
    import javax.persistence.Query;
    import java.net.MalformedURLException;
    import java.net.URL;
    import java.util.ArrayList;
    import java.util.HashSet;
    import java.util.List;
    import java.util.Set;

public class Driver {

    private static final EntityManagerFactory emf;

    static {
        emf = Persistence.createEntityManagerFactory("cf.mindaugas.movie_catalog");
    }

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }


    public static void main(String[] args) throws InterruptedException, MalformedURLException {
        // 1 ex: simple entity creation
        // simpleEntityExample();


        // // 2 ex: Basic Hybernate types:
        // basicTypesExample();


        // // 3 ex: persisting (saving) Java collections
        // persistingCollections();


        // // 4. ex: read and update entity
        // simpleEntityReadAndUpdate();



        // // 5. ex: delete an entity
        // System.out.println("Entity should be in the database, please check ... I will sleep for 10s");
        // Thread.sleep(10000);
        // simpleEntityDelete();
        // System.out.println("Entity should be deleted!");

        //6. ex: equals method
        // Contact c1 = new Contact(new Name("Name1", "Middle1", "Last1"), new URL("http://a.b.c"), true);
        // Contact c2 = new Contact(new Name("Name2", "Middle3", "Last3"), new URL("http://a.b.cf"), true);
        //
        // if (c1.equals(c2))
        //     System.out.println("Equals");
        //

        // 7. CALLBACKS AND ENTITYLISTENERS
        // entityListenersExample();


        // 8. - Associations
        // oneToOneExamplePersist();
        // manyToManyExamplePersist();


        // 9. - HQL
        // hqlExample();
        // hqlNamedQueriesExample();
        hqlExampleWithJoins();


    }


    public static void hqlExampleWithJoins() throws InterruptedException {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build(); // Create registry
        MetadataSources sources = new MetadataSources(registry); // Create MetadataSources
        Metadata metadata = sources.getMetadataBuilder().build(); // Create Metadata

        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build(); // Create SessionFactory
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        System.out.println("--------------- Joins: inserting data -----------------");

        UserWPhoneObject userWPhoneObject1 = new UserWPhoneObject("Mindaugas w/ Phone Obect", "Brazilka");
        Phone cellPhone1 =  new Phone("+370 625 22259", PhoneType.MOBILE);
        Phone officePhone1 =  new Phone("+37 251 999225", PhoneType.LAND_LINE);
        userWPhoneObject1.getPhones().add(cellPhone1);
        userWPhoneObject1.getPhones().add(officePhone1);
        session.persist(userWPhoneObject1);

        UserWPhoneObject userWPhoneObject2 = new UserWPhoneObject("Jim", "Carrey");
        Phone cellPhone2 =  new Phone("+111 625 22259", PhoneType.MOBILE);
        Phone officePhone2 =  new Phone("+22 251 999225", PhoneType.LAND_LINE);
        userWPhoneObject2.getPhones().add(cellPhone2);
        userWPhoneObject2.getPhones().add(officePhone2);
        session.persist(userWPhoneObject2);

        transaction.commit();

        int secondsToSleep = 10;
        System.out.println("----- Joins: done inserting, check the database, while I'm sleeping for " +  secondsToSleep + " seconds -----");
        Thread.sleep(secondsToSleep * 1000);
        System.out.println("----- Done sleeping -----");

        List<UserWPhoneObject> userWPhoneObjectList = session.createQuery(
                "select distinct pwpo " +
                        "from UserWPhoneObject pwpo " +
                        "inner join pwpo.phones ph " +
                        "where ph.type = :phoneType", UserWPhoneObject.class)
                .setParameter("phoneType", PhoneType.LAND_LINE)
                .getResultList();

        for (UserWPhoneObject u : userWPhoneObjectList){
            System.out.print("Name is: " + u.getName() + " ... and the phones are: ");
            for(Phone p : u.getPhones()){
                System.out.print(p.getValue() + " ");
            }
            System.out.println();
        }

        session.close();
    }


    public static void hqlNamedQueriesExample(){
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build(); // Create registry
        MetadataSources sources = new MetadataSources(registry); // Create MetadataSources
        Metadata metadata = sources.getMetadataBuilder().build(); // Create Metadata

        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build(); // Create SessionFactory
        Session session = sessionFactory.openSession();
        Transaction transaction1 = session.beginTransaction();

        session.persist(new User("Mindaugas", "B"));
        transaction1.commit();


        System.out.println("--------------- Named queries -----------------");
        Query query = session.getNamedQuery("get_user_by_name");
        query.setParameter("name", "Mindaugas");
        List<User> usersWName = query.getResultList();
        // System.out.println(usersWName.size());
        System.out.println("------------------ Select using named query ------------------");
        for (User userWName : usersWName){
            System.out.println("Name is: " + userWName.getName());
        }
        System.out.println("--------------------------------------------------------------");

        query = session.getNamedQuery("get_user_by_name_fuzzy");
        query.setParameter("name", "M%");
        usersWName = query.getResultList();
        // System.out.println(usersWName.size());
        System.out.println("------- Select using named query (fuzzy, partial match) --------");
        for (User userWName : usersWName){
            System.out.println("Name is: " + userWName.getName());
        }
        System.out.println("--------------------------------------------------------------");
    }




    public static void hqlExample() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build(); // Create registry
        MetadataSources sources = new MetadataSources(registry); // Create MetadataSources
        Metadata metadata = sources.getMetadataBuilder().build(); // Create Metadata

        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build(); // Create SessionFactory
        Session session = sessionFactory.openSession();
        Transaction transaction1 = session.beginTransaction();

        session.persist(new User("Robert", "Martin"));

        transaction1.commit();

        // Select all users
        String hql = "FROM User";
        Query query = session.createQuery(hql);
        List<User> users = query.getResultList();
        // System.out.println(users.size());
        System.out.println("------------------ Select all users ------------------");
        for (User user : users){
            System.out.println("Id: " + user.getId() + ", name: " + user.getName());
        }
        System.out.println("------------------------------------------------------");

        // Select only names from Users for all users
        hql = "SELECT U.name FROM User U";
        query = session.createQuery(hql);
        List<String> names = query.getResultList();
        // System.out.println(names.size());
        System.out.println("-------------- Select only names for users ---------------");
        for (String name : names){
            System.out.println("Name is: " + name);
        }
        System.out.println("------------------------------------------------------");


        // Query with parameter
        query = session.createQuery("select u from User u where name = :name");

        query.setParameter("name", "Robert");
        List<User> usersWName = query.getResultList();
        // System.out.println(usersWName.size());
        System.out.println("--------- Select only names with parametrized query -----------");
        for (User userWName : usersWName){
            System.out.println("Name is: " + userWName.getName());
        }
        System.out.println("------------------------------------------------------");




    }//



    public static void manyToManyExamplePersist() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build(); // Create registry
        MetadataSources sources = new MetadataSources(registry); // Create MetadataSources
        Metadata metadata = sources.getMetadataBuilder().build(); // Create Metadata
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build(); // Create SessionFactory

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        String[] employeeData = { "Peter Oven", "Allan Norman" };
        String[] projectData = { "IT Project", "Networking Project" };
        Set<Project> projects = new HashSet<>();

        for (String proj : projectData) {
            projects.add(new Project(proj));
        }

        for (String emp : employeeData) {
            Employee employee = new Employee(emp.split(" ")[0], emp.split(" ")[1]);

            employee.setProjects(projects);
            session.persist(employee);
        }

        transaction.commit();
        session.close();
    }



    public static long oneToOneExamplePersist() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build(); // Create registry
        MetadataSources sources = new MetadataSources(registry); // Create MetadataSources
        Metadata metadata = sources.getMetadataBuilder().build(); // Create Metadata
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build(); // Create SessionFactory

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        AddressOneToOne addressOneToOne = new AddressOneToOne("Lithuania", "Kaunas", "Taikos pr.");
        UserOneToOne userOneToOne = new UserOneToOne("Mindaugas", "mindaugas@gmail.com", addressOneToOne);

        // session.persist(addressOneToOne); // if you are not using:
        session.persist(userOneToOne);

        transaction.commit();
        session.close();

        return userOneToOne.getId();
    }






    public static void entityListenersExample(){
        Driver d = new Driver();
        long id = d.saveMovieReturnId();
        Movie movie = d.getMovie(id);
        System.out.println(movie.getAge());
        movie.setMovieName(movie.getMovieName() + "!");
        System.out.println(movie.getMovieName());
    }

    public Movie getMovie(Long movieId) {
        EntityManager em = getEntityManager();
        Movie movie = em.find(Movie.class, new Long(movieId));
        return movie;
    }

    public long saveMovieReturnId() {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Movie movie = new Movie();
        movie.setId(3L);
        movie.setMovieName("The Godfather");
        movie.setReleaseYear(1972);
        movie.setLanguage("English");
        em.persist(movie);
        em.getTransaction().commit();
        return movie.getId();
    }



    public static void basicTypesExample() throws MalformedURLException {

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build(); // Create registry
        MetadataSources sources = new MetadataSources(registry); // Create MetadataSources
        Metadata metadata = sources.getMetadataBuilder().build(); // Create Metadata

        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build(); // Create SessionFactory
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        // CREATE
        Contact contact = new Contact(2,
                new Name("Mindaugas", "", "Bernatavičius"),
                "Notes 1",
                new URL("http://www.abc.com"),
                true);

        session.persist(contact);
        transaction.commit();
        session.close();
    }

    public static void simpleEntityExample(){
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build(); // Create registry
        MetadataSources sources = new MetadataSources(registry); // Create MetadataSources
        Metadata metadata = sources.getMetadataBuilder().build(); // Create Metadata

        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build(); // Create SessionFactory
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        System.out.println("----- Transaciton has begun ----------");

        // CREATE
        User user = new User("Robert", "Martin");
        session.persist(user);

        // How can we check whether the entity is persisted
        // durring the persist() call or durring the commit()?

        // System.out.println("----- Check now 1 -----");
        // Thread.sleep(10000);

        transaction.commit();

        // System.out.println("----- Check now 2 -----");
        // Thread.sleep(10000);

        session.close();
        sessionFactory.close();
    }

    public static void persistingCollections(){
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build(); // Create registry
        MetadataSources sources = new MetadataSources(registry); // Create MetadataSources
        Metadata metadata = sources.getMetadataBuilder().build(); // Create Metadata

        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build(); // Create SessionFactory
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        ArrayList<String> phones = new ArrayList<>();
        phones.add("+77 889 008033");
        phones.add("+370 84 08977777");

        // CREATE
        UserWPhone userWPhone = new UserWPhone("Alexardr", "Bell");
        userWPhone.setPhones(phones);
        session.persist(userWPhone);

        transaction.commit();
        session.close();
    }


    public static void simpleEntityReadAndUpdate(){
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build(); // Create registry
        MetadataSources sources = new MetadataSources(registry); // Create MetadataSources
        Metadata metadata = sources.getMetadataBuilder().build(); // Create Metadata

        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build(); // Create SessionFactory
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        // UPDATE
        User user = session.find(User.class, 1L); // NullPointerException if object is not found
        user.setName("Robert C. XXXXXXXX");
        transaction.commit();
        session.close();
    }


    public static void simpleEntityDelete() throws InterruptedException {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build(); // Create registry
        MetadataSources sources = new MetadataSources(registry); // Create MetadataSources
        Metadata metadata = sources.getMetadataBuilder().build(); // Create Metadata

        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build(); // Create SessionFactory
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        // CREATE
        User user = new User("Robert", "Martin");
        session.persist(user);
        transaction.commit();

        System.out.println("Entity should be in the database, please check ... I will sleep for 10s");
        Thread.sleep(10000);

        // DELETE
        Transaction transaction2 = session.beginTransaction();
        session.delete(session.find(User.class, 1L));
        transaction2.commit();

        session.close();
        sessionFactory.close();
    }


}
