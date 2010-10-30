package br.com.jera.example.test;

import org.apache.log4j.Logger;
import org.jboss.seam.mock.AbstractSeamTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

public abstract class DomainObjectTestCase extends AbstractSeamTest {

	private static final Logger LOG = Logger.getLogger(DomainObjectTestCase.class);
	private static boolean seamStarted = false;

	@Before
	@Override
	public void begin() {
		try {
			if (!seamStarted) {
				super.startSeam();
				seamStarted = true;
			}
			super.setupClass();
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			Assert.fail("Test setup failure: " + e.getMessage());
		}
		super.begin();
	}

	@After
	@Override
	public void end() {
		super.end();
		try {
			super.cleanupClass();
			// super.stopSeam();
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			Assert.fail("Test cleanup failure: " + e.getMessage());
		}
	}

}
