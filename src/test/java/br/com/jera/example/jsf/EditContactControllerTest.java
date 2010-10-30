package br.com.jera.example.jsf;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import br.com.jera.example.test.DomainObjectTestCase;

public class EditContactControllerTest extends DomainObjectTestCase {

	@Test
	public void createNewContactWithMinimalInformation() throws Exception {
		new ComponentTest() {
			@Override
			protected void testComponents() throws Exception {
				setValue("#{contact.lastName}", "Arruda");
				assertThat(invokeMethod("#{editContactController.save}").toString(), is(equalTo("success")));
				assertThat(getValue("#{contact.id}"), is(notNullValue()));
			}
		}.run();
	}
}
