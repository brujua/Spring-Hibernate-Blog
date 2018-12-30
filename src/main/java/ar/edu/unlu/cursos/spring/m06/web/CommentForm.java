package ar.edu.unlu.cursos.spring.m06.web;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CommentForm {

    @Size(max = 20)
    @NotNull
    @NotEmpty
    private String author;

    @Size(max = 550)
    @NotNull
    @NotEmpty
    private String comment;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
