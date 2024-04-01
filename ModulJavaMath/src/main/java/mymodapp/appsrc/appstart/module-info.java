// Definicja głównego modułu aplikacji
module appstart {         
  // Wymaga modułu appfuncs
    requires appfuncs; 

  //* // Uwaga. Poniższe instrukcje są niezbędne dla dla aplikacji MyModAppDemo3
    requires userfuncs; 
   
    // Teraz moduł appstart używa dostawcy typu BinFuncProvider 
    uses userfuncs.binaryfuncs.BinFuncProvider; 
  //*/
}
