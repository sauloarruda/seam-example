package br.com.jera.example.domain;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.annotations.Transactional;

@Name("addressBook")
@Scope(ScopeType.EVENT)
public class AddressBook {

	@In
	private EntityManager em;

	@Transactional
	public void add(Contact contact) {
		em.persist(contact);
	}

	@SuppressWarnings("unchecked")
	public List<Contact> search(String query) {
		Query q = em.createQuery("SELECT c FROM Contact c WHERE c.lastName LIKE ?");
		q.setParameter(1, "%" + query + "%");
		return q.getResultList();
	}
}
