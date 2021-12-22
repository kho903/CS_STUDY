package com.jikim.jpa.bookmanager.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

//@Getter
//@Setter
//@ToString
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
//@EqualsAndHashCode
@Data
@Builder
public class User {
    @NonNull
    private String name;
    @NonNull
    private String email;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
