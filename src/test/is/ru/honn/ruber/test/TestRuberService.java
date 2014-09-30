package is.ru.honn.ruber.test;

import is.ru.honn.ruber.domain.History;
import is.ru.honn.ruber.domain.Trip;
import is.ru.honn.ruber.domain.User;
import is.ru.honn.ruber.service.*;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Runs tests on a RuberService to make sure that everything works correctly.
 * Gets mock objects and the name of the RuberService from /res/app-test-stub.xml
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/res/app-test-stub.xml"})
@DirtiesContext(classMode=DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
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

	/**
	 * Performs the necessary setup for the tests
	 * @throws Exception Thrown if there is an error
	 */
	@Before
	public void setUp() throws Exception
	{

	}

	/**
	 * Tests the methods signup(), getUsers() and getUser() in a given RuberService implementation
	 */
	@DirtiesContext
	@Test
	public void testUser()
	{
		log.info("testUser");

		//Try to get users from an empty list
		List<User> tempList = new ArrayList<User>();

		try{
			tempList = service.getUsers(0).getUsers();
		}
		catch (ServiceException e){

		}

		assertTrue(tempList.isEmpty());

		//Test adding users to the service
		addTestUsers();

		//Try to get users from a non-empty list
		try{
			tempList = service.getUsers(0).getUsers();
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
	 * Tests the methods addTrip() and getHistory() in a given RuberService implementation
	 */
	@DirtiesContext
	@Test
	public void testActivity()
	{
		log.info("testActivity");

		boolean exceptionThrown = false;
		History tempHistory = null;

		//Try to get the history of a user when there are no users ready
		try{
			tempHistory = service.getHistory(testUser1.getUsername());
		}
		catch(UserNotFoundException e){
			exceptionThrown = true;
		}

		assertTrue(exceptionThrown);
		assertNull(tempHistory);
		tempHistory = null;
		exceptionThrown = false;

		//Try to add a trip when there are no users ready
		try{
			service.addTrip(testUser1.getUsername(), new Trip());
		}
		catch(UserNotFoundException e){
			exceptionThrown = true;
		}

		assertTrue(exceptionThrown);
		exceptionThrown = false;


		//Add a user
		service.signup(	testUser1.getUsername(),
						testUser1.getFirstName(),
						testUser1.getLastName(),
						testUser1.getEmail(),
						testUser1.getPassword(),
						testUser1.getPicture(),
						testUser1.getPromoCode());

		//Try to get the history of a user that has no trips
		try{
			tempHistory = service.getHistory(testUser1.getUsername());
		}
		catch(UserNotFoundException e){
			exceptionThrown = true;
		}

		assertFalse(exceptionThrown);
		assertNotNull(tempHistory);
		assertTrue(tempHistory.getHistory().isEmpty());
		tempHistory = null;
		exceptionThrown = false;


		//Try to add a trip for an existing user
		try{
			service.addTrip(testUser1.getUsername(), new Trip());
		}
		catch(UserNotFoundException e){
			exceptionThrown = true;
		}

		assertFalse(exceptionThrown);
		exceptionThrown = false;

		//Try to get the history of a user that has 1 trip
		try{
			tempHistory = service.getHistory(testUser1.getUsername());
		}
		catch(UserNotFoundException e){
			exceptionThrown = true;
		}

		assertFalse(exceptionThrown);
		assertNotNull(tempHistory);
		assertFalse(tempHistory.getHistory().isEmpty());
		assertEquals(1, tempHistory.getHistory().size());
		tempHistory = null;
		exceptionThrown = false;

		//Try to add a trip for a non-existing user
		try{
			service.addTrip(testUser3.getUsername(), new Trip());
		}
		catch(UserNotFoundException e){
			exceptionThrown = true;
		}

		assertTrue(exceptionThrown);
		exceptionThrown = false;

		//Try to add a second trip for an existing user
		try{
			service.addTrip(testUser1.getUsername(), new Trip());
		}
		catch(UserNotFoundException e){
			exceptionThrown = true;
		}

		assertFalse(exceptionThrown);
	}
}
