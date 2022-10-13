package com.test.service;

import com.test.entity.UserBorrowDetail;

/**
 * @author Jkevin
 * @date 2022年10月13日 22:15
 */
public interface BorrowService {

    UserBorrowDetail getUserBorrowDetailByUid(int uid);
}
