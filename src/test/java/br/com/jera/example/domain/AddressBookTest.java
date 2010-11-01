package br.com.jera.example.domain;

import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.assertThat;

import javax.persistence.PersistenceException;

import org.junit.Test;

import br.com.jera.example.test.DomainObjectTestCase;

public class AddressBookTest extends DomainObjectTestCase {

	@Test
	public void successCreatingNewContactWithMinimalInformation() throws Exception {
		new ComponentTest() {
			@Override
			protected void testComponents() throws Exception {
				AddressBook addressBook = (AddressBook) getInstance("addressBook");

				Contact contact = new Contact("Arruda");
				addressBook.add(contact);
				assertThat(addressBook.search(contact.getLastName()), hasItem(contact));
			}
		}.run();
	}

	@Test(expected = PersistenceException.class)
	public void failCreatingContactWithoutRequiredInformation() throws Exception {
		new ComponentTest() {
			@Override
			protected void testComponents() throws Exception {
				AddressBook addressBook = (AddressBook) getInstance("addressBook");

				Contact contact = new Contact();
				addressBook.add(contact);
			}
		}.run();
	}
}
