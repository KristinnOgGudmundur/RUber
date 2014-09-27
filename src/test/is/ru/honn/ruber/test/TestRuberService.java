package is.ru.honn.ruber.test;

import is.ru.honn.ruber.domain.User;
import is.ru.honn.ruber.service.RuberService;
import is.ru.honn.ruber.service.RuberUserService;
import is.ru.honn.ruber.service.UsernameExistsException;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.logging.Logger;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/res/app-test-stub.xml"})
public class TestRuberService extends TestCase
{

	Logger log = Logger.getLogger(TestRuberService.class.getName());

	@Autowired
	private RuberService service;

	@Autowired
	private User testUser1;

	@Autowired
	private User testUser2;

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Before
	public void setUp() throws Exception
	{

	}

	@Test //(expected= UsernameExistsException.class)
	public void testUser()
	{
		log.info("testUser");

		assertTrue(service.getUsers().isEmpty());

		testUsernameExists();

		assertFalse(service.getUsers().isEmpty());
	}

	public void testUsernameExists(){
		boolean usernameExists = false;
		try{
			service.signup(testUser1.getUsername(),
					testUser1.getFirstName(),
					testUser1.getLastName(),
					testUser1.getEmail(),
					testUser1.getPassword(),
					testUser1.getPicture(),
					testUser1.getPromoCode());
		}
		catch(UsernameExistsException e){
			usernameExists = true;
		}

		assertFalse(usernameExists);
		usernameExists = false;

		try {
			service.signup(testUser1.getUsername(),
					testUser1.getFirstName(),
					testUser1.getLastName(),
					testUser1.getEmail(),
					testUser1.getPassword(),
					testUser1.getPicture(),
					testUser1.getPromoCode());
		}
		catch(UsernameExistsException e){
			usernameExists = true;
		}

		assertTrue(usernameExists);
		usernameExists = false;

		try {
			service.signup(testUser2.getUsername(),
					testUser2.getFirstName(),
					testUser2.getLastName(),
					testUser2.getEmail(),
					testUser2.getPassword(),
					testUser2.getPicture(),
					testUser2.getPromoCode());
		}
		catch(UsernameExistsException e){
			usernameExists = true;
		}

		assertFalse(usernameExists);
	}

	@Test
	public void testActivity()
	{
		log.info("testActivity");
	}
}
