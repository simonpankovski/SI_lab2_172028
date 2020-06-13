# SI_lab2_172028

## Симон Панковски, 172028

## Група на код:
Ја добив групата на код 1

## Control Flow Graph

https://imgur.com/a/Z2Ez4Yp

## Цикломатска комплексност
Цикломатската комплексност на овој код е 7, истата ја добив преку формулата P+1, каде што P е бројот на предикатни јазли. Во случајoв P=6, па цикломатската комплексност изнесува 7.


## Тест случаи според критериумот Multiple condition

(user.getUsername()!=null && user.getEmail()!=null && !allUsers.contains(user.getUsername()))
(atChar && user.getEmail().charAt(i)=='.')
(atChar && dotChar)

T && T && F 	user.getUsername()!=null && user.getEmail() != null && allUsers.contains(user.getUsername()) == false
T && T && T 	user.getUsername()!=null && user.getEmail()!= null && allUsers.contains(user.getUsername()) == true
F && X && X 	user.getUsername()==null && user.getEmail()!= anything && allUsers.contains(user.getUsername()) == anything
T && F && X 	user.getUsername()!=null && user.getEmail()== null && allUsers.contains(user.getUsername()) == anything


T && F			atChar==true && user.getEmail().charAt(i)!='.'
T && T			atChar==true && user.getEmail().charAt(i)=='.'
F && X			atChar==false && user.getEmail().charAt(i)==anything

T && F			atChar==true && dotChar=false
T && T			atChar==true && dotChar=true
F && X			atChar==false && dotChar=anything



## Тест случаи според критериумот Every branch

Criterium 1: user==null,allUsers=anything
Criterium 2: allUsers = [Ryder, Robin, Lee, Jenkins]  User = {username: Ryder, email: ryderboss, password: password }
Criterium 3: allUsers = [Ryder, Robin, Lee, Jenkins]  User = {username: Carl, email: cjjohnson@gmail.com, password: password }




Branch			Criterium 1		Criterium 2		Criterium 3

1,2-3							*				*
1,2-17			*								
17-18			*				*				
3- 4											*
3-15,16							*				
16-17							*				
4-5.1											*
5.1-5.2											*
5.2-12											*
5.2-6											*
6-7 											*
7-8 											*
6-8 											*
8-9 											*
8-10 											*
9-10											*
10-11 											*
11-5.3 											*
5.3-5.2 										*
12-14,15 										*
12-13 											*
13-18 											*





## Објаснување на напишаните unit tests
 Gi koristev kriteriumite od pogore dobienite rezultati i pravev sporedba na ocekuvaniot output i toa sto go dobiv pri resavanje na baranjata

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