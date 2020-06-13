package classes;

import java.util.ArrayList;
import java.util.List;


import static org.junit.Assert.*;
import org.junit.Test;
class SILab2Test {
    public final SILab2 siLab2 = new SILab2();
    @Test
    void everyBranch() {
        assertFalse(siLab2.function(null,new ArrayList<>()));
        List list = new ArrayList<>();
        list.add("Ryder");
        assertFalse(siLab2.function(new User("Ryder","password","email"),list));
        assertTrue(siLab2.function(new User("Carl","password","johnson@email.com"),list));
    }
    @Test
    void multipleCondition() {

        /*(user.getUsername()!=null && user.getEmail()!=null && !allUsers.contains(user.getUsername()))*/
        List list = new ArrayList<>();
        list.add("Ryder");
        User u = new User("Ryder","password","email");
        assertFalse(siLab2.function(u,new ArrayList<>()));
        assertFalse(siLab2.function(u,list));
        u = new User(null,"password","email");
        assertFalse(siLab2.function(u,new ArrayList<>()));
        u = new User("Ryder",null,"email");
        assertFalse(siLab2.function(u,new ArrayList<>()));

        /*(atChar && user.getEmail().charAt(i)=='.')*/
        u = new User("Ryder","password","email@");
        assertFalse(siLab2.function(u,new ArrayList<>()));
        u = new User("Ryder","password","email@.");
        assertTrue(siLab2.function(u,new ArrayList<>()));
        u = new User("Ryder","password","email");
        assertFalse(siLab2.function(u,new ArrayList<>()));

        /*(atChar && dotChar)*/
        u = new User("Ryder","password","email@");
        assertFalse(siLab2.function(u,new ArrayList<>()));
        u = new User("Ryder","password","email@.");
        assertTrue(siLab2.function(u,new ArrayList<>()));
        u = new User("Ryder","password","email");
        assertFalse(siLab2.function(u,new ArrayList<>()));
    }
}