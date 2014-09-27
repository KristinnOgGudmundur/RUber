package is.ru.honn.ruber.test;

import is.ru.honn.ruber.domain.User;
import is.ru.honn.ruber.service.*;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/res/app-test-stub.xml"})
public class TestRuberService extends TestCase
{

	Logger log = Logger.getLogger(TestRuberService.class.getName());

	@Autowired
	private RuberService service;

	//A user to test signup logic
	@Autowired
	private User testUser1;

	//A user to test signup logic
	@Autowired
	private User testUser2;

	//This user should never be signed up
	@Autowired
	private User testUser3;

	@Before
	public void setUp() throws Exception
	{

	}

	/**
	 * Tests the methods signup(), getUsers() and getUser() in a given RuberService implementation
	 */
	@Test
	public void testUser()
	{
		log.info("testUser");

		//Try to get users from an empty list
		List<User> tempList = new ArrayList<User>();

		try{
			tempList = service.getUsers(0);
		}
		catch (ServiceException e){

		}

		assertTrue(tempList.isEmpty());

		//Test adding users to the service
		addTestUsers();

		//Try to get users from a non-empty list
		try{
			tempList = service.getUsers(0);
		}
		catch (ServiceException e){

		}

		assertFalse(tempList.isEmpty());
	}

	private void addTestUsers(){
		boolean exceptionThrown = false;

		//Try to get a user from an empty database
		try{
			service.getUser(testUser1.getUsername());
		}
		catch(UserNotFoundException e){
			exceptionThrown = true;
		}

		assertTrue(exceptionThrown);
		exceptionThrown = false;

		//Try to sign up a user
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
			exceptionThrown = true;
		}

		assertFalse(exceptionThrown);
		exceptionThrown = false;

		//Try to sign up an already existing user
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
			exceptionThrown = true;
		}

		assertTrue(exceptionThrown);
		exceptionThrown = false;

		//Try to sign up a new user
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
			exceptionThrown = true;
		}

		assertFalse(exceptionThrown);
		exceptionThrown = false;

		//Try to get a non-existing user from a non-empty user service
		try{
			service.getUser(testUser3.getUsername());
		}
		catch(UserNotFoundException e){
			exceptionThrown = true;
		}

		assertTrue(exceptionThrown);
		exceptionThrown = false;

		//Try to get an existing user
		try{
			service.getUser(testUser1.getUsername());
		}
		catch(UserNotFoundException e){
			exceptionThrown = true;
		}

		assertFalse(exceptionThrown);

	}

	/**
	 * Tests the methods addTrips() and getHistory() in a given RuberService implementation
	 */
	@Test
	public void testActivity()
	{
		//TODO: Implement
		log.info("testActivity");


	}
}
