package rmi;

import org.junit.Test;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * Created by gezz on 2019/1/16.
 */
public class RmiServer {

    public static void main(String[] args) throws RemoteException, NamingException, MalformedURLException {
        WareHouse wareHouse = new WareHouseImpl();
        WareHouse centWareHouse = new CentWareHouseImpl();
        LocateRegistry.createRegistry(1099);
//        InitialContext initialContext = new InitialContext();
//        initialContext.bind("rmi:centWareHouse",centWareHouse);
//        initialContext.bind("rmi:wareHouse",wareHouse);

        //另外一种发布对象的方法
        Naming.rebind("rmi://127.0.0.1:1099/centWareHouse",centWareHouse);
        Naming.rebind("rmi://127.0.0.1:1099/wareHouse",wareHouse);
        System.out.println("等待接收远程调用请求...");
    }

}
