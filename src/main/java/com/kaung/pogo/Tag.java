package com.kaung.pogo;

import lombok.Data;

@Data

public class Tag {
    private int id;
    private String tag_name;
    private String create_person;
    private String create_time;

    public Tag() {
    }

    public Tag(int id, String tag_name, String create_person, String create_time) {
        this.id = id;
        this.tag_name = tag_name;
        this.create_person = create_person;
        this.create_time = create_time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTag_name() {
        return tag_name;
    }

    public void setTag_name(String tag_name) {
        this.tag_name = tag_name;
    }

    public String getCreate_person() {
        return create_person;
    }

    public void setCreate_person(String create_person) {
        this.create_person = create_person;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }
}
