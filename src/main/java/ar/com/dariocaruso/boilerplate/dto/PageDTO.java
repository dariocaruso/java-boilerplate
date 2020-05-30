package ar.com.dariocaruso.boilerplate.dto;

import java.util.List;

public class PageDTO<T> {
    private List<T> content;
    private Long totalElements;

    public PageDTO(List<T> content, Long totalElements) {
        this.content = content;
        this.totalElements = totalElements;
    }

    public List<T> getContent() {
        return content;
    }

    public Long getTotalElements() {
        return totalElements;
    }
}
