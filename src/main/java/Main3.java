import org.example.bd_table.LinkedPurchaseList;
import org.example.bd_table.PurchaseList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class Main3 {

    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();

        List<PurchaseList> table1Data = session.createQuery("FROM PurchaseList", PurchaseList.class).getResultList();
        for (PurchaseList purchaseList : table1Data) {
            LinkedPurchaseList linkedPurchaseList = new LinkedPurchaseList();
            linkedPurchaseList.setId(purchaseList.getId());
            linkedPurchaseList.setStudentId(purchaseList.getStudent().getId());
            linkedPurchaseList.setCourseId(purchaseList.getCourse().getId());
            session.save(linkedPurchaseList);
        }
        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
