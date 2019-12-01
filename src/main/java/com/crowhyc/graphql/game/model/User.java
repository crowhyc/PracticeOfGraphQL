package com.crowhyc.graphql.game.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * Description: com.crowhyc.graphql.game
 * </p>
 * date：2019/12/1
 * email:crowhyc@163.com
 *
 * @author Dean.Hwang
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String name;
    private int hp;
    private int lv;
    private int exp;
    //    private List<Equipment> equipments;
    @ElementCollection
    private List<String> friends;
    private LocalDateTime createTime;
//    private Occupation occupation;


}
