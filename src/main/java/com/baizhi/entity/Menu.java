package com.baizhi.entity;

import java.io.Serializable;
import java.util.List;

public class Menu implements Serializable {
    private Integer id;
    private String title;
    private String content;
    private String href;
    private String iconCls;
    private List<Menu> children;

    @Override
    public String toString() {
        return "Menu{" + "id=" + id + ", title='" + title + '\'' + ", content='" + content + '\'' + ", href='" + href + '\'' + ", iconCls='" + iconCls + '\'' + ", children=" + children + '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }

    public Menu(Integer id, String title, String content, String href, String iconCls, List<Menu> children) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.href = href;
        this.iconCls = iconCls;
        this.children = children;
    }

    public Menu() {
    }
}
