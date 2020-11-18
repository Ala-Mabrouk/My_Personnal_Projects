package com.example.quizapplication;

import java.util.Random;

public class TabQuestions {

   public  Questions infoQ[]={

           new Questions( "Which of the following circuits is used as “Memory devices” on computers?",
                   "Flip Flop","Comparator","Attenuator","boo","Flip Flop")
        ,
           new Questions("HTTP is a protocol located in the ________?",
                   "Application layer","Transport layer","Network layer","boo","Application layer"),

           new Questions(" DHCP is used in______?",
                   "IPv6","IPv4","IPv6 et IPv4","none of them","IPv6 et IPv4"),

           new Questions("When two strings are exactly equivalent, strcmp () returns what?",
                   "Returns a string","returns 0","returns 1","returns nothing","returns 0"),

           new Questions("Which of these operators is used to allocate memory for an object?",
                   "malloc","alloc","new","realloc","new"),

           new Questions("Which of the following maintains a list of database drivers in JDBC?",
                   "DriverManager","JDBC driver","Connection","Statement","DriverManager"),

           new Questions("What signal is sent by the command \"kill -9\"?",
                   "TERM","STOP","KILL","INT","KILL"),

    };
    public  Questions cultureQ[]={

            new Questions("who is the headmaster of ISIMA",
                    "Mr Fniech","Mr Hssari","Mrs Zarboot","no one","Mr Fniech"),

            new Questions("which is the n°1 serie in IMDB ",
                    "Breaking Bad","Planet Earth II","Band of Brothers "," Game Of Thrones","Planet Earth II"),

            new Questions("what is python 2 ?",
                    "a snake ","programing language","nik name","it depends","it depends"),
            new Questions("who is warrior107 ?",
                    "nobody","a vedio gamer","a develloper","smthg else","smthg else")
    };

    public  Questions sportQ[]={

            new Questions( "In bowling, what is the perfect score (for twelve consecutive strikes)?",
                    "350 points","300 points","400 points","boo","300 points")
            ,
            new Questions("The Olympic Games (summer or winter) are organized evrey ?",
                    "Every five years","Every four years","Evrey year","boo","Every four years"),

            new Questions("The FIFA World Cup takes place evrey ?",
                    "Every four years","Every year","Every five years","boo","Every four years"),

            new Questions("Before a sumo bout, what do wrestlers throw in the bout area?",
                    "Sand","water","Salt","boo","Salt"),

            new Questions("What is the distance of the marathon ?",
                    "42,195 km","50 km","30,1 km","boo","42,195 km")
    };

   public Questions[] getQestioninfo( ){
       shufulle(infoQ);
       return infoQ ;
   }
    public Questions[] getQestionculture( ){
        shufulle(cultureQ);
        return cultureQ ;
    }
    public Questions[] getQestionsport( ){
        shufulle(sportQ);
        return sportQ ;
    }

    //this methode to shufulle questions so they dont come in the same order evrey time
    private void shufulle(Questions tab[]){
       Questions aux;
       Random j=new Random();
        for (int i = 0; i <tab.length ; i++) {
            int var=j.nextInt(tab.length);
            aux=tab[var];
            tab[var]=tab[i];
            tab[i]=aux;

        }
    }
}

