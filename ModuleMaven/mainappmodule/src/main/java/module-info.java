/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

module com.baeldung.mainppmodule {
    
    requires com.baeldung.entitymodule;
    requires com.baeldung.daomodule;
    requires com.baeldung.userdaomodule;
    uses com.baeldung.userdaomodule.UserDao;

}