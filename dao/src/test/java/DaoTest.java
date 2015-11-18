 /**
 * Created by Drazz on 18.11.2015.
 */

import com.epam.training.pas.dao.UserDao;
import com.epam.training.pas.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"../resources/spring-context.xml"})
public class DaoTest {

    @Autowired
    private UserDao userDao;


    @Test
    public void testInsert() {

        User u = new User();
        u.setUsername("test");
        u.setPassword("test");
       // userDao.save(u);
        assertEquals(userDao.save(u), 1);

    }
/*
    @Test
    public void testSampleServiceGetAccountDescription() {
        // Check if the return description has a Description: string.
        assertTrue(sampleService.getOrderDescription().contains("Description:"));
    }

    @Test
    public void testSampleServiceGetAccountCode() {
        // Check if the return description has a Code: string.
        assertTrue(sampleService.getOrderStringCode().contains("Code:"));
    }

    @Test
    public void testSampleServiceCreateNewOrder() {
        Order newOrder = new Order();
        newOrder.setSecurityCode("XYZ");
        newOrder.setDescription("Description");
        if (newOrder != null) {
            assertThat(sampleService.createOrder(newOrder),
                instanceOf(Order.class));
            assertNotNull("Security isn't null", newOrder.getSecurityCode());
            assertNotNull("Description isn't not null",
                newOrder.getDescription());
        }

        assertNotNull("New Order is not null", newOrder);

    }

    @Test
    public void testSampleServiceGetOrder() {

        Order existingOrder = sampleService.getOrder(0);

        if (existingOrder != null) {
            assertThat(sampleService.getOrder(0), instanceOf(Order.class));
            assertNotNull("Security isn't null",
                existingOrder.getSecurityCode());
            assertNotNull("Description isn't null",
                existingOrder.getDescription());
        }

        assertNotNull("Object is not null", existingOrder);
    }*/

}