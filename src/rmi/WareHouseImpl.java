package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by gezz on 2019/1/16.
 */
public class WareHouseImpl implements WareHouse {

    public WareHouseImpl() throws RemoteException {
        //WareHouseImpl如果不继承UnicastRemoteObject，需要在构造方法中调用exportObject
        UnicastRemoteObject.exportObject(this,0);//端口0：任何合适的端口
    }

    @Override
    public Long getPrice(String name) throws RemoteException {
        System.out.println(name + ":");
        return 10000l;
    }
}
