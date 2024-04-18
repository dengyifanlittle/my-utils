package com.littledyf.cqs;

public class SpringBus implements Bus {

    private final Registry registry;

    public SpringBus(Registry registry) {
        this.registry = registry;
    }


    @Override
    public <R, Q extends Query<R>> R executeQuery(Q query) {
        QueryHandler<R, Q> queryHandler = (QueryHandler<R, Q>) registry.getQuery(query.getClass());
        return queryHandler.handle(query);
    }

    @Override
    public <E extends Event> void dispatchEvent(E event) {
        EventHandler<E> eventHandler = (EventHandler<E>) registry.getEvent(event.getClass());
        eventHandler.process(event);
    }
}