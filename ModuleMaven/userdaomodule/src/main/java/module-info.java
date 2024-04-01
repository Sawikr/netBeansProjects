/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

module com.baeldung.userdaomodule {
    requires com.baeldung.entitymodule;
    requires com.baeldung.daomodule;
    provides com.baeldung.daomodule.Dao with com.baeldung.userdaomodule.UserDao;
    exports com.baeldung.userdaomodule;
}