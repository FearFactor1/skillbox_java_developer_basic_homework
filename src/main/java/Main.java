import org.example.bd_table.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

import static org.hibernate.id.PersistentIdentifierGenerator.PK;

public class Main {

    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();

        CriteriaQuery<PurchaseList> query = builder.createQuery(PurchaseList.class);
        Root<PurchaseList> root = query.from(PurchaseList.class);
        query.select(root);
        List<PurchaseList> purchaseList = session.createQuery(query).getResultList();
        System.out.println(purchaseList);

        Transaction transaction = session.beginTransaction();
        for (PurchaseList purchase : purchaseList) {
            LinkedPurchaseList linkedPurchase = new LinkedPurchaseList();
            int studentId = purchase.getStudent().getId();
            linkedPurchase.setStudentId(studentId);
            int courseId = purchase.getCourse().getId();
            linkedPurchase.setCourseId(courseId);
            linkedPurchase.setId(new LinkedPurchaseListKey(studentId, courseId));
            System.out.println(linkedPurchase);
        }
        transaction.commit();

        session.close();
        sessionFactory.close();
    }
}
