package models;

import org.junit.*;
import play.test.*;

public class UserTest extends UnitTest {

	@Before
	public void setUp(){
		Fixtures.deleteDatabase();
	}
	
	@Test
	public void testCreateUser(){
		
		//--crear y guardar usuario
		new User("usuario1", "secreto").save();
		
		//--encontrarlo por nombre de usuario
		User usuario1 = User.find("byUsername", "usuario1").first();
		
		//probamos
		assertNotNull(usuario1);
		assertEquals("usuario1", usuario1.username);
	}
	
}
