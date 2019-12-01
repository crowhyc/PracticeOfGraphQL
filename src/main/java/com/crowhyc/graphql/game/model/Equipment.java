package com.crowhyc.graphql.game.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * <p>
 * Description: com.crowhyc.graphql.game.model
 * </p>
 * date：2019/12/1
 * email:crowhyc@163.com
 *
 * @author Dean.Hwang
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Equipment {
    private String id;
    private String name;
    private int lvLimit;
    private int durability;
    private LocalDateTime createTime;
}
