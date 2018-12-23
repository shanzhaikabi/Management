package com.ssh.service;

import com.ssh.entity.User;
import org.springframework.web.servlet.ModelAndView;

public interface UserService {
    ModelAndView register(User user);
}
