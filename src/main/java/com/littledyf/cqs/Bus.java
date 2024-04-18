package com.littledyf.cqs;

/**
 * @description  消息总线
 */
public interface Bus {
    <R,Q extends Query<R>> R executeQuery(Q query);

    <E extends Event> void dispatchEvent(E event);
}
