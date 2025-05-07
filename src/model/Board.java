package model;

import java.security.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Board {
    private int id;
    private String title;
    private String content;
    private String writer;
    private Timestamp createdDate;
    
    // getter, setter
}