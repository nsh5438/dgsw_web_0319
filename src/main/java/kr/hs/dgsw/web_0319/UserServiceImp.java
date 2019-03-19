package kr.hs.dgsw.web_0319;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class UserServiceImp implements UserService{

   List<User> userlist;

    public UserServiceImp(){
        userlist = new ArrayList<>();
        userlist.add(new User("user1","user1@dgsw.hs.kr","user1id"));
        userlist.add(new User("user2","user2@dgsw.hs.kr","user2id"));
        userlist.add(new User("user3","user3@dgsw.hs.kr","user3id"));

    }
    @Override
    public List<User> list() {
        return this.userlist;
    }

    @Override
    public User view(String id) {
       return this.userlist.stream()
                .filter(user -> user.getUserid().equals(id))
                .findAny()
                .orElse(null);
    }
    public User find(String name){
        Iterator<User> useritem = this.userlist.iterator();
        while(useritem.hasNext()){
            User  user = useritem.next();
            if(user.getName().equals(name))
                return user;
        }
        return null;
    }
    public User find1(String name){
        for(User user : this.userlist){
            if(user.getName().equals(name))
                return user;
        }
        return null;
    }
    public User find2(String name){
        for (int i=0 ; i<this.userlist.size();i++){
            User found = this.userlist.get(i);
            if(found.getName().equals(name))
                return found;
        }
        return null;

    }


    @Override
    public boolean add(User user) {
        if (Idcheck(user.getUserid())){
            return this.userlist.add(user);
        }
        return false;
    }

    public boolean Idcheck(String id){
        for(User user : this.userlist){
            if(user.getUserid().equals(id)){
                return false;
            }
        }
        return true;
    }

    @Override
    public User update(User user) {
        User found = this.view(user.getUserid());
        if(found != null){
            found.setName(user.getName());
            found.setEmail(user.getEmail());
        }
        return found;
    }

    @Override
    public  boolean delete(String id){
        User found = this.view(id);
        return this.userlist.remove(found);
    }
}
//GET(READ) POST(INSERT) PUT(UPDATE) DELETE(DELETE)
