package com.brandonllong.pwkeeper;

/**
 *
 * /\\\\\\\\\\\\    /\\\              /\\\\\\\\\\\    /\\\\\     /\\\    /\\\\\\\\\\\
 * \/\\\////////\\\ \/\\\            /\\\\////////\\\ \/\\\\\\   \/\\\  /\\\\////////\\\
 *  \/\\\      \/\\\ \/\\\           \/\\\       \/\\\ \/\\\/\\\  \/\\\ \/\\\       \///
 *   \/\\\\\\\\\\\\/  \/\\\           \/\\\       \/\\\ \/\\\//\\\ \/\\\ \/\\\
 *    \/\\\///////\\\\ \/\\\           \/\\\       \/\\\ \/\\\\//\\\\/\\\ \/\\\     /\\\\\\
 *     \/\\\      \/\\\ \/\\\           \/\\\       \/\\\ \/\\\ \//\\\/\\\ \/\\\    \////\\\
 *      \/\\\      \/\\\ \/\\\           \/\\\       \/\\\ \/\\\  \//\\\\\\ \/\\\       \/\\\
 *       \/\\\\\\\\\\\\/  \/\\\\\\\\\\\\\ \/\/\\\\\\\\\\\/  \/\\\   \//\\\\\ \/\/\\\\\\\\\\\/
 *        \////////////    \/////////////    \///////////    \///     \/////    \///////////
 *
 * Created by brandonlong on 4/29/16.
 */
public class Wallet {

        private int id;
        private String description;
        private String password;

        public Wallet(){
            id=0;
            description="";
            password="";
        }
        public int getId(){
            return id;
        }
        public void setId(int id){
            this.id=id;
        }
        public String getDescription(){
            return description;
        }
        public void setDescription(String description){
            this.description=description;
        }
        public String getPassword(){
            return password;
        }
        public void setPassword(String password) {
            this.password=password;
        }

}
