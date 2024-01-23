package com.demos.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("account")
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter @Setter
@EqualsAndHashCode
@ToString
public class Account {
    @Id
    private long accountId;
    @TextIndexed
    private String accountType;
    @TextIndexed
    private String accountName;
    @TextIndexed
    private String status;
    @Transient
    public static final String SEQUENCE_NAME="ACC_SEQ";
}
