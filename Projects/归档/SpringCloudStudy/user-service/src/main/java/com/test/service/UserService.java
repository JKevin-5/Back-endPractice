package com.test.service;

import com.test.entity.User;
import org.springframework.stereotype.Service;

/**
 * @author Jkevin
 * @date 2022年10月11日 21:54
 */
@Service
public interface UserService {
    User getUserById(int uid);
}
