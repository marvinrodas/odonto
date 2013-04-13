package models;

import org.junit.*;
import play.test.*;

import java.util.*;

public class UsuarioTest extends UnitTest {

	@Before
	public void setUp(){
		Fixtures.deleteDatabase();
	}
	
	@Test
	public void testCreateUsuario(){
		//--creamos un tipodeusuario
		Tipousuario tu = new Tipousuario("dentista").save();
		
		assertNotNull(tu);
		assertEquals(1, tu.count());
		
		//--creamos un usuario
		new Usuario("usr1", "usr1", "secreto", "user1@gmail.com", tu).save();
		
		//--contamos todos los usuarios
		List<Usuario> usuario = Usuario.getTodos();

		
		//--las pruebas
		assertNotNull( usuario);
		assertEquals(1, usuario.size());
		assertEquals("usr1", usuario.get(0).name);
		
	}
	
}
