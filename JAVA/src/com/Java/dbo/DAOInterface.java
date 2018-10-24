package com.Java.dbo;

import java.util.List;

public interface DAOInterface<T> {
        T addNew(T t);
        List<T> getAll();
    }