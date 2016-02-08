import com.becomejavasenior.dao.UserDAO;
import com.becomejavasenior.dao.impl.UserDAOImpl;
import com.becomejavasenior.model.User;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by Roman on 08.02.2016.
 */
public class UserDaoTest {
    UserDAO dao = null;


    @Test
    public void testSizeListUser() {
        dao = new UserDAOImpl();
        List<User> listUser;
        listUser = dao.getAllUser();
        Assert.assertEquals(5, listUser.size());
    }
}
