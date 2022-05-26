package com.shinho.coding.java8.functionalinterface.stream;

import com.shinho.coding.java8.functionalinterface.optional.Progress;

import java.util.Optional;

public class OnlineClass {
    private Integer id;
    private String title;
    private boolean closed;

    Progress progress;

    public OnlineClass(Integer id, String title, boolean closed) {
        this.id = id;
        this.title = title;
        this.closed = closed;
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

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    /* 옵셔널은 리턴 타입으로만 사용하자. 필드로도 사용하지 말것 */
    public Optional<Progress> getProgress() {
        return Optional.ofNullable(progress);
    }

    public void setProgress(Progress progress) {
        this.progress = progress;
    }
}
