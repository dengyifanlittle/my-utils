package com.littledyf.cqs;


/**
 * @description  事件处理器
 */
public interface EventHandler<E extends Event> {
    /**
     *
     * @param event  事件
     */
    void process(E event);
}