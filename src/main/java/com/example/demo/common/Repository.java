package com.example.demo.common;

public interface Repository {
    
    public interface Get<T,ID>{
        T get(ID id);
    }

    public interface Add<T>{
        void add(T entity);
    }

    public interface Update<T, ID> extends Get<T,ID>{
        void update(T entity);
    }

    public interface Remove<T, ID> extends Get<T,ID>{
        void remove(T entity);
    }
    public interface All<T,ID> extends Add<T>, Update<T,ID>, Remove<T,ID>{

    }
}
