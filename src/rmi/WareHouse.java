package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by gezz on 2019/1/16.
 */
public interface WareHouse extends Remote {
    Long getPrice(String houseName) throws RemoteException;
}
