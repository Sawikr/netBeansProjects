// Definicja modułu z funkcjami
module appfuncs {   
  // Eksportuje pakiet appfuncs.simplefuncs.
  //exports appfuncs.simplefuncs; 

  
    // Eksportuje pakiet appfuncs.simplefuncs do modułu appstart
    exports appfuncs.simplefuncs to appstart;   
  
  
  // Uwaga! Poniższą instrukcję należy odkomentować po dodaniu do aplikacji modułu appsupport
  // Wymaga modułu appsupport i zapewnia, że będzie on publicznie dostępny 
   requires transitive appsupport; 

}
