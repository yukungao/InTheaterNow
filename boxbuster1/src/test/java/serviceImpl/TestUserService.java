package serviceImpl;

import org.apache.log4j.spi.LoggerFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.util.Assert;

import com.yukun.boxbuster1.entity.User;
import com.yukun.boxbuster1.entity.impl.UserImpl;
import com.yukun.boxbuster1.service.UserService;

@ContextConfiguration(locations = {"classpath:spring-context.xml"})
public class TestUserService extends AbstractJUnit4SpringContextTests  {
	
	
	@Autowired
	private UserService userService;

	@Test
	public void addAndGetUser(){
		UserImpl newUser = new UserImpl();
		newUser.setFirstName("kun");
		newUser.setLastName("gao");
		newUser.setBalance(100.0);
		newUser.setUserAddress("Descanso");
		
		User added = userService.addUser(newUser);
		
		Assert.assertNotEquals(0, added.getId());//this should have been created so not zero anymore
		Assert.assertEquals(newUser.getFirstName(), added.getFirstName());
		Assert.assertEquals(newUser.getLastName(), added.getLastName());
		Assert.assertEquals(newUser.getUserAddress(), added.getUserAddress());

		
		User found = userService.getUser(added.getId());
		Assert.assertEquals(found.getId(), added.getId());
		Assert.assertEquals(found.getFirstName(), added.getFirstName());
		Assert.assertEquals(found.getLastName(), added.getLastName());
		Assert.assertEquals(found.getUserAddress(), added.getUserAddress());

	}
	
}