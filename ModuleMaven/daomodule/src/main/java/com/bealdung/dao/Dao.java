/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Radosław Sawicki
 */
package com.baeldung.daomodule;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {

    Optional<T> findById(int id);
    List<T> findAll();

}