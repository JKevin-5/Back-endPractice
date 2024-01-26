package com.test.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Jkevin
 * @date 2022年10月11日 21:42
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int uid;
    private String name;
    private int age;
    private String sex;
}
