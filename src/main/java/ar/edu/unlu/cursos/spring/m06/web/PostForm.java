package ar.edu.unlu.cursos.spring.m06.web;

import ar.edu.unlu.cursos.spring.m06.entity.Post;
import ar.edu.unlu.cursos.spring.m06.entity.Tag;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class PostForm {
    private long id;

    @NotNull
    @NotEmpty
    @Size(max = 50)
    private String title;

    @NotNull
    @NotEmpty
    @Size(max = 1200)
    private String content;

    @NotNull
    @NotEmpty
    @Size(max = 200)
    private String strTags;

    public PostForm() {
        super();
    }

    public PostForm(Post post) {
        super();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.strTags = tagsToStr(post.getTags());
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getStrTags() {
        return strTags;
    }

    public void setStrTags(String strTags) {
        this.strTags = strTags;
    }

    public String[] getTags() {
        return parseTagsStr(strTags);
    }

    /**
     * Function that goes from the model representation to a comma separated string representation
     *
     * @param tags the list of tags to be converted
     * @return A string containing all the tags separated by comma (';')
     */
    private String tagsToStr(List<Tag> tags) {
        StringBuilder strb = new StringBuilder();
        for (int i = 0; i < tags.size(); i++) {
            strb.append(tags.get(i).toString());
            if (i != tags.size() - 1)
                strb.append(';');
        }
        return strb.toString();
    }

    /**
     * Function that explodes a string containing comma separated tags (';')
     *
     * @param tagsStr the string containing the tags
     * @return tags in the string
     */
    private String[] parseTagsStr(String tagsStr) {
        String[] tags = tagsStr.split(";");
        return tags;
    }
}
