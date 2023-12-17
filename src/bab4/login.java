/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bab4;

/**
 *
 * @author user
 */
public class login{
    private String username,password;
    public String nama;
    
    public login (){
        nama = "Ramdhan Saviola Zulkifly";
        username = "Dhan1";
        password = "Dhan123";
    }
    public String getUsername(){
        return username;
    }
    public void setUsername (String username){
    this.username = username ;
}
     public String getpassword(){
        return password;
    }
      public void setpassword(String password){
    this.password = password ;
}
      boolean ceklogin(String username,String password ){
          if(username.equals(getUsername()) && password.equals(getpassword())){
              return true;
          }
          return false ;
      }
}
