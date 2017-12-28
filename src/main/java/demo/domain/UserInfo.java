package demo.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserInfo {
    private String username;
    private String address;

    public UserInfo(){}

    public UserInfo(String username, String address){
        this.username = username;
        this.address = address;
    }
}

//UserInfo can be created as a separate table, but unnecessary
//username and address are two columns, we just group them as userinfo
//annotate @Embeddable grouping
//in runninginformation, add @Embedded before userinfo
