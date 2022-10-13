package com.test.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Jkevin
 * @date 2022年10月12日 0:20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private int bid;
    private String title;
    private String desc;
}
