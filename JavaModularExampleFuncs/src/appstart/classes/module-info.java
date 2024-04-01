/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

module appstart {
    
    //Wymaga modułów appfuncs i userfuncs
    requires userfuncsimp;
    requires userfuncs;
    
    //Teraz moduł appstart używa dostawcy typu BinFuncProvider
    uses userfuncs.binaryfuncs.BinFuncProvider;
}