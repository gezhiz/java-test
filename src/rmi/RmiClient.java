package rmi;

import org.junit.Test;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.rmi.RemoteException;

/**
 * Created by gezz on 2019/1/16.
 */
public class RmiClient {

    @Test
    public void client() throws NamingException, RemoteException {
        Context context = new InitialContext();
        String centWareHouseUrl = "rmi://localhost:1099/centWareHouse";
        WareHouse centWareHouse = (WareHouse) context.lookup(centWareHouseUrl);
        System.out.println(centWareHouse.getPrice("cent warehouse"));

        String wareHouseUrl = "rmi://localhost:1099/wareHouse";
        WareHouse wareHouse = (WareHouse) context.lookup(wareHouseUrl);
        System.out.println(wareHouse.getPrice("warehouse"));

    }
}
