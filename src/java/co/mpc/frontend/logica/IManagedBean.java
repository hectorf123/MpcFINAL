/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mpc.frontend.logica;

/**
 *
 * @author Juank
 */
public interface IManagedBean<T> {
    T getObjectByKey(Integer key);
}
