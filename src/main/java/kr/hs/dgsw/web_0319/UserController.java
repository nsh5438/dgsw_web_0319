package kr.hs.dgsw.web_0319;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/User")
    @ResponseBody
    public List<User> list(){
        return userService.list();
    }

    @GetMapping("/User/{name}")
    public User view(@PathVariable String name){
        return this.userService.view(name);
    }

    @PostMapping("/post")
    @ResponseBody
    public boolean add(@RequestBody  User user){
        return this.userService.add(user);
    }

    @PutMapping("/update")
    @ResponseBody
    public User update(@RequestBody User user) {
        return this.userService.update(user);
    }

    @DeleteMapping("/delete/{name}")
    @ResponseBody
    public boolean delete(@PathVariable String name){
        return this.userService.delete(name);
    }
}

