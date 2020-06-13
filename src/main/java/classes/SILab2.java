package classes;

import java.util.List;

public class SILab2 {

    public boolean function (User user, List<String> allUsers) {
        if (user!=null) {
            if (user.getUsername()!=null && user.getEmail()!=null && !allUsers.contains(user.getUsername())) {
                boolean atChar = false, dotChar = false;
                for (int i=0;i<user.getEmail().length();i++) {
                    if (user.getEmail().charAt(i)=='@')
                        atChar = true;
                    if (atChar && user.getEmail().charAt(i)=='.') {
                        dotChar = true;
                    }
                }
                if (atChar && dotChar) {
                    return true;
                }
            }
        }
        return false;
    }
}
