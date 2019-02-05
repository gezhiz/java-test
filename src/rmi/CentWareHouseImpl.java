package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by gezz on 2019/1/16.
 */
public class CentWareHouseImpl extends UnicastRemoteObject implements WareHouse {

    public CentWareHouseImpl() throws RemoteException {
    }

    @Override
    public Long getPrice(String name) throws RemoteException {
        System.out.println(name);
        return 5000l;
    }
}
