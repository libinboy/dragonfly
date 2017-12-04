package com.dragonfly.boot.site.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/12/4 0004.
 */
@TableName("t_joke")
public class Joke implements Serializable
{

    @TableId(value = "joke_id", type = IdType.AUTO)
    private Integer jokeId;

    @TableField("joke_content")
    private String jokeContent;

    public Integer getJokeId()
    {
        return jokeId;
    }

    public void setJokeId(Integer jokeId)
    {
        this.jokeId = jokeId;
    }

    public String getJokeContent()
    {
        return jokeContent;
    }

    public void setJokeContent(String jokeContent)
    {
        this.jokeContent = jokeContent;
    }

    @Override public String toString()
    {
        return "Joke{" + "jokeId=" + jokeId + ", jokeContent='" + jokeContent + '\'' + '}';
    }
}
