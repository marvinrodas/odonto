package models;

import java.util.*;

import org.junit.*;

import play.test.*;

public class MenuTest extends UnitTest {

	@Test
	public void ObtenerMenus(){
		
		//--crear un nuevo menu
		new Menu("Consulta",0,1,"consulta","Application","","" ).save();
		
		
		List<Menu> menu = Menu.getTodos();
		
		assertNotNull(menu);
		assertEquals(1,  menu.size());
		assertEquals("Consulta", menu.get(0).name);
		
	}
	
	
}
