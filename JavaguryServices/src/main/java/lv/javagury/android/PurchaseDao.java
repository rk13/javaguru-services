package lv.javagury.android;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public  class PurchaseDao {

	private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("purchases");
	
	@SuppressWarnings("unchecked")
	public static List<Purchase> getPurchaseListByToken(String token) {
		final EntityManager em = FACTORY.createEntityManager();

		try {
			return em.createQuery("select p from Purchase p where p.token = ?1")
					 .setParameter(1, token)
					 .getResultList();
		}
		finally{
			em.close();
		}
	}
	
	public void storePurchases() {
//		final EntityManager em = FACTORY.createEntityManager();
//		em.getTransaction().begin();
//		em.getTransaction().commit();
//		em.close();
	}
}
