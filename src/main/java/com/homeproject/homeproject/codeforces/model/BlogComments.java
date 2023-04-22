package com.homeproject.homeproject.codeforces.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BlogComments {
    public String id;
    public String creationTimeSeconds;
    public String commentatorHandle;
    public String locale;
    public String text;
    public String parentCommentId;
    public String rating;
}
